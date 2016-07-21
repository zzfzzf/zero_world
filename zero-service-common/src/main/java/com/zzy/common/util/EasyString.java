/**
* @author zeus
* @date 2016年7月20日
* @version 1.0
* @describe:用一句话描述该类是干嘛的
*/
package com.zzy.common.util;

public class EasyString {
	/**
	 * 判断是否为null并处理String对象 
	 */
	public static boolean trimAndValue(String message){
		return message==null?false:(message=message.trim())!=null;
	}
}

