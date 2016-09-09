package com.zzy.zero.exception;


/**    
* 自定义异常 用于打印
* @author 赵召阳   
* @date 2015年8月27日 下午2:21:53 
* @version V1.0   
*/
public class CustomException extends Exception {
	private static final long serialVersionUID = 1L;
    String msg;
	public CustomException() {
		super();
	}

	public CustomException(String msg) {
		super(msg);
		this.msg=msg;
	}
}
