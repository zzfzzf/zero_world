
package com.zzy.logic;

import com.alibaba.fastjson.JSONObject;

/**
* @author zeus
* @date 2016年7月27日
* @version 1.0
* @describe:用一句话描述该类是干嘛的
*/
public interface ILogin {
	public void online(JSONObject json) throws Exception;
	public void offline(JSONObject json) throws Exception;
}

