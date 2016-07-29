package com.zzy.gate.login;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.zzy.common.base.Command;
import com.zzy.logic.IItem;
import com.zzy.logic.ILogin;
import com.zzy.logic.IMoney;
import com.zzy.logic.IOther;
import com.zzy.logic.IRole;
import com.zzy.logic.ITrade;

/**
* @author Zeus
 * @version 1.1
 * @createTime：2016年7月20日
 * @decript: 逻辑处理类,客户端请求进入里面
 */
public class ServiceHandler extends IoHandlerAdapter implements Command{
	private static Logger log = Logger.getLogger(ServiceHandler.class);
	
	ILogin loginLogic;
	IItem itemLogic;
	IMoney moneyLogic;
	IOther otherLogic;
	IRole roleLogic;
	ITrade tradeLogic;
	 
	private IoAcceptor acceptor;
	public ServiceHandler(IoAcceptor acceptor) {
		this.acceptor=acceptor;
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationClient.xml" });
		context.start();
		loginLogic = (ILogin) context.getBean("loginLogic");
		itemLogic = (IItem) context.getBean("itemLogic");
		moneyLogic = (IMoney) context.getBean("moneyLogic");
		otherLogic = (IOther) context.getBean("otherLogic");
		roleLogic = (IRole) context.getBean("roleLogic");
		tradeLogic = (ITrade) context.getBean("tradeLogic");
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
			
			loginLogic.login(json, session);// 问题
			System.out.println("当前session"+session.getId());
			break;
		case ONLINE_NUM:
			// 获取在线用户
			break;
		case MOVE:
			// 移动
			break;
		case ATTACK:
			// 攻击	
			break;
		case ADD_ITEM:
			// 添加物品

			break;
		case ADD_MONEY:
			// 添加金钱

			break;
		case CHAT:
			// 聊天

			break;
		case CONFIRM_TRADE:
			// 确认交易

			break;
		case DESTROY_ITEM:
			// 销毁物品

			break;
		case GIVE_UP_ITEM:
			// 丢弃物品

			break;
		case GIVE_UP_MONEY:
			// 丢弃金币

			break;
		case PICK_UP_ITEM:
			// 拾取物品

			break;
		case PICK_UP_MONEY:
			// 拾取金币

			break;
		case PUT_ON:
			// 装备物品

			break;
		case RIDE:
			// 骑乘

			break;
		case SPLIT_ITEM:
			// 拆分物品

			break;
		case SKILL:
			// 使用技能

			break;
		case STALL:
			// 摆摊

			break;
		case TAKE_DOWN:
			// 卸下物品

			break;
		case USE_ITEM:
			// 使用物品

			break;
		}
		
	}


	// 当一个客户端连接关闭时
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		
	}
}
