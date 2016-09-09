package com.zzy.zero.thread;

import com.zzy.zero.role.Hero;
import com.zzy.zero.run.MainGame;
import com.zzy.zero.run.ZeroClient;

/**
 * 守护线程,用来减缓角色移动脚步
 * 
 * @author 赵召阳
 * @date 2015年8月27日 上午10:09:58
 * @version V1.0
 */
public class RoleThread extends Thread {
	private MainGame mainGame;
	private Hero hero;
	// 角色线程开关 每次从寄存器获取最新数据
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
	// 角色线程开关获取
	public boolean isRoleFlag() {
		return roleFlag;
	}

	// 角色线程开关设置
	public void setRoleFlag(boolean roleFlag) {
		this.roleFlag = roleFlag;
	}

}
