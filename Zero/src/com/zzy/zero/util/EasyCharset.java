package com.zzy.zero.util;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**    
* �ַ����빤����
* @author ������   
* @date 2015��9��15�� ����5:38:23 
* @version V1.0   
*/
public class EasyCharset {
	// ���ñ����ʽ
	private String sct = "utf-8";
	private Charset charset;

	public EasyCharset() {
		// ��ʼ�������ʽ
		charset = Charset.forName(sct);
	}
	/**
	 * �������
	 */
	public ByteBuffer encode(String str) {
		return charset.encode(str);
	}

	/**
	 * �������
	 */
	public String decode(ByteBuffer bb) {
		return charset.decode(bb).toString();
	}
	// -------------------------------get/set----------------------------------
	/**
	 * �õ���ǰ�����ʽ
	 * @return
	 */
	public String getSct() {
		return sct;
	}

	/**
	 * ���ñ����ʽ
	 * @param sct
	 */
	public void setSct(String sct) {
		this.sct = sct;
	}

}
