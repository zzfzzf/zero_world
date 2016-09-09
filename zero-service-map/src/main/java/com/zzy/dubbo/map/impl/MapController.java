package com.zzy.dubbo.map.impl;

import com.alibaba.fastjson.JSONObject;
import com.zzy.dubbo.db.DBService;
import com.zzy.dubbo.map.IMap;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zeus
 * @date 2016年9月9日
 * @version 1.0
 * @describe:地图控制器
 */
public class MapController implements IMap {
    DBService dbService = null;
    public MapController(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationClient.xml"});
        context.start();
        dbService = (DBService)context.getBean("dbService");
    }

    @Override
    public JSONObject showList(JSONObject json) {

        return json;
    }

    @Override
    public JSONObject intoMap(JSONObject json) {
        return json;
    }

    @Override
    public JSONObject mapChange(JSONObject json) {
        return json;
    }

}
