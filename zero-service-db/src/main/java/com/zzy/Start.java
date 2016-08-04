package com.zzy;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzy.gate.GateHandler;

/**
* @author Zeus
* @version 1.1
* @createTime:2016年8月4日 
* @description:
*/
public class Start {
	private static Logger log = Logger.getLogger(Start.class);
	public Start() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"dubboService.xml"});
		context.start(); 
		log.info("--------------------db服务器已启动---------------------");
        System.in.read(); // 按任意键退出
	}

	public static void main(String[] args) {
		new Start();
	}
	
}
