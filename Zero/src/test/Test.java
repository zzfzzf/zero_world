package test;



import java.awt.Point;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**    
* ��һ�仰�������ļ���ʲô
* @author ������   
* @date 2015��11��9�� ����9:35:36 
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
