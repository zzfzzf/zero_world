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
* ��һ�仰�������ļ���ʲô
* @author ������   
* @date 2015��9��23�� ����11:54:51 
* @version V1.0   
*/
public class ClientHandle extends IoHandlerAdapter {
	ZeroClient z;
	IoConnector connector;

	// ��һ���ͻ������ӽ���ʱ
	public ClientHandle(ZeroClient z, IoConnector connector) {
		this.z = z;
		this.connector = connector;
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("�����������");
	}

	// ���ͻ��˷�����Ϣ����ʱ
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

	// ��һ���ͻ������ӹر�ʱ
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("�ͻ��˹ر�");
	}
}
