package com.zzy.zero.run;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.zzy.zero.role.Hero;
import com.zzy.zero.thread.ServiceHandler;
import com.zzy.zero.util.EasyCharset;

/**    
* ��������(��NIOʵ��)
* @author ������   
* @date 2015��8��27�� ����2:14:44 
* @version V1.0   
*/
public class ZeroService {
	// ���������û��б�
	private HashMap<String, Hero> serviceMap;
	// �����ַ�ת�����߰�
	private EasyCharset ec = new EasyCharset();
	// ���÷������˿� Ĭ��1024
	private static int PORT = 1024;

	public static void main(String[] args) {

		try {
			new ZeroService();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public ZeroService() throws IOException {
		// �û��б�
		serviceMap = new HashMap<String, Hero>();
		// ����һ����������Server��socket����NIO
		IoAcceptor acceptor = new NioSocketAcceptor();
		// �����������ݵĹ�����
		DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
		// �趨�����������һ��һ�еĶ�ȡ���� ����ת��
		chain.addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));// ָ�����������
		// ����server�����շ�����
		// chain.addLast("objectFilter", new ProtocolCodecFilter(new
		// ObjectSerializationCodecFactory()));
		// ����ת��������
		// ָ��ҵ���߼�������
		acceptor.setHandler(new ServiceHandler(serviceMap));
		// ���ö˿ںŲ���
		acceptor.bind(new InetSocketAddress(PORT)); // ��������
		System.out.println("---------------------������������--------------------");

	}

}
