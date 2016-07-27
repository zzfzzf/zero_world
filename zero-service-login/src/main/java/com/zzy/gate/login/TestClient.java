package com.zzy.gate.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.zzy.common.base.Command;
import com.zzy.common.base.HttpUtil;
import com.zzy.common.base.UrlCommon;
import com.zzy.gate.logic.LoginController;

/**
 * @author Zeus
 * @version 1.1
 * @createTime：2016年7月20日 @decript:
 */
public class TestClient {
	private static Logger log = Logger.getLogger(ServiceHandler.class);

	public static void main(String[] args) throws IOException {
		String host = "127.0.0.1"; // 要连接的服务端IP地址
		int port = UrlCommon.PORT; // 要连接的服务端对应的监听端口
		// 与服务端建立连接
		Socket client = new Socket(host, port);
		// 建立连接后就可以往服务端写数据了
		PrintWriter writer = new PrintWriter(client.getOutputStream());
		JSONObject json = new JSONObject();
		json.put("command", Command.LOGIN);
		json.put("username", 1);
		json.put("password", 1);
		writer.println(json);
		writer.flush();// 写完后要记得flush
		
		BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		StringBuffer sb = new StringBuffer("");
		String lines;
	    lines = br.readLine();
		lines = new String(lines.getBytes(), "utf-8");
		sb.append(lines);
		writer.close();
		br.close();
		client.close();
	}
}
