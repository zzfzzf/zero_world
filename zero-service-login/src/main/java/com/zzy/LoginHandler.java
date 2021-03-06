package com.zzy.login;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import com.alibaba.fastjson.JSONObject;
import com.zzy.common.base.Command;
import com.zzy.common.base.UrlCommon;
import com.zzy.common.util.HttpUtil;

/**
 * @author Zeus
 * @version 1.1
 * @createTime:2016年8月1日
 * @description: 登录处理器
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
		log.error("有用户异常关闭:"+session.getId()+"---->"+cause.getMessage());
	}

	/**
	 * 当客户端发送消息到达时
	 */
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		// 收到的信息字符串
		if(Objects.isNull(message) || "null".equals(message)){
			log.error("message不能为null");
			return;
		}
		JSONObject json = JSONObject.parseObject((String) message);
		String command = (String)json.get("command");
		if(Command.LOGIN.equals(command)){
			session.write(HttpUtil.postJson(UrlCommon.LOGIN,json));
		}
	}


	// 当一个客户端连接关闭时
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		log.info("客户端："+session.getId()+"链接关闭");
	}
}
