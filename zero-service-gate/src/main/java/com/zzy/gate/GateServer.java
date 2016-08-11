package com.zzy.gate;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.zzy.common.base.UrlCommon;

/**
 * @author Zeus
 * @version 1.1
 * @createTime：2016年7月20日 @decript:
 */ 
// 传递对象拦截器
// chain.addLast("objectFilter", new ProtocolCodecFilter(new
// ObjectSerializationCodecFactory()));
public class GateServer {
	private static Logger log = Logger.getLogger(GateServer.class);
	
	public static void main(String[] args) {
		new GateServer().init();
	}

	private void init() {
		try {
			// 创建一个非阻塞的Server端socket，用NIO
			IoAcceptor acceptor = new NioSocketAcceptor();
			// 创建接受数据的过滤器
			DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
			// 设定这个过滤器将一行一行的读取数据 并且转码
			chain.addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));// 指定编码过滤器
			// 指定业务逻辑处理
			acceptor.setHandler(new GateHandler(acceptor));
			// 设置端口号并绑定
			acceptor.bind(new InetSocketAddress(UrlCommon.PORT));
		} catch (IOException e) {
			log.error(e.getMessage());
		} 
		System.out.println("---------------------------服务器已启动---------------------------");
	}
}
