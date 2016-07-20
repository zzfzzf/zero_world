package com.zzy.gate.login;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;

/**
 * @author Zeus
 * @version 1.1
 * @createTime：2016年7月20日 @decript:
 */
public class TestClient {
	public static void main(String[] args) throws IOException {
		  String host = "127.0.0.1";  //要连接的服务端IP地址  
	      int port = 8080;   //要连接的服务端对应的监听端口  
	      //与服务端建立连接  
	      Socket client = new Socket(host, port);  
	      //建立连接后就可以往服务端写数据了  
	      PrintWriter  writer =new PrintWriter(client.getOutputStream());
	      writer.println("中华人民共和国");
	      writer.flush();//写完后要记得flush  
	      writer.close();  
	      client.close();
	}
}
