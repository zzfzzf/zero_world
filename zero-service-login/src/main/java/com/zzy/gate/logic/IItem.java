
package com.zzy.gate.logic;
/**
* @author zeus
* @date 2016年7月27日
* @version 1.0
* @describe:用一句话描述该类是干嘛的
*/
public interface IItem {
	/**
	 * 拾取物品
	 */
	 public void pickUp();
	 /**
	  * 丢弃物品
	  */
	 public void giveUp();
	 /**
	  * 销毁物品
	  */
	 public void destroy();
	 /**
	  * 装备物品
	  */
	 public void putOn();
	 /**
	  * 卸下物品
	  */
	 public void takeDown();
	 
}

