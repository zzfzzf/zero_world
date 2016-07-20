package com.zzy.service.gate;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月19日 
* @decript:
*/
public class Test {
   public static void main(String[] args) {
	   ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
	   System.out.println("d");
}
}
