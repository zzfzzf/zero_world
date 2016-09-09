package com.zzy.zero.thread;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonBeanProcessor;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import sun.net.www.content.text.plain;

import com.zzy.zero.map.MainInterFace;
import com.zzy.zero.role.Hero;
import com.zzy.zero.run.MainGame;
import com.zzy.zero.util.EasyImage;

/**    
* ��һ�仰�������ļ���ʲô
* @author ������   
* @date 2015��9��22�� ����5:50:42 
* @version V1.0   
*/
public class ServiceHandler extends IoHandlerAdapter {

	HashMap<String, Hero> serviceMap;
	Map<String, Hero>[][] mapArr = null;
	// ����ͼƬ
	BufferedImage bgimage;
	// easyͼƬ������
	EasyImage ei;
	// json����
	JsonConfig jsonConfig;
	public ServiceHandler(HashMap<String, Hero> serviceMap) throws IOException {
		init(serviceMap);
	}

	/**
	 * ��ʼ��
	 * @param serviceMap
	 * @throws IOException
	 */
	public void init(HashMap<String, Hero> serviceMap) throws IOException {
		bgimage = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/bg.png"));
		ei = new EasyImage(bgimage);
		ei.split(230, 170);
		mapArr = new Map[ei.getSplitNumX()][ei.getSplitNumY()];
		// ��ʼ������
		for (int i = 0; i < ei.getSplitNumX(); i++) {
			for (int j = 0; j < ei.getSplitNumY(); j++) {
				mapArr[i][j] = new HashMap<String, Hero>();
			}
		}
		this.serviceMap = serviceMap;
		jsonConfig = new JsonConfig();
		jsonConfig.setIgnoreTransientFields(true);
	}

	/**
	 *  ���ӷ���token
	 */
	public void reToken(IoSession session) {
		JSONObject jo = new JSONObject();
		jo.put("command", MainGame.COMMAND_TOKEN);
		jo.put("token", session.getId()+"");
		session.write(jo.toString());
	}

