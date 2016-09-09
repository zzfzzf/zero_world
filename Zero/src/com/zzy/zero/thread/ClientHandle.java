package com.zzy.zero.thread;

import net.sf.json.JSONObject;

import org.apache.commons.collections.functors.OnePredicate;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import sun.applet.Main;

import com.zzy.zero.run.MainGame;
import com.zzy.zero.run.ZeroClient;

/**    
* 用一句话描述该文件做什么
* @author 赵召阳   
* @date 2015年9月23日 上午11:54:51 
* @version V1.0   
*/
public class ClientHandle extends IoHandlerAdapter {
	ZeroClient z;
	IoConnector connector;

	// 当一个客户端连接进入时
	public ClientHandle(ZeroClient z, IoConnector connector) {
		this.z = z;
		this.connector = connector;
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("服务端已连接");
	}

	// 当客户端发送消息到达时
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		String rmsg = (String) message;
		if (rmsg != null && rmsg.length() > 0) {
			JSONObject jo=new JSONObject().fromObject(rmsg);
			String command=jo.getString("command");
			if("$[login]".equals(command)){
				if("ok".equals(jo.getString("state"))){
					z.setVisible(false);
					
				}
			}
		}
	}

	// 当一个客户端连接关闭时
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("客户端关闭");
	}
}
