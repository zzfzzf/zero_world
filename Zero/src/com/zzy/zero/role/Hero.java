package com.zzy.zero.role;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.mina.core.session.IoSession;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zzy.zero.domain.Player;
import com.zzy.zero.map.World;
import com.zzy.zero.run.MainGame;

/**
 * 角色类
 * 
 * @author 赵召阳
 * @date 2015年8月26日 下午4:14:34
 * @version V1.0
 */
public class Hero implements HeroInterFace {
	// command
	private int command=0;
    // token
	private String token="";
	// 游戏昵称
	public String name;
	// 帐号
	String userName = "meiyou";
	// 最大生命值
	String maxLife;
	// 当前生命值
	String currentLife;
	// 角色状态 中毒。。。。
	String state;
	// 角色session
	transient IoSession  session;
	// 角色动画计时器
	public int Timer = 0;
	// 角色当前状态
	private int actionState = 0;
	// 角色移动状态 默认3个 (迈左脚，迈右脚)
	private int moveState = 0;
	// 角色图片路径
	private String roleImageUrl = "roleup.png";
	// 角色图片
	private BufferedImage roleImage = null;
	// 切割图片坐标
	private int splitX = 62;
	private int splitY = 0;
	// 记录角色坐标
	@JsonIgnore
	private transient Point rolePoint = new Point(321, 242);
	// 角色位于屏幕坐标
	@JsonIgnore
	private transient Point centerPoint = new Point(321, 242);
	// 角色图片大小
	private int roleWidth = 62;
	private int roleHeight = 70;
	// 角色行走速度
	private int speed = 2;

	// =========================================================================
	public Hero(String name) {
		this.name = name;
	}

	public Hero() {

	}

