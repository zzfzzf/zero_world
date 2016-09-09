package com.zzy.zero.util;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**    
* 字符编码工具类
* @author 赵召阳   
* @date 2015年9月15日 下午5:38:23 
* @version V1.0   
*/
public class EasyCharset {
	// 设置编码格式
	private String sct = "utf-8";
	private Charset charset;

	public EasyCharset() {
		// 初始化编码格式
		charset = Charset.forName(sct);
	}
	/**
	 * 编码过程
	 */
	public ByteBuffer encode(String str) {
		return charset.encode(str);
	}

	/**
	 * 解码过程
	 */
	public String decode(ByteBuffer bb) {
		return charset.decode(bb).toString();
	}
	// -------------------------------get/set----------------------------------
	/**
	 * 得到当前编码格式
	 * @return
	 */
	public String getSct() {
		return sct;
	}

	/**
	 * 设置编码格式
	 * @param sct
	 */
	public void setSct(String sct) {
		this.sct = sct;
	}

}
