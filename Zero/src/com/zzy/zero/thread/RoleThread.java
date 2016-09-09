package com.zzy.zero.thread;

import com.zzy.zero.role.Hero;
import com.zzy.zero.run.MainGame;
import com.zzy.zero.run.ZeroClient;

/**
 * �ػ��߳�,����������ɫ�ƶ��Ų�
 * 
 * @author ������
 * @date 2015��8��27�� ����10:09:58
 * @version V1.0
 */
public class RoleThread extends Thread {
	private MainGame mainGame;
	private Hero hero;
	// ��ɫ�߳̿��� ÿ�δӼĴ�����ȡ��������
	private volatile boolean roleFlag = false;
    
	public RoleThread(Hero hero, MainGame mainGame) {
		this.setDaemon(true);
		this.mainGame = mainGame;
		this.hero = hero;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(10);
				mainGame.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	// ---------------------------------get/set---------------------------------
	// ��ɫ�߳̿��ػ�ȡ
	public boolean isRoleFlag() {
		return roleFlag;
	}

	// ��ɫ�߳̿�������
	public void setRoleFlag(boolean roleFlag) {
		this.roleFlag = roleFlag;
	}

}
