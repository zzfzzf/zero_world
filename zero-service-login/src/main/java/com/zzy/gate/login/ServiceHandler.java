package com.zzy.gate.login;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import com.alibaba.fastjson.JSONObject;

/**
* @author Zeus
 * @version 1.1
 * @createTime：2016年7月20日 @decript: 逻辑处理类,客户端请求进入里面
 */
public class ServiceHandler extends IoHandlerAdapter {
	private static Logger log = Logger.getLogger(ServiceHandler.class);

	// 当一个客户端连接进入时
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		
	}

	/**
	 * 捕捉异常
	 */
	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		System.out.println("异常"+cause.getMessage());
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
		
	}


	// 当一个客户端连接关闭时
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		
	}
}
