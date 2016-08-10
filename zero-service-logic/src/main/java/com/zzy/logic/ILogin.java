
package com.zzy.logic;

import com.alibaba.fastjson.JSONObject;

/**
* @author zeus
* @date 2016年7月27日
* @version 1.0
* @describe: 处理用户上下线逻辑
*/
public interface ILogin {
	/**
	 * 上线
	 */
	public void online(JSONObject json) throws Exception;
	/**
	 * 下线
	 */
	public void offline(JSONObject json) throws Exception;
}

