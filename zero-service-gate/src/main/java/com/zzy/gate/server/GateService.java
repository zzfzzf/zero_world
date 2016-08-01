/**
* @author zeus
* @date 2016年7月18日
* @version 1.0
* @describe:第一网关服务类
*/
package com.zzy.gate.server;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GateService {
	public static void main(String[] args) throws IOException {
		new GateService().init();
	}
	public void init() throws IOException{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationService.xml"});
		context.start(); 
        System.out.println("zero_zook服务启动~O(∩_∩)O哈哈~.");
        System.in.read(); // 按任意键退出
	}
}

