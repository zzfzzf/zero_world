package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.prefixedstring.PrefixedStringCodecFactory;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**    
* ��һ�仰�������ļ���ʲô
* @author ������   
* @date 2015��9��22�� ����5:34:24 
* @version V1.0   
*/
public class MinaServer {
	private static final int PORT = 1024;// ��������˿�

	public static void main(String[] args) throws IOException {
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
		acceptor.setHandler(new ServiceHandler());
		// ���ö˿ںŲ���
		acceptor.bind(new InetSocketAddress(PORT)); // ��������
		System.out.println("Mina Server is Listen on:" + PORT);
	}
}