package test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


import com.alibaba.fastjson.JSONObject;
import com.zzy.domain.base.GRole;

/**
 * @author zero
 * @version 1.1
 * @createTime : 2016年4月26日
 * @decript:
 */
public class Test {
	public static int count=0;
	public static void main(String[] args) throws Exception {
		Test.class.newInstance().test();
	}

	public void test() throws InstantiationException, IllegalAccessException, InvocationTargetException, IntrospectionException {
		JSONObject json=new JSONObject();
		User user = new User();
		user.setName("name");
		json.put("user", user);
		System.out.println(Test.transBean2Map(json.get("user")).get("password"));
	}
	 
	 
}

class A extends C {
	public void test() {
		
	} 
} 

class B extends C {
	public void test() {
		System.out.println(this.role);
	}
}

class C {
	public GRole role=null;
	public C(){
		this.role=D.role;
	}
}

class D {
	public static GRole role = new GRole();
	public D(){
		System.out.println("初始化 D");
	}
}