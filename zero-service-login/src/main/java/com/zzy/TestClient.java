package com.zzy.login;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import com.alibaba.fastjson.JSONObject;
import com.zzy.common.base.UrlCommon;

/**
 * @author Zeus
 * @version 1.1
 * @createTime：2016年7月20日 @decript:
 */
public class TestClient {

	public static void main(String[] args) throws IOException {
	
		String host = "127.0.0.1"; // 要连接的服务端IP地址
		int port = UrlCommon.PORT; // 要连接的服务端对应的监听端口
		
		DatagramSocket client = new DatagramSocket();
		JSONObject json = new JSONObject();
		String jsonData=json.toString()+"\n";
		byte[] buf = jsonData.getBytes(); //创建发送数据缓冲区  
        // 数据包包括所有的信息，ip地址，端口号及要发送的数据   
        DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"), 9999);  
        client.send(packet);
        client.close();
      /*  
        byte[] buffer = new byte[65508];  
        DatagramPacket packetr = new DatagramPacket(buffer, 0, buffer.length); 
        while(true){  
        	client.receive(packetr);  
            String s = new String(packetr.getData(),0,packetr.getLength());  
            System.out.println(s);  
        }*/
	}
}
