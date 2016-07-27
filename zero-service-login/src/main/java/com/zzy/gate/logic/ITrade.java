
package com.zzy.gate.logic;
/**
* @author zeus
* @date 2016年7月27日
* @version 1.0
* @describe:用一句话描述该类是干嘛的
*/
public interface ITrade {
	/**
	 * 卖出
	 */
	public void sale();
	/**
	 * 买入
	 */
	public void buy();
	/**
	 * 交易确认
	 */
	public void confirmTrade();
}

