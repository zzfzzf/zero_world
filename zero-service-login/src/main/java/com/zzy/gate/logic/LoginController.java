/**
* @author zeus
* @date 2016年7月24日
* @version 1.0
* @describe:用一句话描述该类是干嘛的
*/
package com.zzy.gate.logic;

import org.apache.mina.core.session.IoSession;

import com.alibaba.fastjson.JSONObject;
import com.zzy.common.base.HttpUtil;

public class LoginController {
	public void loginLogic(JSONObject json,IoSession session){
		String url = "http://localhost:8080/zeus/user/login";
		JSONObject result = HttpUtil.postJson(url,json);
		session.write(result);
	}
}

