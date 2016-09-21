package com.zzy.dubbo.map.impl;

import com.alibaba.fastjson.JSONObject;
import com.zzy.dubbo.db.DBService;
import com.zzy.dubbo.map.IMap;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;


/**
 * @author zeus
 * @date 2016年9月9日
 * @version 1.0
 * @describe:地图控制器
 */
public class MapController implements IMap {
    private int baseGrid = 500;
    JSONObject mapPond = null;
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
            mapPond = (JSONObject) dbService.getObj("mapPond",JSONObject.class);
            if(mapPond == null){
                initMap();
            }
            log.info("地图池初始化完成");
        } catch (Exception e) {
            log.error("地图初始化错误----"+e.getMessage());
        }
    }

    private void initMap() throws Exception {

        // 获取到地图列表 创建地图名字和数组 存入  统一初始化
        List<JSONObject> mapNames= (List<JSONObject>) dbService.getObj("mapNames",List.class);
        if(mapNames != null){
            mapPond=new JSONObject();
            Iterator<JSONObject> it=mapNames.iterator();
            while(it.hasNext()){
                Map<String,Object> tempMap = it.next();
                mapPond.put((String)tempMap.get("name"),new Object[(Integer)tempMap.get("width")][(Integer)tempMap.get("height")]);
            }
        }
        throw new NullPointerException("地图列表不能为null");
    }

    @Override
    public JSONObject mapChange(JSONObject json) {
        return null;
    }

    public JSONObject showList(JSONObject json) {
        return null;
    }

    public JSONObject intoMap(JSONObject json) {
        return null;
    }
}
