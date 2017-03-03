import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class Test {
    private static Logger log = Logger.getLogger(Test.class);
    public static void main(String args[]){
        new Test().log();
    }
    public void log(){
        log.info("dddd");
    }

}
