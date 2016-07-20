package com.zzy.service.gate;

import com.alibaba.fastjson.JSONObject;

/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月19日 
* @decript:
*/
public class Test {
   public static void main(String[] args) {
	   JSONObject json=new JSONObject();
	   json.put("xx", " this com");
	   String message=null;
	  JSONObject k= JSONObject.parseObject(message);
	  System.out.println(k);
}
}
