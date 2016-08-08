package com.zzy.common.util;

/**
 * @author Zeus
 * @version 1.1
 * @createTime:2016年8月8日
 * @description:
 */
public class ByteUtil {
	/**
	 * long转bytes
	 */
	public static byte[] long2bytes(Long num) {
		byte[] b = new byte[8];
		for (int i = 0; i < 8; i++) {
			b[i] = (byte) (num >>> (56 - (i * 8)));
		}
		return b;
	}
	
	/**
	 * int转bytes
	 */
	public static byte[] int2bytes(Integer object) {
		byte[] bytes = new byte[4];
			for(int i=0;i<bytes.length;i++){
				bytes[i] = (byte)(object>>8*(3-i) & 0xFF);
			}
		return bytes;
	}
	/**
	 * bytes转long
	 */
	public static long bytes2long(byte[] b) {  
	    long temp = 0;  
	    long res = 0;  
	    for (int i=0;i<8;i++) {  
	        res <<= 8;  
	        temp = b[i] & 0xff;
	        res |= temp;  
	    }  
	    return res;  
	}  
	/**
	 * bytes转int
	 */
/*	public static int bytes2int(byte[] bytes) {  
        int num = bytes[0] & 0xFF;  
        num |= ((bytes[1] << 8) & 0xFF00);  
        num |= ((bytes[2] << 16) & 0xFF0000);  
        num |= ((bytes[3] << 24) & 0xFF000000);  
        return num;  
}  */
	public static int bytes2int(byte[] b) {  
		int temp=0;
		int res=0;
		for(int i=0;i<4;i++){
			res <<= 8;  
			temp = b[i] & 0xff;
			res |= temp;
		}
        return res;  
	}  
}
