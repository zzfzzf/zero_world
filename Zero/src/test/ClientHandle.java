package test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;
import com.zzy.zero.domain.Player;

/**    
* 用一句话描述该文件做什么
* @author 赵召阳   
* @date 2015年9月23日 上午11:54:51 
* @version V1.0   
*/
public class ClientHandle {
	Map<String, Player> m;

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(UUID.randomUUID().toString().replace("-", ""));
		}
	}

	public ClientHandle() {
		m = new HashMap();
		m.put("ok", new Player());
	}

	public void fuck() {
		System.out.println(JSONObject.fromObject(m));
	}

}

class Fuck {
	public int k = 0;

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

}