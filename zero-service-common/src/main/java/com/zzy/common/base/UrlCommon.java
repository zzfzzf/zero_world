package com.zzy.common.base;

/**
 * @author Zeus
 * @version 1.1
 * @createTime：2016年7月27日
 * @describe: 连接常量
 */
public interface UrlCommon {
    String HOST = "127.0.0.1";
    int PORT = 8080;
    /**
     * 基础URL
     */
    String BASE_URL = "http://" + HOST + ":" + PORT + "/zeus";
    /**
     * 登陆验证
     */
    String LOGIN = BASE_URL + "/user/login";
    //-------------------------------------offline---------------------------------
    /**
     * 获取角色
     */
    String GET_ROLE = BASE_URL + "/role/";
    /**
     * 根据大区返回角色列表
     */
    String GET_ROLE_BY_AREA = BASE_URL + "/role/area/";
    /**
     * 大区列表
     */
    String LIST_AREA = BASE_URL + "/area";
    /**
     * 根据用户名获取用户
     */
    String GET_USER_BY_USERNAME = BASE_URL + "/user/username/";
    //------------------------------------maplogic---------------------------------
    /**
     * map列表
     */
    String GET_MAP = BASE_URL + "/map";

    //------------------------------------trade-----------------------------------
    /**
     * 获取物品信息
     */
    String GET_ITEM = BASE_URL + "/item/";

}
