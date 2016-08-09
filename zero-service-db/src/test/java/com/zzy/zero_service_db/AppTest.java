package com.zzy.zero_service_db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;





/**
 * Unit test for simple App.
 */
public class AppTest{

	public static void main(String[] args) throws Exception {
			new AppTest().test();
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

		public void test(){
			List list = new ArrayList();
			for(int i=0;i<1000000;i++){
				list.add(i);
			}
			Iterator it = list.iterator();
			long ctime = System.currentTimeMillis();
			while(it.hasNext()){
				if((int)it.next()==999999){
					System.out.println("用时:"+(System.currentTimeMillis()-ctime));
				}
			}
		}
}
