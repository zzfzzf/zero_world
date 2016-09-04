package com.zzy.common.base;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月27日 
* @describe: 连接常量
*/
public class UrlCommon {
	public static final String HOST="127.0.0.1";
	public static final int PORT = 8080;
	/**
	 * 基础URL
	 */
	public static final String BASE_URL="http://"+HOST+":"+PORT;
	private static final String LOGIN=BASE_URL+"/zeus/user/login";
	/**
	 * 获取角色
	 */
	public static final String GET_ROLE=BASE_URL+"/zeus/role/";
	/**
	 * 根据大区返回角色列表
	 */
	public static final String GET_ROLE_BY_AREA =BASE_URL+"/zeus/role/area/";
	/**
	 * 大区列表
	 */
	public static final String LIST_AREA =BASE_URL+"/zeus/area";
	/**
	 * 根据用户名获取用户
	 */
	public static final String GET_USER_BY_USERNAME =BASE_URL+"/zeus/user/username/";
}
