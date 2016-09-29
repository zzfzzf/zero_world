package com.zzy.gate;

import com.alibaba.fastjson.JSONObject;
import com.zzy.common.base.Command;
import com.zzy.common.base.ResultValue;
import com.zzy.common.base.UrlCommon;
import com.zzy.common.util.BroadcastUtil;
import com.zzy.common.util.HttpUtil;
import com.zzy.dubbo.db.DBService;
import com.zzy.dubbo.logic.*;
import com.zzy.dubbo.map.IMap;
import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Zeus
 * @version 1.1
 * @createTime：2016年7月20日
 * @decript: 逻辑处理类, 客户端请求进入里面
 */
public class GateHandler extends IoHandlerAdapter implements Command {
    private static Logger log = Logger.getLogger(GateHandler.class);
    private DBService dbService;
    private IStatus statusLogic;
    private ITrade tradeLogic;
    private IItem itemLogic;
    private IMoney moneyLogic;
    private IOther otherLogic;
    private IRole roleLogic;
    private IMonster monsterLogic;
    private IoAcceptor acceptor;
    private IMap mapLogic;
    public GateHandler(IoAcceptor acceptor) {
        this.acceptor = acceptor;
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationClient.xml"});
        context.start();
        dbService = (DBService) context.getBean("dbService");
        statusLogic = (IStatus) context.getBean("statusLogic");
        tradeLogic = (ITrade) context.getBean("tradeLogic");
        itemLogic = (IItem) context.getBean("itemLogic");
        moneyLogic = (IMoney) context.getBean("moneyLogic");
        otherLogic = (IOther) context.getBean("otherLogic");
        roleLogic = (IRole) context.getBean("roleLogic");
        monsterLogic = (IMonster) context.getBean("monsterLogic");
        mapLogic = (IMap) context.getBean("mapLogic");
    }

    // 当一个客户端连接进入时
    @Override
    public void sessionOpened(IoSession session) throws Exception {

    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {

    }

    ;

    /**
     * 捕捉异常
     */
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        log.error("错误session:" + session.getId() + "---->" + cause.getMessage());
    }

    /**
     * 当客户端发送消息到达时
     */
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        // 收到的信息字符串
        if (Objects.isNull(message) || "null".equals(message)) {
            log.error("错误session:" + session.getId() + "---->" + "message不能为null");
        }
        JSONObject json = JSONObject.parseObject((String) message);
        String command = (String) json.get("command");
        Long token = json.getLong("token");
        @SuppressWarnings("unchecked")
        Map<Long, String> tokens = (Map<Long, String>) dbService.getObj("tokens", Map.class);
        if (!tokens.containsKey(token) && !Command.TOKEN.equals(command)) {
            session.write(ResultValue.fail(ResultValue.TOKEN_ERROR, "token错误"));
            return;
        } else {
            String userName = json.getString("userName");
            JSONObject user = HttpUtil.getJson(UrlCommon.GET_USER_BY_USERNAME + userName);
            // 拿到json格式的user对象
            user = JSONObject.parseObject(user.get("data").toString());
            String userId = user.getString("id");
            // 当前用户存入token
            tokens.put(session.getId(), userId);
            // 获取大区列表并装入json
            HttpUtil.getJson(UrlCommon.LIST_AREA, json);
            session.write(ResultValue.success(json));
        }
        // 如果为null 则不广播 默认为广播
        IoAcceptor tempAcceptor = acceptor;
        List<Long> list = null;
        switch (command) {
            case ROLE:// 选择角色
                tempAcceptor = null;
                statusLogic.role(json);
                break;
            case AREA:// 选择大区
                tempAcceptor = null;
                statusLogic.area(json);
                break;
            case ONLINE_NUM: // 获取在线人数
                tempAcceptor = null;
                ResultValue.success(json,acceptor.getManagedSessionCount());
                break;
            case OFFLINE: // 角色下线
                statusLogic.offline(json);
                mapLogic.outMap(json);
                break;
            case MOVE: // 移动 暂定
                roleLogic.move(json);
                mapLogic.mapChange(json);
                break;
            case ATTACK: // 攻击 暂定
                roleLogic.attack(json);
                break;
            case ADD_ITEM: // 添加物品
                tradeLogic.addItem(json);
                break;
            case ADD_MONEY: // 添加金钱
                tradeLogic.addMoney(json);
                break;
            case CHAT: // 聊天
                roleLogic.chat(json);
                break;
            case CONFIRM_TRADE: // 确认交易
                tradeLogic.confirmTrade(json);
                break;
            case DESTROY_ITEM: // 销毁物品
                itemLogic.destroy(json);
                break;
            case GIVE_UP_ITEM: // 丢弃物品
                itemLogic.giveUpItem(json);
                break;
            case GIVE_UP_MONEY: // 丢弃金币
                moneyLogic.giveUpMoney(json);
                break;
            case PICK_UP_ITEM: // 拾取物品
                itemLogic.pickUpItem(json);
                break;
            case PICK_UP_MONEY: // 拾取金币
                moneyLogic.pickUpMoney(json);
                break;
            case PUT_ON_ITEM: // 装备物品
                itemLogic.putOn(json);
                break;
            case RIDE: // 骑乘
                roleLogic.ride(json);
                break;
            case SPLIT_ITEM: // 拆分物品
                itemLogic.splitItem(json);
                break;
            case SKILL: // 使用技能
                roleLogic.skill(json);
                break;
            case STALL: // 摆摊
                tradeLogic.stall(json);
                break;
            case TAKE_DOWN_ITEM: // 卸下物品
                itemLogic.takeDown(json);
                break;
            case USE_ITEM: // 使用物品
                itemLogic.useItem(json);
                break;
            case UPGRADE: // 升级
                roleLogic.upgrade(json);
                break;
            case ADD_EXP: // 增加经验
                roleLogic.addExp(json);
                break;
            case REDUCE_EXP:// 减少经验
                roleLogic.reduceExp(json);
                break;
            case MONSTER_DEATH: // 怪物死掉
                monsterLogic.monsterDeath(json);
                break;
            case MONSTER_PRODUCE: // 怪物生成
                monsterLogic.monsterProduce(json);
                break;
        }
        // 广播
        BroadcastUtil.sentMessage(list, tempAcceptor, session, json);
    }


    // 当一个客户端连接关闭时
    @Override
    public void sessionClosed(IoSession session) throws Exception {
        System.out.println("有客户端关闭" + session.getId());
    }


}