	/**
	 * 生成角色 void 返回类型
	 * @throws null
	 */
	public void produceHero(Graphics2D g) {
		try {
			// 加载图片
			roleImage = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/" + roleImageUrl));
			// g.fillRect(300, 250, 63, 80);
			switch (moveState) {
			case 0:
				g.drawImage(roleImage.getSubimage(splitX, 0, roleWidth, roleHeight), centerPoint.x, centerPoint.y, null);
				break;
			case 1:
				g.drawImage(roleImage.getSubimage(moveState * splitX, 0, roleWidth, roleHeight), centerPoint.x, centerPoint.y, null);
				break;
			case 2:
				g.drawImage(roleImage.getSubimage(moveState * splitX, 0, roleWidth, roleHeight), centerPoint.x, centerPoint.y, null);
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 生成其他角色类
	 * @param g
	 */
	public void produceOther(Graphics2D g) {
		try {
			switch (actionState) {
			case MOVE_DOWN:
				roleImageUrl="roledown.png";
				break;
			case MOVE_UP:
				roleImageUrl="roleup.png";
				break;
			case MOVE_LEFT:
				roleImageUrl="roleleft.png";
				break;
			case MOVE_RIGHT:
				roleImageUrl="roleright.png";
				break;
			}
			// 加载图片
			roleImage = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/" + roleImageUrl));
			// g.fillRect(300, 250, 63, 80);
			switch (moveState) {
			case 0:
				g.drawImage(roleImage.getSubimage(splitX * moveState, 0, roleWidth, roleHeight), rolePoint.x, rolePoint.y, null);
				break;
			case 1:
				g.drawImage(roleImage.getSubimage(moveState * splitX, 0, roleWidth, roleHeight), rolePoint.x, rolePoint.y, null);
				break;
			case 2:
				g.drawImage(roleImage.getSubimage(moveState * splitX, 0, roleWidth, roleHeight), rolePoint.x, rolePoint.y, null);
				break;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 向上走
	public void goUp() {
		roleImageUrl = "roleup.png";
		this.actionState=MOVE_UP;
		// 不时时从服务器拿数据 只在角色移动的时候广播
		for (Map.Entry<String, Hero> me : MainGame.heroMap.entrySet()) {
			Hero tempH = me.getValue();
			tempH.setY(tempH.getY() + speed);
		}
		rolePoint.y=rolePoint.y-speed;
		World.Y=World.Y+speed;
	}

	// 向左走
	public void goLeft() {
		// 运动时角色图片
		roleImageUrl = "roleleft.png";
		// 设置运动方向
		actionState = MOVE_LEFT;
		// 不时时从服务器拿数据 只在角色移动的时候广播
		for (Map.Entry<String, Hero> me : MainGame.heroMap.entrySet()) {
			Hero tempH = me.getValue();
			tempH.setX(tempH.getX() + speed);
		}
		rolePoint.x = rolePoint.x - speed;
		// 地图随着反方向移动
		World.X = World.X + speed;
	}

	// 向右走
	public void goRight() {
		roleImageUrl = "roleright.png";
		actionState=MOVE_RIGHT;
		// 不时时从服务器拿数据 只在角色移动的时候广播
		for (Map.Entry<String, Hero> me : MainGame.heroMap.entrySet()) {
			Hero tempH = me.getValue();
			tempH.setX(tempH.getX() - speed);
		}
		rolePoint.x=rolePoint.x+speed;
		World.X=World.X-speed;
	}

	// 向下走
	public void goDown() {
		roleImageUrl = "roledown.png";
		actionState=MOVE_DOWN;
		// 不时时从服务器拿数据 只在角色移动的时候广播
		for (Map.Entry<String, Hero> me : MainGame.heroMap.entrySet()) {
			Hero tempH = me.getValue();
			tempH.setY(tempH.getY() - speed);
		}
		rolePoint.y=rolePoint.y+speed;
		World.Y=World.Y-speed;
	}

	// ------------------------------------get/set------------------------------
	/**
	 * 设置角色x坐标
	 */
	public void setX(int x) {
		rolePoint.x = x;
	}

	/**
	 * 设置角色y坐标
	 */
	public void setY(int y) {
		rolePoint.y = y;
	}

	/**
	 * 得到角色x坐标
	 */
	public int getX() {
		return rolePoint.x;
	}

	/**
	 * 得到角色y坐标
	 */
	public int getY() {
		return rolePoint.y;
	}

	// 设置角色坐标
	public void setRolePoint(int x, int y) {
		rolePoint.setLocation(x, y);
	}

	/**
	 * 得到英雄名字
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置英雄名字
	 */
	public void setName(String name) {
		this.name = name;
	}

	// 得到当前角色图片
	public String getRoleImageUrl() {
		return roleImageUrl;
	}

	/**
	 * 得到角色坐标点
	 * @return
	 */

	/**
	 * 设置角色坐标点
	 * @param rolePoint
	 */
	public Hero setRolePoint(Point rolePoint) {
		this.rolePoint = rolePoint;
		return this;
	}

	// 设置当前角色图片
	public void setRoleImage(BufferedImage roleImage) {
		this.roleImage = roleImage;
	}

	// 得到y轴切割位置
	public int getSplitY() {
		return splitY;
	}

	// 设置y轴切割位置
	public void setSplitY(int splitY) {
		this.splitY = splitY;
	}

	// 获取当前角色图片
	public void setRoleImageUrl(String roleImageUrl) {
		this.roleImageUrl = roleImageUrl;
	}

	// 得到切割X轴位置
	public int getSplitX() {
		return splitX;
	}

	// 设置切割X轴位置
	public void setSplitX(int splitX) {
		this.splitX = splitX;
	}

	// 得到角色图片
	public Image getRoleImage() {
		return roleImage;
	}

	// 设置图片位于窗口坐标
	public void setCenterPoint(Point centerPoint) {
		this.centerPoint = centerPoint;
	}

	// 得到角色宽度
	public int getRoleWidth() {
		return roleWidth;
	}

	// 设置角色宽度
	public void setRoleWidth(int roleWidth) {
		this.roleWidth = roleWidth;
	}

	// 得到角色高度

	public int getRoleHeight() {
		// 得到角色宽度
		return roleHeight;
	}

	public void setRoleHeight(int roleHeight) {
		this.roleHeight = roleHeight;
	}

	// 得到角色移动速度 (自动除以基数100)
	public int getSpeed() {
		return speed;
	}

	// 设置角色移动速度

	public Point getRolePoint() {
		return rolePoint;
	}
	public Point getCenterPoint() {
		return centerPoint;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getActionState() {
		return actionState;
	}

	public int getMoveState() {
		return moveState;
	}

	public void setMoveState(int moveState) {
		this.moveState = moveState;
	}

	public void setActionState(int actionState) {
		this.actionState = actionState;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMaxLife() {
		return maxLife;
	}

	public void setMaxLife(String maxLife) {
		this.maxLife = maxLife;
	}

	public String getCurrentLife() {
		return currentLife;
	}

	public void setCurrentLife(String currentLife) {
		this.currentLife = currentLife;
	}
	public IoSession getSession() {
		return session;
	}

	public void setSession(IoSession session) {
		this.session = session;
	}
/**
 * 得到当前token
 */
	public String getToken() {
		return token;
	}
/**
 * 设置当前token
 */
	public void setToken(String token) {
		this.token = token;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	/**
	 * 得到命令行
	 */
	public int getCommand() {
		return command;
	}
	/**
	 * 设置命令行
	 */
	public void setCommand(int command) {
		this.command = command;
	}
   
	
}
