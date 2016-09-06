
package com.zzy.dubbo.logic;

import com.alibaba.fastjson.JSONObject;

/**
 * @author zeus
 * @version 1.0
 * @date 2016年7月27日
 * @describe:用一句话描述该类是干嘛的
 */
public interface IRole {
    /**
     * 移动
     */
    JSONObject move(JSONObject json);

    /**
     * 攻击
     */
    JSONObject attack(JSONObject json);

    /**
     * 技能
     */
    JSONObject skill(JSONObject json);

    /**
     * 骑乘
     */
    JSONObject ride(JSONObject json);

    /**
     * 摆摊
     */
    JSONObject stall(JSONObject json);

    /**
     * 聊天
     */
    JSONObject chat(JSONObject json);

    /**
     * 增加经验
     */
    JSONObject addExp(JSONObject json);

    /**
     * 减少经验
     */
    JSONObject reduceExp(JSONObject json);

    /**
     * 升级
     */
    JSONObject upgrade(JSONObject json);
}

