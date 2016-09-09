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
* 用一句话描述该文件做什么
* @author 赵召阳   
* @date 2015年9月22日 下午5:34:24 
* @version V1.0   
*/
public class MinaServer {
	private static final int PORT = 1024;// 定义监听端口

	public static void main(String[] args) throws IOException {
		// 创建一个非阻塞的Server端socket，用NIO
		IoAcceptor acceptor = new NioSocketAcceptor();
		// 创建接受数据的过滤器
		DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
		// 设定这个过滤器将一行一行的读取数据 并且转码
		chain.addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));// 指定编码过滤器
		// 设置server可以收发对象
		// chain.addLast("objectFilter", new ProtocolCodecFilter(new
		// ObjectSerializationCodecFactory()));
		// 设置转码拦截器
		// 指定业务逻辑处理器
		acceptor.setHandler(new ServiceHandler());
		// 设置端口号并绑定
		acceptor.bind(new InetSocketAddress(PORT)); // 启动监听
		System.out.println("Mina Server is Listen on:" + PORT);
	}
}