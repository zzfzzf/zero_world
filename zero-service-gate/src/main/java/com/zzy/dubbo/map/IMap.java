package com.zzy.dubbo.map;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Administrator on 2016/9/9 0009.
 */
public interface IMap {
    /**
     * 切换地图
     */
    JSONObject mapChange(JSONObject json);

    /**
     * 可见人群
     */
    JSONObject showList(JSONObject json);

    /**
     * 进入地图
     */
    JSONObject intoMap(JSONObject json);

    /**
     * 离开地图
     */
    JSONObject outMap(JSONObject json);
}
