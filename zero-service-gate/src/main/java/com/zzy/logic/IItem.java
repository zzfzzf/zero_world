
package com.zzy.logic;
/**
* @author zeus
* @date 2016年7月27日
* @version 1.0
* @describe:用一句话描述该类是干嘛的
*/
public interface IItem {
	/**
	 *  拾取物品
	 */
	 public void pickUpItem();
	 /**
	  * 丢弃物品
	  */
	 public void giveUpItem();
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
	 /**
	  * 使用商品
	  */
	 public void useItem();
	 /**
	  * 拆分商品
	  */
	 public void splitItem();
}

