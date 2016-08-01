package com.zzy.login;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import com.alibaba.fastjson.JSONObject;
import com.zzy.common.base.Command;

/**
* @author Zeus
* @version 1.1
* @createTime:2016年8月1日 
* @description:
*/
public class LoginHandler extends IoHandlerAdapter implements Command{
	private static Logger log = Logger.getLogger(LoginHandler.class);

	// 当一个客户端连接进入时
		@Override
		public void sessionOpened(IoSession session) throws Exception {
			long token = session.getId();
			System.out.println("有客戶端進入"+session.getId());
			session.write(token+"\n");
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
				System.out.println("当前session"+session.getId());
				session.write("this my test");
				break;
			}
			
		}


		// 当一个客户端连接关闭时
		@Override
		public void sessionClosed(IoSession session) throws Exception {
			
		}
}
