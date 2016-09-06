/**
 * @author Zeus
 * @version 1.1
 * @createTime:2016年7月29日
 * @description:
 */
public class Test {
	public static void main(String[] args) throws Exception {
		int x=1,y=3; // 1  11
		x=x^y;
		System.out.println("x="+x);
		y=y^x;
		System.out.println("y="+y);
		x=x^y;
		System.out.println("x(终)="+x);
	}
}