	// ��һ���ͻ������ӽ���ʱ
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		this.reToken(session);
	}

	/**
	 * ��׽�쳣
	 */
	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		Exception e = (Exception) cause;
		e.printStackTrace();
	}
	/**
	 * ��½�߼�
	 * @param session ��ǰ����session
	 * @param jo ��ǰ����json
	 */
   private void loginLogic(IoSession session,JSONObject jo){
	   if (true) {
			String name = "��ѯ����������";
			// ��֤�ɹ�֮��ŷ��ظ��ֶ�
			// String allowLogin=SQL(�����ݿ��л�ȡ);
			// ��ѯ��ɫ���겢����
			int tempX = 300;
			int tempY = 300;
			// �����±�
			int tempI = (int) Math.ceil(tempX / ei.getSplitSizeX());
			int tempJ = (int) Math.ceil(tempY / ei.getSplitSizeY());
			System.out.println("����и�x��y" + ei.getSplitSizeX());
			// ��֤ͨ��
			jo = new JSONObject();
			jo.put("command", MainGame.COMMAND_LOGIN);
			jo.put("state", "ok");
			session.write(jo.toString());
			// ����session���û�������Ϸ�ǳ�
			Hero h = new Hero();
			h.setToken(session.getId()+"");
			h.setSession(session);
			// ���ǳƴ����ݿ���
			h.setName(name);
			// �õ���ɫ���꣨�����ݿ���)
			h.setX(321);
			h.setY(242);
			// ��ѯ��ǰ��¼���ĸ�������
			serviceMap.put(session.getId() + "", h);
			mapArr[tempI][tempJ].put(session.getId() + "", h);
			// ��ѯ�Ÿ���������
			this.iterMapArr(this.otherNotice(tempI, tempJ), session, h);
			System.out.println("�û�" + session.getId() + "���������,��ǰ�û�����" + serviceMap.size());
			for(Map.Entry<String, Hero> mp : serviceMap.entrySet()){
				if(!mp.getKey().equals((session.getId()+""))){
					// ����һ����ʱ��������
					Hero tempH=mp.getValue();
					// ���ö����������
					h.setCommand(MainGame.COMMAND_ADD);
					// ��������ҷ����Լ���������Ϣ
				    tempH.getSession().write(JSONObject.fromObject(h,jsonConfig));
				    // ���ö����������
				    tempH.setCommand(MainGame.COMMAND_ADD);
				    // ���Լ�����������ҵ�������Ϣ
					session.write(JSONObject.fromObject(tempH,jsonConfig));
				}
			}
		}
   }
	
	/**
	 * ���ͻ��˷�����Ϣ����ʱ
	 */
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		// �յ�����Ϣ�ַ���
		String rmsg = (String) message;
		if (rmsg != null && rmsg.length() > 0) {
			JSONObject jo = JSONObject.fromObject(message);
			int command = jo.getInt("command");
			switch (command) {
			case MainGame.COMMAND_LOGIN:
				// ��½�߼�����
				this.loginLogic(session,jo);
				break;
			case MainGame.COMMAND_MOVE:
				// �ƶ��߼�����
				this.moveLogic(session, jo);
				break;
			}
		}
	}

	/**
	 * �Ñ��˳������߼�
	 */
	private void exitLogic(IoSession session){
		for(Map.Entry<String, Hero> mp:serviceMap.entrySet()){
			Hero tempH=mp.getValue();
			if(!tempH.getSession().equals(session)){
				JSONObject jo = new JSONObject();
				jo.put("command", MainGame.COMMAND_REMOVE);
				jo.put("token", session.getId()+"");
				tempH.getSession().write(jo.toString());
				jo.put("command", MainGame.COMMAND_EXIT);
				tempH.getSession().write(jo.toString());
			}
			
		}
		Hero temp=serviceMap.get(session.getId()+"");
		int tempX=(int) Math.ceil(temp.getX() / ei.getSplitSizeX());
		int tempY=(int) Math.ceil(temp.getY() / ei.getSplitSizeY());
		mapArr[tempX][tempY].remove(session.getId()+"");
		serviceMap.remove(session.getId()+"");
		System.out.println("���û��쳣�˳�,��ǰʣ���û�:" + serviceMap.size());
	}
	
	/**
	 * �û���¼�����߼� 
	 */
	private void moveLogic(IoSession session,JSONObject jo){
		// ��ȡtoken
		String token=jo.getString("token");
		// ����token�õ�����
		Hero p = serviceMap.get(token);
		// �õ���ɫ֮ǰλ��
		int preX = (int) Math.ceil(p.getX() / ei.getSplitSizeX());
		int preY = (int) Math.ceil(p.getY() / ei.getSplitSizeY());
		p.setX(jo.getInt("x"));
		p.setY(jo.getInt("y"));
		p.setActionState(jo.getInt("actionState"));
		p.setMoveState(jo.getInt("moveState"));
		// ȡ�����½�ɫλ��
		int tempI = (int) Math.ceil(p.getX() / ei.getSplitSizeX());
		int tempJ = (int) Math.ceil(p.getY() / ei.getSplitSizeY());
		if (preX != tempI || preY != tempJ) {
			System.out.println(session.getId() + "��ǰ����λ��" + tempI + "," + tempJ);
			// �߳�һ����Χ֪ͨ��ǰ��Χ��Χ�������
			Map<String, Hero> ma = this.otherNotice(preX, preY);
			JSONObject tempJson = new JSONObject();
			tempJson.put("command", MainGame.COMMAND_REMOVE);
			for (Map.Entry<String, Hero> me : ma.entrySet()) {
				Hero tempP = me.getValue();
				if (!(me.getKey().equals(session.getId() + ""))) {
					System.out.println("��ѭ��������" + me.getKey().equals(session.getId() + ""));
					tempJson.put("token", session.getId() + "");
					tempP.getSession().write(tempJson.toString());
				}
				// �߳��������֪ͨ�Լ�ɾ�����������Ϣ���������
				tempJson.put("token", tempP.getToken());
				session.write(tempJson.toString());
			}
			// Խ������
			if (preX >= 0 && preX < ei.getSplitNumX() && preY >= 0 && preY < ei.getSplitNumY()) {
				mapArr[preX][preY].remove(token);
			}
			// Խ������
			if (tempI >= 0 && tempI < ei.getSplitNumX() && tempJ >= 0 && tempJ < ei.getSplitNumY()) {
				mapArr[tempI][tempJ].put(token, p);
			}
		}
		this.iterMapArr(this.otherNotice(tempI, tempJ), session, p);
	}
	// ��һ���ͻ������ӹر�ʱ
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		this.exitLogic(session);
	}

	/**
	 * Ҫ֪ͨ�İ˸���������б�
	 */
	public Map<String, Hero> otherNotice(int tempI, int tempJ) {
		// �����ƶ�����ͼ�������
		if (tempI < 0) {
			System.out.println("��������" + tempI);
			return new HashMap<String, Hero>();
		} else if (tempI > 0) {
			tempI = tempI - 1;
		}

		// ѭ��Ѱ�Ҹ����˸�
		List<Map<String, Hero>> tempList = new ArrayList<Map<String, Hero>>();
		// ��������ͼ�Ҳ���� ���޷�ѭ������(ȷ������Խ�緶Χ)
		int tempN = (ei.getSplitNumX() - tempI) >= 3 ? 3 : (ei.getSplitNumX() - tempI);
		for (int tempK = 0; tempK < tempN; tempK++) {
			if (tempJ >= 0 && tempJ < (ei.getSplitNumY() - 1)) {
				if (tempJ != 0) {
					tempList.add(mapArr[tempI][tempJ - 1]);
				}
				tempList.add(mapArr[tempI][tempJ]);
				tempList.add(mapArr[tempI][tempJ + 1]);
			}
			tempI++;
		}
		Map<String, Hero> allMap = new HashMap<String, Hero>();
		// ����λ����ѭ�������������
		for (int i = 0; i < tempList.size(); i++) {
			Map<String, Hero> map = tempList.get(i);
			Iterator<?> iter = map.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry<String, Hero> entry = (Map.Entry) iter.next();
				allMap.put(entry.getKey(), entry.getValue());
			}
		}
		return allMap;
	}


	/**
	 * �����㲥��ͼ�ɼ�
	 */
	public void iterMapArr(Map<String, Hero> map2, IoSession session, Hero p) {
		JSONObject jo = new JSONObject();

		for (Map.Entry<String, Hero> me : map2.entrySet()) {
			Hero tempP = me.getValue();
			if (!(me.getKey().equals(session.getId() + ""))) {
				// ���Լ������귢�͸�ÿһ����
				jo.put("command", MainGame.COMMAND_LOOK);
				jo.put("name", p.getName());
				jo.put("x", p.getX());
				jo.put("moveState", p.getMoveState());
				jo.put("actionState", p.getActionState());
				jo.put("y", p.getY());
				jo.put("token", p.getToken());
				me.getValue().getSession().write(jo.toString());
				// jrr.add(me.getValue());
				// ����û����Լ�
				jo.put("command", MainGame.COMMAND_LOOK);
				jo.put("name", tempP.getName());
				jo.put("x", tempP.getX());
				jo.put("y", tempP.getY());
				jo.put("moveState", tempP.getMoveState());
				jo.put("actionState", tempP.getActionState());
				jo.put("token", tempP.getToken());
				session.write(jo.toString());
			}
		}

	}
}
