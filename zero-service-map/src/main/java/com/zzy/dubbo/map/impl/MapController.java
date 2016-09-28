package com.zzy.dubbo.map.impl;

import com.alibaba.fastjson.JSONObject;
import com.zzy.common.base.BasicSetting;
import com.zzy.common.util.Nothing;
import com.zzy.dubbo.db.DBService;
import com.zzy.dubbo.map.IMap;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;


/**
 * @author zeus
 * @version 1.0
 * @date 2016年9月9日
 * @describe:地图控制器
 */
public class MapController implements IMap {
    JSONObject mapPond = null;
    private static Logger log = Logger.getLogger(MapController.class);

    DBService dbService = null;

    public MapController() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationClient.xml"});
        context.start();
        dbService = (DBService) context.getBean("dbService");
        init();
    }

    private void init() {
        try {
            mapPond = (JSONObject) dbService.getObj("mapPond", JSONObject.class);
            if (mapPond == null) {
                initMap();
            }
            log.info("地图池初始化完成");
        } catch (Exception e) {
            log.error("地图初始化错误----" + e.getMessage());
        }
    }

    private void initMap() throws Exception {
        // 获取到地图列表 创建地图名字和数组 存入  统一初始化
        List<JSONObject> maps = (List) dbService.getObj("maps", List.class);
        if (maps != null) {
            mapPond = new JSONObject();
            for (JSONObject tempMap : maps) {
                Object[][] obj = new Object[tempMap.getInteger("width") / BasicSetting.BASE_AIR_GRID][tempMap.getInteger("height") / BasicSetting.BASE_AIR_GRID];
                for(int i=0;i<obj.length;i++){
                    for(int j=0;j<obj[i].length;j++){
                        obj[i][j] = new ArrayList();
                    }
                }
                mapPond.put(tempMap.getString("id"), obj);
                dbService.setObj("mapPond", mapPond);
            }
        }
        throw new NullPointerException("地图列表不能为null");
    }

    public JSONObject mapChange(JSONObject json) {
        return null;
    }

    public JSONObject showList(JSONObject json) {
        return null;
    }

    public JSONObject intoMap(JSONObject json) {
        return null;
    }

    public JSONObject outMap(JSONObject json) {
        List<JSONObject>[][] objs = (List[][]) mapPond.get(json.getString("mapId"));
        Iterator<JSONObject> it = objs[json.getInteger("x")][json.getInteger("y")].iterator();
        while(it.hasNext()){
            Nothing.doNothing(it.next().get("roleId").equals(json.get("roleId"))?it.remove():Nothing.doNothing());
        }
        return json;
    }
}
