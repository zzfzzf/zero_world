package com.zzy.dubbo;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
* @author Zeus
* @version 1.1
* @createTime:2016年8月4日 
* @description:
*/
public class Start {
	private static Logger log = Logger.getLogger(Start.class);
	public Start()  {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationService.xml"});
			context.start(); 
			log.info("--------------------map服务器已启动---------------------");
			System.in.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Start();
	}
	
}
