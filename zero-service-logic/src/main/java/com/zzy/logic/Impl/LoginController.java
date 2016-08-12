
package com.zzy.logic.Impl;

import com.alibaba.fastjson.JSONObject;
import com.zzy.common.util.HttpUtil;
import com.zzy.logic.ILogin;
/**
* @author zeus
* @date 2016年7月24日
* @version 1.0
* @describe:用一句话描述该类是干嘛的
*/  
public class LoginController implements ILogin {

	@Override
	public JSONObject online(JSONObject json) throws Exception {
		return json;
	}
 
	@Override
	public JSONObject offline(JSONObject json) throws Exception {
		return json;
	}

	
}

