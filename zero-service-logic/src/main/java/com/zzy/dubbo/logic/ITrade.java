
package com.zzy.dubbo.logic;

import com.alibaba.fastjson.JSONObject;

/**
 * @author zeus
 * @version 1.0
 * @date 2016年7月27日
 * @describe:用一句话描述该类是干嘛的
 */
public interface ITrade {
    /**
     * 添加交易商品
     */
    JSONObject addItem(JSONObject json);

    /**
     * 添加交易金钱
     */
    JSONObject addMoney(JSONObject json);

    /**
     * 交易确认
     */
    JSONObject confirmTrade(JSONObject json);
    /**
     * 发起交易
     */
    JSONObject requestTrade(JSONObject json);

    /**
     * 摆摊
     */
    JSONObject stall(JSONObject json);

    /**
     * 上架物品
     */
    JSONObject putOnShelves(JSONObject json);
    /**
     * 下架物品
     */
    JSONObject pullOffShelves(JSONObject json);
}

