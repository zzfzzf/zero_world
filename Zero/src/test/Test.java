package test;



import java.awt.Point;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**    
* 用一句话描述该文件做什么
* @author 赵召阳   
* @date 2015年11月9日 上午9:35:36 
* @version V1.0   
*/
public class Test {
	
	private transient int a = 1;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

}
