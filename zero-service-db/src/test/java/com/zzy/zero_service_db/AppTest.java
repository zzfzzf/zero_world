package com.zzy.zero_service_db;

import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.zzy.dubbo.DBService;
import com.zzy.dubbo.impl.DBServiceImpl;




/**
 * Unit test for simple App.
 */
public class AppTest{

	public static void main(String[] args) throws Exception {
			new AppTest().init(12);
		}
		public void init(Integer it) throws Exception{
			Map map = new HashMap();
			for(int i=0;i<1000000;i++){
				map.put(i, i);
			}
			long ct=System.currentTimeMillis();
			Iterator itr = map.keySet().iterator();
			while(itr.hasNext()){
				long tl = (long) itr.next();
				if( tl == 999999L){       
					System.out.println("所花时间:"+(System.currentTimeMillis()-ct));
				}
			}
		}
		public  Object getObj(String key,Class<? extends Object> class1){
			return null;
		}
}
