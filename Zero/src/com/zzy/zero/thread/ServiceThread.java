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
* �����߳�
* 
* @author ������   
* @date 2015��8��27�� ����2:17:52 
* @version V1.0   
*/
public class ServiceThread implements Runnable {
	private Socket socket;
	private HashMap<Socket, String> serviceMap;

	// ��ʼ���õ�socket
	public ServiceThread(Socket socket, HashMap<Socket, String> serviceMap) {
		this.serviceMap = serviceMap;
		this.socket = socket;
		new Thread(this).start();
	}

	@Override
	public void run() {
		try {
			while (true) {
				// �õ�socket����������ʵ����Data������ ������������Ӧ�ó�����������޹ط�ʽ�ӵײ��������ж�ȡJava��������
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				// readUTF()��ȡ�ַ���
				String receiveMessage = dis.readUTF();
				// �ָ������
				String command = receiveMessage.split("/")[0];
				// �ָ����Ϣ
				String message = receiveMessage.split("/")[1];
				// �õ�socket����������� dos.writeUTF()����ַ���
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

				if ("$[login]".equals(command)) {
					// ��½��֤
					if (message.split("&")[0].equals("111111") && message.split("&")[1].equals("111111")) {
						dos.writeUTF("ok");
						dos.flush();
						// ����socket�ͽ�ɫ��
						// ��ɫ��Ӧ����userName�����ݿ�������������������������������������������������������������������������������
						serviceMap.put(socket, message.split("&")[0]);
						Map<Socket, String> map = serviceMap;
						Iterator<?> iter = map.entrySet().iterator();
						while (iter.hasNext()) {
							Map.Entry entry = (Map.Entry) iter.next();
							// �õ��û�socket
							Socket key = (Socket) entry.getKey();
							// �����û���
							String userName;
							// ������ʱdata��
							DataOutputStream tempDos;
							// ����json����
							JSONObject jsonobj;
							if (key != socket) {
								// �õ��û�����
								userName = (String) entry.getValue();
								tempDos = new DataOutputStream(key.getOutputStream());
								// �����ݿ����������ɫx,y����
								int roleX = 100;
								int roleY = 100;
								jsonobj = new JSONObject();

								jsonobj.put("userName", userName);
								jsonobj.put("x", roleX);
								jsonobj.put("y", roleY);
								// ���Լ����͸�������
								tempDos.writeUTF("$[add]/" + jsonobj.toString());
								tempDos.flush();
								// �������˷��͸��Լ�
								dos.writeUTF("$[add]/" + jsonobj.toString());
								dos.flush();
								
							}
						}
					}
				} else if (command.equals("$[roleMove]")) {
					// ������ʱdata��
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
								// ���Լ����͸�������
								tempDos.writeUTF("$[otherMove]/" + name);
								tempDos.flush();
								tempDos.close();
						  }
					  }*/
					// �û��˳� �������б�ɾ�����û�
				} else if (command.equals("$[exit]")) {
					// ������ʱdata��
					DataOutputStream tempDos;
					serviceMap.remove(socket);
					Map<Socket, String> map = serviceMap;
					Iterator<?> iter = map.entrySet().iterator();
					while (iter.hasNext()) {
						Map.Entry entry = (Map.Entry) iter.next();
						// �õ��û�socket
						Socket key = (Socket) entry.getKey();
						// �����û���
						String name;
						
						// �õ��û�����
						name = (String) entry.getValue();
						tempDos = new DataOutputStream(key.getOutputStream());
						// ���Լ����͸�������
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
