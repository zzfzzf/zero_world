package com.zzy.zero.domain;

import java.io.Serializable;

import org.apache.mina.core.session.IoSession;

/**    
* һ���û��� ӵ��name username ǩ���ȸ�������
* @author ������   
* @date 2015��9��28�� ����10:20:15 
* @version V1.0   
*/
public class Player implements Serializable {
	// ��Ϸ�ǳ�
	public String name;
	// �ʺ�
	String userName = "meiyou";
	// �������ֵ
	String maxLife;
	// ��ǰ����ֵ
	String currentLife;
	// ��ɫ״̬ �ж���������
	String state;
	// ��ɫsession
	IoSession session;
	// ��ɫ����
	int actionState;
	int x;
	int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Player() {

	}

	public void fangfa() {

	}

	public IoSession getSession() {
		return session;
	}

	public void setSession(IoSession session) {
		this.session = session;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMaxLife() {
		return maxLife;
	}

	public void setMaxLife(String maxLife) {
		this.maxLife = maxLife;
	}

	public String getCurrentLife() {
		return currentLife;
	}

	public void setCurrentLife(String currentLife) {
		this.currentLife = currentLife;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getActionState() {
		return actionState;
	}

	public void setActionState(int actionState) {
		this.actionState = actionState;
	}

	
}
