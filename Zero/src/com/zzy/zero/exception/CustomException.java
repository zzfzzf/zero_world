package com.zzy.zero.exception;


/**    
* �Զ����쳣 ���ڴ�ӡ
* @author ������   
* @date 2015��8��27�� ����2:21:53 
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
