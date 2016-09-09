package test;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**    
* ��һ�仰�������ļ���ʲô
* @author ������   
* @date 2015��9��22�� ����5:50:42 
* @version V1.0   
*/
public class ServiceHandler extends IoHandlerAdapter {
	// ��һ���ͻ������ӽ���ʱ
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("�ͻ���������");
		session.write("�Բ�");
	}

	// ���ͻ��˷�����Ϣ����ʱ
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		String s = message.toString();
		System.out.println("client send message is:" + s);
	}

	// ��һ���ͻ������ӹر�ʱ
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("�ͻ��˹ر�");
	}
}