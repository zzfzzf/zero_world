package com.zzy.login;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.DatagramSessionConfig;
import org.apache.mina.transport.socket.nio.NioDatagramAcceptor;

/**
 * @author Zeus
 * @version 1.1
 * @createTime:2016年8月1日
 * @description: 登陆服务类
 */
public class LoginServer {
	private static int PORT = 9999;
	private static Logger log = Logger.getLogger(LoginServer.class);

	public LoginServer() throws IOException {

		NioDatagramAcceptor acceptor = new NioDatagramAcceptor();// 创建一个UDP的接收器
		acceptor.setHandler(new LoginHandler());// 设置接收器的处理程序

		// 创建接受数据的过滤器
		DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
		// 设定这个过滤器将一行一行的读取数据 并且转码
		chain.addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));// 指定编码过滤器

		DatagramSessionConfig dcfg = acceptor.getSessionConfig();// 建立连接的配置文件
		dcfg.setReadBufferSize(4096);// 设置接收最大字节默认2048
		dcfg.setReceiveBufferSize(1024);// 设置输入缓冲区的大小
		dcfg.setSendBufferSize(1024);// 设置输出缓冲区的大小
		dcfg.setReuseAddress(true);// 设置每一个非主监听连接的端口可以重用

		acceptor.bind(new InetSocketAddress(PORT));// 绑定端口
		log.info("Login服务已启动-----监听端口为："+PORT);
	}

	public static void main(String[] args) {
		try {
			new LoginServer();
		} catch (IOException e) {
			log.error("启动Login服务失败----" + e.getMessage());
		}
	}
}
