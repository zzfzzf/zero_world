package com.zzy.zero.thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONObject;

/**    
* 服务线程
* 
* @author 赵召阳   
* @date 2015年8月27日 下午2:17:52 
* @version V1.0   
*/
public class ServiceThread implements Runnable {
	private Socket socket;
	private HashMap<Socket, String> serviceMap;

	// 初始化拿到socket
	public ServiceThread(Socket socket, HashMap<Socket, String> serviceMap) {
		this.serviceMap = serviceMap;
		this.socket = socket;
		new Thread(this).start();
	}

	@Override
	public void run() {
		try {
			while (true) {
				// 拿到socket的输入流并实例化Data输入流 该输入流允许应用程序以与机器无关方式从底层输入流中读取Java数据类型
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				// readUTF()读取字符串
				String receiveMessage = dis.readUTF();
				// 分割命令符
				String command = receiveMessage.split("/")[0];
				// 分割出信息
				String message = receiveMessage.split("/")[1];
				// 拿到socket的数据输出流 dos.writeUTF()输出字符串
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

				if ("$[login]".equals(command)) {
					// 登陆验证
					if (message.split("&")[0].equals("111111") && message.split("&")[1].equals("111111")) {
						dos.writeUTF("ok");
						dos.flush();
						// 存入socket和角色名
						// 角色名应根据userName从数据库查出来！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
						serviceMap.put(socket, message.split("&")[0]);
						Map<Socket, String> map = serviceMap;
						Iterator<?> iter = map.entrySet().iterator();
						while (iter.hasNext()) {
							Map.Entry entry = (Map.Entry) iter.next();
							// 得到用户socket
							Socket key = (Socket) entry.getKey();
							// 声明用户名
							String userName;
							// 声明临时data流
							DataOutputStream tempDos;
							// 声明json对象
							JSONObject jsonobj;
							if (key != socket) {
								// 得到用户名称
								userName = (String) entry.getValue();
								tempDos = new DataOutputStream(key.getOutputStream());
								// 从数据库里面读出角色x,y坐标
								int roleX = 100;
								int roleY = 100;
								jsonobj = new JSONObject();

								jsonobj.put("userName", userName);
								jsonobj.put("x", roleX);
								jsonobj.put("y", roleY);
								// 将自己发送给所有人
								tempDos.writeUTF("$[add]/" + jsonobj.toString());
								tempDos.flush();
								// 将所有人发送给自己
								dos.writeUTF("$[add]/" + jsonobj.toString());
								dos.flush();
								
							}
						}
					}
				} else if (command.equals("$[roleMove]")) {
					// 声明临时data流
					DataOutputStream tempDos;
					 JSONObject jsonobj = JSONObject.fromObject(message);
			         System.out.println(jsonobj.toString());
					/* serviceMap.get(socket);
					  Map<Socket,String> map=serviceMap;
					  Iterator<?> iter = map.entrySet().iterator();
					  while(iter.hasNext()){
						  Map.Entry entry=(Map.Entry)iter.next();
						  Socket key = (Socket)entry.getKey();
						  if(key!=socket){
							  tempDos = new DataOutputStream(key.getOutputStream());
								// 将自己发送给所有人
								tempDos.writeUTF("$[otherMove]/" + name);
								tempDos.flush();
								tempDos.close();
						  }
					  }*/
					// 用户退出 从在线列表删除该用户
				} else if (command.equals("$[exit]")) {
					// 声明临时data流
					DataOutputStream tempDos;
					serviceMap.remove(socket);
					Map<Socket, String> map = serviceMap;
					Iterator<?> iter = map.entrySet().iterator();
					while (iter.hasNext()) {
						Map.Entry entry = (Map.Entry) iter.next();
						// 得到用户socket
						Socket key = (Socket) entry.getKey();
						// 声明用户名
						String name;
						
						// 得到用户名称
						name = (String) entry.getValue();
						tempDos = new DataOutputStream(key.getOutputStream());
						// 将自己发送给所有人
						tempDos.writeUTF("$[remove]/" + name);
						tempDos.flush();
						tempDos.close();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ==========================get/set=====================================

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

}
