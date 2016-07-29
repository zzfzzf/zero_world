
package com.zzy.logic;

import org.apache.mina.core.session.IoSession;

import com.alibaba.fastjson.JSONObject;

/**
* @author zeus
* @date 2016年7月27日
* @version 1.0
* @describe:用一句话描述该类是干嘛的
*/
public interface ILogin {
	public void login(JSONObject json,IoSession session);
}

