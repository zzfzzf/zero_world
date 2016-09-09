package com.zzy.zero.domain;

import java.io.Serializable;

import org.apache.mina.core.session.IoSession;

/**    
* 一个用户类 拥有name username 签名等各种属性
* @author 赵召阳   
* @date 2015年9月28日 上午10:20:15 
* @version V1.0   
*/
public class Player implements Serializable {
	// 游戏昵称
	public String name;
	// 帐号
	String userName = "meiyou";
	// 最大生命值
	String maxLife;
	// 当前生命值
	String currentLife;
	// 角色状态 中毒。。。。
	String state;
	// 角色session
	IoSession session;
	// 角色坐标
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
