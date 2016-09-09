package test;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**    
* 用一句话描述该文件做什么
* @author 赵召阳   
* @date 2015年9月22日 下午5:50:42 
* @version V1.0   
*/
public class ServiceHandler extends IoHandlerAdapter {
	// 当一个客户端连接进入时
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("客户端已连接");
		session.write("卧槽");
	}

	// 当客户端发送消息到达时
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		String s = message.toString();
		System.out.println("client send message is:" + s);
	}

	// 当一个客户端连接关闭时
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("客户端关闭");
	}
}