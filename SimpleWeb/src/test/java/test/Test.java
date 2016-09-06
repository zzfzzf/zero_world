package test;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

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
		List list=new ArrayList();
		Test.test(() -> System.out.print("花式fuckworld！"));
		}

	public static void test(Runnable o) throws Exception {
		o.run();
	}
	 
	 
}

class A extends C {
	public static void test(Runnable o) {
		o.run();
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