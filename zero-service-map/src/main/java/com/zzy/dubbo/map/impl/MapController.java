package com.zzy.dubbo.map.impl;

import com.alibaba.fastjson.JSONObject;
import com.zzy.dubbo.db.DBService;
import com.zzy.dubbo.map.IMap;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;

/**
 * @author zeus
 * @date 2016年9月9日
 * @version 1.0
 * @describe:地图控制器
 */
public class MapController implements IMap {
    Map<String,Object> mapPond = null;
    private static Logger log = Logger.getLogger(MapController.class);

    DBService dbService = null;
    public MapController(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationClient.xml"});
        context.start();
        dbService = (DBService)context.getBean("dbService");
        init();
    }

    private void init(){
        try {
            mapPond = (Map<String, Object>) dbService.getObj("mapPond",HashMap.class);
            if(mapPond == null){
                initMap(mapPond);
            }
            log.info("地图池初始化完成");
        } catch (Exception e) {
            log.error("对象强转异常");
        }
    }

    private void initMap(Map tempMapPond){
        // 获取到地图列表 创建地图名字和数组 存入m
        List<Map<String,Object>> mapNames=null;
        Iterator<Map<String,Object>> it=mapNames.iterator();
        while(it.hasNext()){
            Map<String,Object> tempMap = it.next();
            tempMap.get("name");
            tempMap.get("width");
            tempMap.get("height");
        }
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
