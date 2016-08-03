package com.zzy.login;

import java.nio.IntBuffer;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import com.alibaba.fastjson.JSONObject;
import com.zzy.common.base.Command;
import com.zzy.common.base.HttpUtil;
import com.zzy.common.base.UrlCommon;

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
			
		}

		/**
		 * 捕捉异常
		 */
		@Override
		public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
			System.out.println("有用户异常关闭");
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
			if(Command.LOGIN.equals(command)){
				JSONObject result = HttpUtil.postJson(UrlCommon.LOGIN,json);
				session.write(result); 
			}
		}


		// 当一个客户端连接关闭时
		@Override
		public void sessionClosed(IoSession session) throws Exception {
			System.out.println("客户端"+session.getId()+"关闭");
		}
}
