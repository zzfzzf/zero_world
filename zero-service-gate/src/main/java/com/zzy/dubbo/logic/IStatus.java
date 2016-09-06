
package com.zzy.dubbo.logic;

import com.alibaba.fastjson.JSONObject;

/**
* @author zeus
* @date 2016年7月27日
* @version 1.0
* @describe: 处理用户上下线逻辑
*/
public interface IStatus {
	/**
	 * 下线
	 */
	JSONObject offline(JSONObject json) throws Exception;

	JSONObject area(JSONObject json)throws Exception;

	JSONObject role(JSONObject json)throws Exception;



	
}

