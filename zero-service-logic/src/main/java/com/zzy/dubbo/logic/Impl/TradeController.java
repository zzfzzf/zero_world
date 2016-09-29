
package com.zzy.dubbo.logic.Impl;


import com.alibaba.fastjson.JSONObject;
import com.zzy.common.base.UrlCommon;
import com.zzy.common.util.HttpUtil;
import com.zzy.dubbo.logic.ITrade;

/**
* @author zeus
* @date 2016年7月27日
* @version 1.0
* @describe:贸易管理器
*/
public class TradeController implements ITrade{

	@Override
	public JSONObject addItem(JSONObject json) {
		json.put("item", HttpUtil.getJson(UrlCommon.GET_ITEM).get("data"));
		return null;
	}

	@Override
	public JSONObject addMoney(JSONObject json) {
		return null;
	}

	@Override
	public JSONObject confirmTrade(JSONObject json) {
		return null;
	}

	@Override
	public JSONObject requestTrade(JSONObject json) {
		return null;
	}

	@Override
	public JSONObject stall(JSONObject json) {
		return null;
	}

	@Override
	public JSONObject putOnShelves(JSONObject json) {
		return null;
	}

	@Override
	public JSONObject pullOffShelves(JSONObject json) {
		return null;
	}
}

