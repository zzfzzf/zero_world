package test;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.zzy.domain.base.GRole;
import springfox.documentation.spring.web.json.Json;

/**
 * @author zero
 * @version 1.1
 * @createTime : 2016年4月26日
 * @decript:
 */
public class Test {
	public static int count=0;
	public static void main(String[] args) throws Exception {
		 JSONObject json=new JSONObject();
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		json.put("list",list);
		JSONObject j= JSONObject.parseObject(json.toJSONString());
		System.out.print(((List)j.get("list")).get(0));
		}

	public static void test(Runnable o) throws Exception {
		o.run();
	}
	 
	 
}

