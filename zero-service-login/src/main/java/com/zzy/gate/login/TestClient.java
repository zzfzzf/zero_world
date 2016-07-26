package com.zzy.gate.login;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.zzy.common.base.HttpUtil;


/**
 * @author Zeus
 * @version 1.1
 * @createTime：2016年7月20日 @decript:
 */
public class TestClient {
	private static Logger log = Logger.getLogger(ServiceHandler.class);
	public static void main(String[] args) throws IOException {
		 String s=HttpUtil.getJson("http://localhost:8080/zeus/role/user/1");
		 System.out.println(s);
		/*
		  String host = "127.0.0.1";  //要连接的服务端IP地址  
	      int port = 8080;   //要连接的服务端对应的监听端口  
	      //与服务端建立连接  
	      Socket client = new Socket(host, port);  
	      //建立连接后就可以往服务端写数据了  
	      PrintWriter  writer =new PrintWriter(client.getOutputStream());
	      JSONObject json=new JSONObject();
	      json.put("command", Command.LOGIN);
	      writer.println(json); 
	      writer.flush();//写完后要记得flush  
	      writer.close();  
	      client.close();*/
	}
}
