package com.zzy.gate.login;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;

import com.alibaba.fastjson.JSONObject;


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
	      JSONObject json=new JSONObject();
	      json.put("呵呵", "和开决定了看见路口附近路口积分可垃圾路口附近的拉开纠纷拉数据量中华人民共和开决定了看见路口附近路口积分可垃圾路口附近的拉开纠纷拉数据量中华人民共和开决定了看见路口附近路口积分可垃圾路口附近的拉开纠纷拉数据量中华人民共和开决定了看见路口附近路中华人民共和开决定了看见路口附近路口积分可垃圾路口附近的拉开纠纷拉数据量中华人民共和开决定了看见路口附近路口积分可垃圾路口附近的拉开纠纷拉数据量中华人民共和开决定了看见路口附近路口积分可垃圾路口附近的拉开纠纷拉数据量中华人民共和开口附近的拉开纠纷拉数据量中华人民共看见路口附近路口积分可垃圾路口附近的拉开纠纷拉数据量口积分可垃圾路口附近的拉开纠纷拉数据量中华人民共和开决定了看见路口附近路口积分可垃圾路口附近的拉开纠纷拉数据量");
	      writer.println(json.toString());
	      writer.flush();//写完后要记得flush  
	      writer.close();  
	      client.close();
	}
}
