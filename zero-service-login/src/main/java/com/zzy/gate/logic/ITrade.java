
package com.zzy.gate.logic;
/**
* @author zeus
* @date 2016年7月27日
* @version 1.0
* @describe:用一句话描述该类是干嘛的
*/
public interface ITrade {
	/**
	 * 添加交易商品
	 */
	public void addItem();
	/**
	 * 添加交易金钱
	 */
	public void addMoney();
	/**
	 * 交易确认
	 */
	public void confirmTrade();
}

