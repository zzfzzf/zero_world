
package com.zzy.logic;
/**
* @author zeus
* @date 2016年7月27日
* @version 1.0
* @describe:用一句话描述该类是干嘛的
*/
public interface IRole {
	/**
	 * 移动
	 */
	public void move();
	/**
	 * 攻击
	 */
	public void attack();
	/**
	 * 技能
	 */
	public void skill();
	/**
	 * 骑乘
	 */
	public void ride();
	/**
	 * 摆摊
	 */
	public void stall();
	/**
	 * 聊天
	 */
	public void chat();
}

