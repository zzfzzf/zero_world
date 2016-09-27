import java.awt.event.ActionListener;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class Test {
    static String str = "sss";
    public static void kao(){
        System.out.println("woshifangfa");
    }

}
class B {
   static int x=0;
}

class A extends Test {
    public static void main(String args[]){
        B.x=100;
        System.out.println(B.x);

    }
    public static void kao(){
        System.out.println("chongxie");
    }
}
