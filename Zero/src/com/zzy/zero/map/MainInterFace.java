package com.zzy.zero.map;

import java.util.HashMap;
import java.util.Map;

import com.zzy.zero.role.Hero;

/**    
* 用一句话描述该文件做什么
* @author 赵召阳   
* @date 2015年11月9日 上午9:44:59 
* @version V1.0   
*/
public interface MainInterFace {
	// 其他角色列表
	public static final Map<String, Hero> heroMap = new HashMap<String, Hero>();
	// 角色刷新帧数
	public static long FPS = 60;
	// 窗口大小
	public static int WINDOW_WIDTH = 700;
	public static int WINDOW_HEIGHT = 500;
    // 命令行
	public static final int COMMAND_TOKEN=0;
	public static final int COMMAND_LOGIN=1;
	public static final int COMMAND_LOOK=2;
	public static final int COMMAND_REMOVE=3;
	public static final int COMMAND_MOVE=4;
	public static final int COMMAND_EXIT=5;
	public static final int COMMAND_ADD=6;
	
    // 客户端社交好友存储
	public static final Map<String,Hero> onlineMap=new HashMap<String,Hero>();
	
	
}
