package com.zzy.gate.login;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import com.alibaba.fastjson.JSONObject;
import com.zzy.common.base.Command;
import com.zzy.gate.logic.Impl.ItemController;
import com.zzy.gate.logic.Impl.LoginController;
import com.zzy.gate.logic.Impl.MoneyController;
import com.zzy.gate.logic.Impl.OtherController;
import com.zzy.gate.logic.Impl.RoleController;
import com.zzy.gate.logic.Impl.TradeController;

/**
* @author Zeus
 * @version 1.1
 * @createTime：2016年7月20日
 * @decript: 逻辑处理类,客户端请求进入里面
 */
public class ServiceHandler extends IoHandlerAdapter implements Command{
	private static Logger log = Logger.getLogger(ServiceHandler.class);
	private LoginController loginController = new LoginController();
	private OtherController otherController = new OtherController();
	private MoneyController moneyController = new MoneyController();
	private ItemController itemController = new ItemController();
	private RoleController roleController = new RoleController();
	private TradeController tradeController = new TradeController();
	
	
	private IoAcceptor acceptor;
	public ServiceHandler(IoAcceptor acceptor) {
		this.acceptor=acceptor;
	} 

	// 当一个客户端连接进入时
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		long token = session.getId();
		session.write(token);
	}

	/**
	 * 捕捉异常
	 */
	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		log.error("错误session:"+session.getId()+"---->"+cause.getMessage());
	}

	/**
	 * 当客户端发送消息到达时
	 */
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		// 收到的信息字符串
		if(Objects.isNull(message) || "null".equals(message)){
			throw new NullPointerException("message不能为null");
		}
		JSONObject json = JSONObject.parseObject((String) message);
		String command = (String)json.get("command");  
		switch (command) {
		case LOGIN:
			// 登录逻辑
			loginController.login(json,session);
			break;
		case ONLINE_NUM:
			// 获取在线用户
			otherController.getOnlineNum(acceptor, session);
			break;
		case MOVE:
			// 移动
			otherController.getOnlineNum(acceptor, session);
			break;
		case ATTACK:
			// 攻击	
			otherController.getOnlineNum(acceptor, session);
			break;
		case ADD_ITEM:
			// 添加物品
			otherController.getOnlineNum(acceptor, session);
			break;
		case ADD_MONEY:
			// 添加金钱
			otherController.getOnlineNum(acceptor, session);
			break;
		case CHAT:
			// 聊天
			otherController.getOnlineNum(acceptor, session);
			break;
		case CONFIRM_TRADE:
			// 确认交易
			otherController.getOnlineNum(acceptor, session);
			break;
		case DESTROY_ITEM:
			// 销毁物品
			otherController.getOnlineNum(acceptor, session);
			break;
		case GIVE_UP_ITEM:
			// 丢弃物品
			otherController.getOnlineNum(acceptor, session);
			break;
		case GIVE_UP_MONEY:
			// 丢弃金币
			otherController.getOnlineNum(acceptor, session);
			break;
		case PICK_UP_ITEM:
			// 拾取物品
			otherController.getOnlineNum(acceptor, session);
			break;
		case PICK_UP_MONEY:
			// 拾取金币
			otherController.getOnlineNum(acceptor, session);
			break;
		case PUT_ON:
			// 装备物品
			otherController.getOnlineNum(acceptor, session);
			break;
		case RIDE:
			// 骑乘
			otherController.getOnlineNum(acceptor, session);
			break;
		case SPLIT_ITEM:
			// 拆分物品
			otherController.getOnlineNum(acceptor, session);
			break;
		case SKILL:
			// 使用技能
			otherController.getOnlineNum(acceptor, session);
			break;
		case STALL:
			// 摆摊
			otherController.getOnlineNum(acceptor, session);
			break;
		case TAKE_DOWN:
			// 卸下物品
			otherController.getOnlineNum(acceptor, session);
			break;
		case USE_ITEM:
			// 使用物品
			otherController.getOnlineNum(acceptor, session);
			break;
		}
		
	}


	// 当一个客户端连接关闭时
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		
	}
}
