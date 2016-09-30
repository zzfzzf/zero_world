package com.zzy.common.base;

import com.alibaba.fastjson.JSONObject;
import com.zzy.common.util.Nothing;

import java.util.ArrayList;
import java.util.Objects;

/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月4日 
* @decript:
*/
public class ResultValue {

    public static final int SUCCESS=200;
    public static final int ADD_FAIL=301;
    public static final int UPDATE_FAIL=302;
    public static final int DELETE_FAIL=303;
    public static final int GET_FAIL=304;
    public static final int PARAM_FAIL=305;
    public static final int PARAM_NON_NULL=500;
    public static final int TOKEN_ERROR=306;
    public static final int LOGIN_FAIL=307; 
    /**
     * 传入对象,返回一个新json
     */
    public static JSONObject success(Object object){
        return object instanceof JSONObject?success((JSONObject)object,null):(object instanceof Integer?success(new JSONObject(),null):success(new JSONObject(),object));

    }

    /**
     * 操作成功 返回传入json
     */
    public static JSONObject success(JSONObject json,Object object){
        json.put("status", SUCCESS);
        json.put("data", object);
        json.put("message", "操作成功");
        return json;
    }

    /**
     * 操作成功 返回新json 只包含status:success
     */
    public static JSONObject success(){
    	return success(null);
    }

    /**
     * 参数为null
     */
    public static JSONObject requireNonNull(){
    	return fail(PARAM_NON_NULL,"参数不能为null");
    }
    /**
     * 操作失败
     * @param status 状态码
     * @param message 提示信息
     */
    public static JSONObject fail(Integer status,String message){
    	JSONObject json=new JSONObject();
    	json.put("status", status);
    	json.put("message", message);
    	return json;
    }  
}
