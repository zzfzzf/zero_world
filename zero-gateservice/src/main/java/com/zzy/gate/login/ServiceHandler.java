package com.zzy.gate.login;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.zzy.gate.util.EasyString;

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
		log.info("有用户连接");

	}

	/**
	 * 捕捉异常
	 */
	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		Exception e = (Exception) cause;
		e.printStackTrace();
	}

	/**
	 * 当客户端发送消息到达时
	 */
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		// 收到的信息字符串
		JSONObject json = JSONObject.parseObject((String) message);
		if(json!=null&&json.isEmpty()){
			
		}
	}

	/**
	 * 用戶退出处理逻辑
	 */
	private void exitLogic(IoSession session) {

	}

	/**
	 * 用户登录处理逻辑
	 */
	private void moveLogic(IoSession session, JSONPObject jo) {

	}

	// 当一个客户端连接关闭时
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		this.exitLogic(session);
	}
}
