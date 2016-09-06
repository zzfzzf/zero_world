package com.zzy.gate;

import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

import com.zzy.dubbo.logic.*;
import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.zzy.common.base.Command;
import com.zzy.common.base.ResultValue;
import com.zzy.common.base.UrlCommon;
import com.zzy.common.util.BroadcastUtil;
import com.zzy.common.util.HttpUtil;
import com.zzy.dubbo.DBService;

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

    public GateHandler(IoAcceptor acceptor) {
        this.acceptor = acceptor;
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationClient.xml"});
        context.start();
        dbService = (DBService) context.getBean("dbService");
        statusLogic=(IStatus) context.getBean("statusLogic");
        tradeLogic=(ITrade) context.getBean("tradeLogic");
        itemLogic=(IItem) context.getBean("itemLogic");
        moneyLogic=(IMoney) context.getBean("moneyLogic");
        otherLogic=(IOther) context.getBean("otherLogic");
        roleLogic=(IRole) context.getBean("roleLogic");
        monsterLogic=(IMonster) context.getBean("monsterLogic");
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
            session.write(ResultValue.onlySuccess(json));
        }


        switch (command) {
            case ROLE:// 选择角色
                HttpUtil.getJson(UrlCommon.GET_ROLE, json);
                session.write(json);
                break;
            case AREA:// 选择大区
                HttpUtil.getJson(UrlCommon.GET_ROLE_BY_AREA + json.getString("areaId"), json);
                session.write(json);
                break;
            case ONLINE_NUM: // 获取在线人数
                ResultValue.success(json).put("onlineNum", acceptor.getManagedSessionCount());
                session.write(json);
                break;
            case OFFLINE:

                break;
            case MOVE: // 移动

                break;
            case ATTACK: // 攻击
                // 处理攻击逻辑
                // 广播数据
                break;
            case ADD_ITEM:    // 添加物品

                break;
            case ADD_MONEY:// 添加金钱


                break;
            case CHAT:// 聊天


                break;
            case CONFIRM_TRADE:// 确认交易


                break;
            case DESTROY_ITEM:// 销毁物品


                break;
            case GIVE_UP_ITEM:// 丢弃物品


                break;
            case GIVE_UP_MONEY:// 丢弃金币


                break;
            case PICK_UP_ITEM:// 拾取物品


                break;
            case PICK_UP_MONEY:// 拾取金币


                break;
            case PUT_ON_ITEM:// 装备物品


                break;
            case RIDE:  // 骑乘


                break;
            case SPLIT_ITEM:// 拆分物品


                break;
            case SKILL:// 使用技能


                break;
            case STALL:// 摆摊


                break;
            case TAKE_DOWN_ITEM:// 卸下物品


                break;
            case USE_ITEM:// 使用物品

                break;
            case UPGRADE:// 升级

                break;
            case ADD_EXP:// 增加经验

                break;
            case REDUCE_EXP:// 减少经验

                break;
            case MONSTER_DEATH: // 怪物死掉

                break;
            case MONSTER_PRODUCE: // 怪物生成

                break;
        }
    }

    // 当一个客户端连接关闭时
    @Override
    public void sessionClosed (IoSession session)throws Exception {
        System.out.println("有客户端关闭" + session.getId());
    }
}