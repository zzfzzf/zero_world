package com.zzy.zero_service_db;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;





/**
 * Unit test for simple App.
 */
public class AppTest{
	class RandomHan {
	    private Random ran = new Random();
	    private final static int delta = 0x9fa5 - 0x4e00 + 1;
	     
	    public char getRandomHan() {
	        return (char)(0x4e00 + delta); 
	    }
	}
	public static void main(String[] args) throws Exception {
		AppTest.RandomHan rd=new AppTest().new RandomHan();
System.out.println(rd.getRandomHan() );
		}
		public AppTest init(Integer it) throws Exception{
			Map map = new HashMap();
			for(int i=0;i<1000000;i++){
				map.put(i, i);
				
			}
			long ct=System.currentTimeMillis();
				if( map.containsKey(999999)){       
					System.out.println("所花时间:"+(System.currentTimeMillis()-ct));
				}
			return this;
		}

		public static String getRandomJianHan(int len)
	    {
	        String ret="";
	          for(int i=0;i<len;i++){
	              String str = null;
	              int hightPos, lowPos; // 定义高低位 
	              Random random = new Random();
	              hightPos = (176 ); //获取高位值
	              lowPos = (161 ); //获取低位值
	              byte[] b = new byte[2];
	              b[0] = (new Integer(hightPos).byteValue());
	              b[1] = (new Integer(lowPos).byteValue());
	              try
	              {
	            	  System.out.println(b[0]+"=="+b[1]); 
	                  str = new String(b, "GBk"); //转成中文
	              }
	              catch (UnsupportedEncodingException ex)
	              {
	                  ex.printStackTrace();
	              }
	               ret+=str;
	          }
	      return ret;
	    }
}
