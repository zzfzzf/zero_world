/**
 * @author Zeus
 * @version 1.1
 * @createTime:2016年7月29日
 * @description:
 */
public class Test {
	public static void main(String[] args) throws Exception {
		int sheng=0;
		int ping=0;
		int fu=0;

		for (int j=0;j<100000;j++){
			int i = (int)(Math.random()*3);
			if(i==0){
				sheng++;
			}else if(i==1){
				ping++;
			}else{                
				fu++;
			}
		}
		System.out.println("胜:"+sheng);
		System.out.println("平:"+ping);
		System.out.println("负:"+fu);
	}
}
