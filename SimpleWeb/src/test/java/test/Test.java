package test;

import java.util.ArrayList;
import java.util.List;

import com.zzy.domain.base.GRole;

/**
 * @author zero
 * @version 1.1
 * @createTime：2016年4月26日 @decript:
 */
public class Test {
	public static int count=0;
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Test.class.newInstance().test();
	}

	public void test() throws InstantiationException, IllegalAccessException {
		int n=350; 
		js(350,0);
		System.out.println(count+1);
	}
	public int js(int i,int j){
		count+=1;
		if(j>35){
			j=35;
		}else{
			j=j+5;
		}
		if((i=i-j)>0){
			js(i,j);
		}
		return i;
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