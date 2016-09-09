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
* 服务器类(用NIO实现)
* @author 赵召阳   
* @date 2015年8月27日 下午2:14:44 
* @version V1.0   
*/
public class ZeroService {
	// 创建在线用户列表
	private HashMap<String, Hero> serviceMap;
	// 导入字符转换工具包
	private EasyCharset ec = new EasyCharset();
	// 设置服务器端口 默认1024
	private static int PORT = 1024;

	public static void main(String[] args) {

		try {
			new ZeroService();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public ZeroService() throws IOException {
		// 用户列表
		serviceMap = new HashMap<String, Hero>();
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
		acceptor.setHandler(new ServiceHandler(serviceMap));
		// 设置端口号并绑定
		acceptor.bind(new InetSocketAddress(PORT)); // 启动监听
		System.out.println("---------------------服务器已启动--------------------");

	}

}
