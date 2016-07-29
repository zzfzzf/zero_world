import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.zzy.common.base.Command;
import com.zzy.logic.ILogin;

/**
 * @author Zeus
 * @version 1.1
 * @createTime:2016年7月29日
 * @description:
 */
public class Test {
	public static void main(String[] args) throws Exception {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					new String[] { "applicationClient.xml" });
			context.start();
			ILogin login = (ILogin) context.getBean("loginLogic");
			System.out.println("拿到了");
			JSONObject json = new JSONObject();
			json.put("command", Command.LOGIN);
			json.put("username", 1); 
			json.put("password", 1);
			login.login(json, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
