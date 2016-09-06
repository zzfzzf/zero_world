
package com.zzy.dubbo.logic.Impl;

import com.alibaba.fastjson.JSONObject;
import com.zzy.common.base.ResultValue;
import com.zzy.common.base.UrlCommon;
import com.zzy.common.util.HttpUtil;
import com.zzy.dubbo.logic.IStatus;
/**
* @author zeus
* @date 2016年9月6日
* @version 1.0
* @describe:状态控制器
*/  
public class StatusController implements IStatus {

	@Override
	public JSONObject offline(JSONObject json) throws Exception {

		return null;
	}

	@Override
	public JSONObject area(JSONObject json) throws Exception {
		HttpUtil.getJson(UrlCommon.GET_ROLE_BY_AREA + json.getString("areaId"), json);
		return json;
	}

	@Override
	public JSONObject role(JSONObject json) throws Exception {
		HttpUtil.getJson(UrlCommon.GET_ROLE, json);
		return json;
	}
}

