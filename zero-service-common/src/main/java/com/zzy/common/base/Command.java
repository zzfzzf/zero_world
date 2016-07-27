/**
* @author zeus
* @date 2016年7月24日
* @version 1.0
* @describe:用一句话描述该类是干嘛的
*/
package com.zzy.common.base;

public interface Command {
	/**
	 * 登录
	 */
	public static String LOGIN="login";
	/**
	 * 在线数量
	 */
	public static String ONLINE_NUM="onlineNum";
	/**
	 * 角色移动
	 */
	public static String MOVE="move";
	/**
	 * 玩家贸易 
	 */
	public static String TRADE="trade";
	/**
	 * 拾取物品
	 */
	public static String PICKUP="pickUp";
	
}
