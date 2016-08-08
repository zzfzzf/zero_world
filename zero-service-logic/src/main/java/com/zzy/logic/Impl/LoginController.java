
package com.zzy.logic.Impl;

import org.apache.mina.core.session.IoSession;

import com.alibaba.fastjson.JSONObject;
import com.zzy.common.base.UrlCommon;
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
	public void login(JSONObject json,IoSession session) throws Exception{
		JSONObject result = HttpUtil.postJson(UrlCommon.LOGIN,json);
		session.write(result); 
   } 
}

