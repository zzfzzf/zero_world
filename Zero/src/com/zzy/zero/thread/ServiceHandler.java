package com.zzy.zero.thread;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonBeanProcessor;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import sun.net.www.content.text.plain;

import com.zzy.zero.map.MainInterFace;
import com.zzy.zero.role.Hero;
import com.zzy.zero.run.MainGame;
import com.zzy.zero.util.EasyImage;

/**    
* 用一句话描述该文件做什么
* @author 赵召阳   
* @date 2015年9月22日 下午5:50:42 
* @version V1.0   
*/
public class ServiceHandler extends IoHandlerAdapter {

	HashMap<String, Hero> serviceMap;
	Map<String, Hero>[][] mapArr = null;
	// 背景图片
	BufferedImage bgimage;
	// easy图片处理器
	EasyImage ei;
	// json配置
	JsonConfig jsonConfig;
	public ServiceHandler(HashMap<String, Hero> serviceMap) throws IOException {
		init(serviceMap);
	}

	/**
	 * 初始化
	 * @param serviceMap
	 * @throws IOException
	 */
	public void init(HashMap<String, Hero> serviceMap) throws IOException {
		bgimage = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/bg.png"));
		ei = new EasyImage(bgimage);
		ei.split(230, 170);
		mapArr = new Map[ei.getSplitNumX()][ei.getSplitNumY()];
		// 初始化数组
		for (int i = 0; i < ei.getSplitNumX(); i++) {
			for (int j = 0; j < ei.getSplitNumY(); j++) {
				mapArr[i][j] = new HashMap<String, Hero>();
			}
		}
		this.serviceMap = serviceMap;
		jsonConfig = new JsonConfig();
		jsonConfig.setIgnoreTransientFields(true);
	}

	/**
	 *  连接返回token
	 */
	public void reToken(IoSession session) {
		JSONObject jo = new JSONObject();
		jo.put("command", MainGame.COMMAND_TOKEN);
		jo.put("token", session.getId()+"");
		session.write(jo.toString());
	}

