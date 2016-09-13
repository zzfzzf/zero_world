package com.zzy.dubbo.map.impl;

import com.alibaba.fastjson.JSONObject;
import com.zzy.dubbo.db.DBService;
import com.zzy.dubbo.map.IMap;
import org.apache.log4j.Logger;
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

    private List<Arrays> xxxMapList = null;// 声明地图容器变量
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
          xxxMapList=(List<Arrays>)dbService.getObj("xxxMap", ArrayList.class);
            if(xxxMapList==null){
                dbService.setObj("xxxMapList",new ArrayList<Arrays>());
            }
            log.info("地图池初始化完成");
        } catch (Exception e) {
            log.error("对象强转异常");
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
