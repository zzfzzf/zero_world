package com.zzy.dubbo.logic;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Zeus
 * @version 1.1
 * @createTime:2016年7月28日
 * @description:
 */
public interface IMoney {
	/**
	 * 拾取金币
	 */
	 JSONObject pickUpMoney(JSONObject json);

	/**
	 * 丢弃金币
	 */
	 JSONObject giveUpMoney(JSONObject json);
}