	// 当一个客户端连接进入时
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		this.reToken(session);
	}

	/**
	 * 捕捉异常
	 */
	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		Exception e = (Exception) cause;
		e.printStackTrace();
	}
	/**
	 * 登陆逻辑
	 * @param session 当前链接session
	 * @param jo 当前解析json
	 */
   private void loginLogic(IoSession session,JSONObject jo){
	   if (true) {
			String name = "查询出来的名字";
			// 验证成功之后才返回该字段
			// String allowLogin=SQL(从数据库中获取);
			// 查询角色坐标并计算
			int tempX = 300;
			int tempY = 300;
			// 计算下标
			int tempI = (int) Math.ceil(tempX / ei.getSplitSizeX());
			int tempJ = (int) Math.ceil(tempY / ei.getSplitSizeY());
			System.out.println("最初切割x，y" + ei.getSplitSizeX());
			// 验证通过
			jo = new JSONObject();
			jo.put("command", MainGame.COMMAND_LOGIN);
			jo.put("state", "ok");
			session.write(jo.toString());
			// 存入session和用户名和游戏昵称
			Hero h = new Hero();
			h.setToken(session.getId()+"");
			h.setSession(session);
			// 该昵称从数据库查出
			h.setName(name);
			// 得到角色坐标（从数据库查出)
			h.setX(321);
			h.setY(242);
			// 查询当前登录在哪个坐标内
			serviceMap.put(session.getId() + "", h);
			mapArr[tempI][tempJ].put(session.getId() + "", h);
			// 查询九格的所有玩家
			this.iterMapArr(this.otherNotice(tempI, tempJ), session, h);
			System.out.println("用户" + session.getId() + "进入服务器,当前用户数量" + serviceMap.size());
			for(Map.Entry<String, Hero> mp : serviceMap.entrySet()){
				if(!mp.getKey().equals((session.getId()+""))){
					// 创建一个临时对象容器
					Hero tempH=mp.getValue();
					// 设置对象的命令行
					h.setCommand(MainGame.COMMAND_ADD);
					// 向其他玩家发送自己的上线信息
				    tempH.getSession().write(JSONObject.fromObject(h,jsonConfig));
				    // 设置对象的命令行
				    tempH.setCommand(MainGame.COMMAND_ADD);
				    // 想自己发送其他玩家的上线信息
					session.write(JSONObject.fromObject(tempH,jsonConfig));
				}
			}
		}
   }
	
	/**
	 * 当客户端发送消息到达时
	 */
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		// 收到的信息字符串
		String rmsg = (String) message;
		if (rmsg != null && rmsg.length() > 0) {
			JSONObject jo = JSONObject.fromObject(message);
			int command = jo.getInt("command");
			switch (command) {
			case MainGame.COMMAND_LOGIN:
				// 登陆逻辑处理
				this.loginLogic(session,jo);
				break;
			case MainGame.COMMAND_MOVE:
				// 移动逻辑处理
				this.moveLogic(session, jo);
				break;
			}
		}
	}

	/**
	 * 用戶退出处理逻辑
	 */
	private void exitLogic(IoSession session){
		for(Map.Entry<String, Hero> mp:serviceMap.entrySet()){
			Hero tempH=mp.getValue();
			if(!tempH.getSession().equals(session)){
				JSONObject jo = new JSONObject();
				jo.put("command", MainGame.COMMAND_REMOVE);
				jo.put("token", session.getId()+"");
				tempH.getSession().write(jo.toString());
				jo.put("command", MainGame.COMMAND_EXIT);
				tempH.getSession().write(jo.toString());
			}
			
		}
		Hero temp=serviceMap.get(session.getId()+"");
		int tempX=(int) Math.ceil(temp.getX() / ei.getSplitSizeX());
		int tempY=(int) Math.ceil(temp.getY() / ei.getSplitSizeY());
		mapArr[tempX][tempY].remove(session.getId()+"");
		serviceMap.remove(session.getId()+"");
		System.out.println("有用户异常退出,当前剩余用户:" + serviceMap.size());
	}
	
	/**
	 * 用户登录处理逻辑 
	 */
	private void moveLogic(IoSession session,JSONObject jo){
		// 获取token
		String token=jo.getString("token");
		// 根据token拿到对象
		Hero p = serviceMap.get(token);
		// 拿到角色之前位置
		int preX = (int) Math.ceil(p.getX() / ei.getSplitSizeX());
		int preY = (int) Math.ceil(p.getY() / ei.getSplitSizeY());
		p.setX(jo.getInt("x"));
		p.setY(jo.getInt("y"));
		p.setActionState(jo.getInt("actionState"));
		p.setMoveState(jo.getInt("moveState"));
		// 取到最新角色位置
		int tempI = (int) Math.ceil(p.getX() / ei.getSplitSizeX());
		int tempJ = (int) Math.ceil(p.getY() / ei.getSplitSizeY());
		if (preX != tempI || preY != tempJ) {
			System.out.println(session.getId() + "当前所在位置" + tempI + "," + tempJ);
			// 走出一个范围通知当前范围周围所有玩家
			Map<String, Hero> ma = this.otherNotice(preX, preY);
			JSONObject tempJson = new JSONObject();
			tempJson.put("command", MainGame.COMMAND_REMOVE);
			for (Map.Entry<String, Hero> me : ma.entrySet()) {
				Hero tempP = me.getValue();
				if (!(me.getKey().equals(session.getId() + ""))) {
					System.out.println("我循环了两次" + me.getKey().equals(session.getId() + ""));
					tempJson.put("token", session.getId() + "");
					tempP.getSession().write(tempJson.toString());
				}
				// 走出该区域后通知自己删除其他玩家信息在重新添加
				tempJson.put("token", tempP.getToken());
				session.write(tempJson.toString());
			}
			// 越界限制
			if (preX >= 0 && preX < ei.getSplitNumX() && preY >= 0 && preY < ei.getSplitNumY()) {
				mapArr[preX][preY].remove(token);
			}
			// 越界限制
			if (tempI >= 0 && tempI < ei.getSplitNumX() && tempJ >= 0 && tempJ < ei.getSplitNumY()) {
				mapArr[tempI][tempJ].put(token, p);
			}
		}
		this.iterMapArr(this.otherNotice(tempI, tempJ), session, p);
	}
	// 当一个客户端连接关闭时
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		this.exitLogic(session);
	}

	/**
	 * 要通知的八个方格玩家列表
	 */
	public Map<String, Hero> otherNotice(int tempI, int tempJ) {
		// 处理移动到地图的最左侧
		if (tempI < 0) {
			System.out.println("超出界限" + tempI);
			return new HashMap<String, Hero>();
		} else if (tempI > 0) {
			tempI = tempI - 1;
		}

		// 循环寻找附近八个
		List<Map<String, Hero>> tempList = new ArrayList<Map<String, Hero>>();
		// 如果距离地图右侧过近 则无法循环三次(确定横向越界范围)
		int tempN = (ei.getSplitNumX() - tempI) >= 3 ? 3 : (ei.getSplitNumX() - tempI);
		for (int tempK = 0; tempK < tempN; tempK++) {
			if (tempJ >= 0 && tempJ < (ei.getSplitNumY() - 1)) {
				if (tempJ != 0) {
					tempList.add(mapArr[tempI][tempJ - 1]);
				}
				tempList.add(mapArr[tempI][tempJ]);
				tempList.add(mapArr[tempI][tempJ + 1]);
			}
			tempI++;
		}
		Map<String, Hero> allMap = new HashMap<String, Hero>();
		// 到此位置是循环将所有数组拆开
		for (int i = 0; i < tempList.size(); i++) {
			Map<String, Hero> map = tempList.get(i);
			Iterator<?> iter = map.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry<String, Hero> entry = (Map.Entry) iter.next();
				allMap.put(entry.getKey(), entry.getValue());
			}
		}
		return allMap;
	}


	/**
	 * 遍历广播地图可见
	 */
	public void iterMapArr(Map<String, Hero> map2, IoSession session, Hero p) {
		JSONObject jo = new JSONObject();

		for (Map.Entry<String, Hero> me : map2.entrySet()) {
			Hero tempP = me.getValue();
			if (!(me.getKey().equals(session.getId() + ""))) {
				// 将自己的坐标发送给每一个人
				jo.put("command", MainGame.COMMAND_LOOK);
				jo.put("name", p.getName());
				jo.put("x", p.getX());
				jo.put("moveState", p.getMoveState());
				jo.put("actionState", p.getActionState());
				jo.put("y", p.getY());
				jo.put("token", p.getToken());
				me.getValue().getSession().write(jo.toString());
				// jrr.add(me.getValue());
				// 添加用户给自己
				jo.put("command", MainGame.COMMAND_LOOK);
				jo.put("name", tempP.getName());
				jo.put("x", tempP.getX());
				jo.put("y", tempP.getY());
				jo.put("moveState", tempP.getMoveState());
				jo.put("actionState", tempP.getActionState());
				jo.put("token", tempP.getToken());
				session.write(jo.toString());
			}
		}

	}
}
