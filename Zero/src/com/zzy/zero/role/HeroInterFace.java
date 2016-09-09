package com.zzy.zero.role;

import java.util.HashMap;
import java.util.Map;

/**    
* 用一句话描述该文件做什么
* @author 赵召阳   
* @date 2015年11月5日 下午2:00:47 
* @version V1.0   
*/
public interface HeroInterFace {
	// 角色动作状态
	/**
	 * 角色站立
	 */
	public static final int MOVE_STAND = 0;
	/**
	 * 角色向左
	 */
	public static final int MOVE_LEFT = 1;
	/**
	 * 角色向右
	 */
	public static final int MOVE_RIGHT = 2;
	/**
	 * 角色向上
	 */
	public static final int MOVE_UP = 3;
	/**
	 * 角色向下
	 */
	public static final int MOVE_DOWN = 4;
	/**
	 * 角色攻击
	 */
	public static final int ROLE_ATTACK = 0;
	/**
	 * 角色防御
	 */
	public static final int ROLE_DEFENSE = 0;
	/**
	 * 迈左脚
	 */
	public static final int STEP_LEFT = 1;
	/**
	 * 迈右脚
	 */
	public static final int STEP_RIGHT = 2;
	
}
