package test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;
import com.zzy.zero.domain.Player;

/**    
* ��һ�仰�������ļ���ʲô
* @author ������   
* @date 2015��9��23�� ����11:54:51 
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