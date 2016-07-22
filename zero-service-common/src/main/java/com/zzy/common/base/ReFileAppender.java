package com.zzy.common.base;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Priority;

/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月21日 
* @decript: 重写Log4j输出类 修改级别
*/
public class ReFileAppender extends DailyRollingFileAppender{
	   @Override  
	    public boolean isAsSevereAsThreshold(Priority priority) {  
	          //只判断是否相等，而不判断优先级     
	        return this.getThreshold().equals(priority);    
	    }    
}
