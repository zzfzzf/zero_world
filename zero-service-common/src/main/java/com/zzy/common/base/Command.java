/**
* @author zeus
* @date 2016年7月24日
* @version 1.0
* @describe:用一句话描述该类是干嘛的
*/
package com.zzy.common.base;

public interface Command {
	/**
	 * token 令牌
	 */
	public static String TOKEN = "token";
	/**
	 * 登录
	 */
	public static String LOGIN="login";
	
	/**
	 * 获取服务大区
	 */
	public static String AREA = "area";
	/**
	 * 获取大区下角色
	 */
	public static String ROLE = "role";
	/**
	 * 在线数量
	 */
	public static String ONLINE_NUM="onlineNum";
	/**
	 * 上线
	 */
	public static String ONLINE="online";
	/**
	 * 离线
	 */
	public static String OFFLINE="offLine";
//	----------------------------角色指令------------------------
	/**
	 * 角色移动
	 */
	public static String MOVE="move";
	/**
	 * 攻击
	 */
	public static String ATTACK="attack";
	/**
	 * 技能
	 */
	public static String SKILL="skill";
	/**
	 * 骑乘
	 */
	public static String RIDE="ride";
	/**
	 * 摆摊
	 */
	public static String STALL="stall";
	/**
	 * 聊天
	 */
	public static String CHAT="chat";
//	----------------------------交易指令------------------------
	/**
	 * 确认交易
	 */
	public static String CONFIRM_TRADE="comfirmTrade";
	/**
	 * 添加金钱
	 */
	public static String ADD_MONEY="addMoney";
	/**
	 * 添加物品
	 */
	public static String ADD_ITEM="addItem";
//	----------------------------物品指令------------------------
	/**
	 * 装备物品
	 */
	public static String PUT_ON="putOn";
	/**
	 * 使用物品
	 */
	public static String USE_ITEM="useItem";
	/**
	 * 放弃物品
	 */
	public static String GIVE_UP_ITEM="giveUpItem";
	/**
	 * 销毁物品
	 */
	public static String DESTROY_ITEM="destroyItem";
	/**
	 * 卸下物品
	 */
	public static String TAKE_DOWN="takeDown";
	/**
	 * 拾取物品
	 */
	public static String PICK_UP_ITEM="pickUpItem";
	/**
	 * 拆分物品
	 */
	public static String SPLIT_ITEM="splitItem";
//	----------------------------物品指令------------------------
	/**
	 * 拾取金币
	 */
	public static String PICK_UP_MONEY="pickUpMoney";
	/**
	 * 丢弃金币
	 */
	public static String GIVE_UP_MONEY="giveUpMoney";
}
