package com.zzy.zero.map;

import java.util.HashMap;
import java.util.Map;

import com.zzy.zero.role.Hero;

/**    
* ��һ�仰�������ļ���ʲô
* @author ������   
* @date 2015��11��9�� ����9:44:59 
* @version V1.0   
*/
public interface MainInterFace {
	// ������ɫ�б�
	public static final Map<String, Hero> heroMap = new HashMap<String, Hero>();
	// ��ɫˢ��֡��
	public static long FPS = 60;
	// ���ڴ�С
	public static int WINDOW_WIDTH = 700;
	public static int WINDOW_HEIGHT = 500;
    // ������
	public static final int COMMAND_TOKEN=0;
	public static final int COMMAND_LOGIN=1;
	public static final int COMMAND_LOOK=2;
	public static final int COMMAND_REMOVE=3;
	public static final int COMMAND_MOVE=4;
	public static final int COMMAND_EXIT=5;
	public static final int COMMAND_ADD=6;
	
    // �ͻ����罻���Ѵ洢
	public static final Map<String,Hero> onlineMap=new HashMap<String,Hero>();
	
	
}
