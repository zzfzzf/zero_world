package kao;

import java.lang.reflect.Field;
/**
 * @author Zeus
 * @version 1.1
 * @createTime:2016年7月29日
 * @description:
 */
public class Test {
	private String user="fuck";
	public static void main(String[] args) {
		try {
			Class obj = Class.forName("Test");
			Field[] f = obj.getDeclaredFields();
				f[0].setAccessible(true);
				System.out.println(f[0].getName()+":"+f[0].get(obj.newInstance()));

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
