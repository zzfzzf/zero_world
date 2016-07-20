package com.zzy.gate.login;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 * @author Zeus
 * @version 1.1
 * @createTime：2016年7月20日 @decript:
 */
public class LoginService {

	private static int PORT = 8080;

	public static void main(String[] args) {
		new LoginService().init();
	}

	private void init() {
		try {
			// 创建一个非阻塞的Server端socket，用NIO
			IoAcceptor acceptor = new NioSocketAcceptor();
			// 创建接受数据的过滤器
			DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
			// 设定这个过滤器将一行一行的读取数据 并且转码
			chain.addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));// 指定编码过滤器
			// chain.addLast("objectFilter", new ProtocolCodecFilter(new
			// ObjectSerializationCodecFactory()));
			// 指定业务逻辑处理器
			acceptor.setHandler(new ServiceHandler());
			// 设置端口号并绑定
			acceptor.bind(new InetSocketAddress(PORT));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		// 启动监听
		System.out.println("---------------------服务器已启动--------------------");

	}
}
