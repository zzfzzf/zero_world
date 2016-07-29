package com.zzy.logic;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
* @author Zeus
* @version 1.1
* @createTime:2016年7月29日 
* @description:
*/
public class Start {
	public static void main(String[] args) throws IOException {
		new Start().init();
	}
	public void init() throws IOException{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationService.xml"});
		context.start();  
        System.out.println("zero_zook服务启动~O(∩_∩)O哈哈~.");
        System.in.read(); // 按任意键退出
	}
}
