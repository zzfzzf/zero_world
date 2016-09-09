package com.zzy.dubbo.map;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Administrator on 2016/9/9 0009.
 */
public interface IMap {

    JSONObject mapChange(JSONObject json);

    JSONObject showList(JSONObject json);

    JSONObject intoMap(JSONObject json);
}
