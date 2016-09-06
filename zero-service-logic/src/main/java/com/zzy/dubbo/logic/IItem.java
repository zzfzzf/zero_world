
package com.zzy.dubbo.logic;

import com.alibaba.fastjson.JSONObject;

/**
* @author zeus
* @date 2016年7月27日
* @version 1.0
* @describe:用一句话描述该类是干嘛的
*/
 public interface IItem {
	/**
	 *  拾取物品
	 */
	  JSONObject pickUpItem(JSONObject json);
	 /**
	  * 丢弃物品
	  */
	  JSONObject giveUpItem(JSONObject json);
	 /**
	  * 销毁物品
	  */
	  JSONObject destroy(JSONObject json);
	 /**
	  * 装备物品
	  */
	  JSONObject putOn(JSONObject json);
	 /**
	  * 卸下物品
	  */
	  JSONObject takeDown(JSONObject json);
	 /**
	  * 使用商品
	  */
	  JSONObject useItem(JSONObject json);
	 /**
	  * 拆分商品
	  */
	  JSONObject splitItem(JSONObject json);
}

