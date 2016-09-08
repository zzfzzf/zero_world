package com.zzy.dubbo.logic;

import com.alibaba.fastjson.JSONObject;

/**
 * @author zeus
 * @date 2016年9月6日
 * @version 1.0
 * @describe:怪物接口
 */
public interface IMonster {
    /**
     * 怪物死亡
     */
    JSONObject monsterDeath(JSONObject json);

    /**
     * 怪物生成
     */
    JSONObject monsterProduce(JSONObject json);
}
