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
 * ��ɫ��
 * 
 * @author ������
 * @date 2015��8��26�� ����4:14:34
 * @version V1.0
 */
public class Hero implements HeroInterFace {
	// command
	private int command=0;
    // token
	private String token="";
	// ��Ϸ�ǳ�
	public String name;
	// �ʺ�
	String userName = "meiyou";
	// �������ֵ
	String maxLife;
	// ��ǰ����ֵ
	String currentLife;
	// ��ɫ״̬ �ж���������
	String state;
	// ��ɫsession
	transient IoSession  session;
	// ��ɫ������ʱ��
	public int Timer = 0;
	// ��ɫ��ǰ״̬
	private int actionState = 0;
	// ��ɫ�ƶ�״̬ Ĭ��3�� (����ţ����ҽ�)
	private int moveState = 0;
	// ��ɫͼƬ·��
	private String roleImageUrl = "roleup.png";
	// ��ɫͼƬ
	private BufferedImage roleImage = null;
	// �и�ͼƬ����
	private int splitX = 62;
	private int splitY = 0;
	// ��¼��ɫ����
	@JsonIgnore
	private transient Point rolePoint = new Point(321, 242);
	// ��ɫλ����Ļ����
	@JsonIgnore
	private transient Point centerPoint = new Point(321, 242);
	// ��ɫͼƬ��С
	private int roleWidth = 62;
	private int roleHeight = 70;
	// ��ɫ�����ٶ�
	private int speed = 2;

	// =========================================================================
	public Hero(String name) {
		this.name = name;
	}

	public Hero() {

	}

	/**
	 * ���ɽ�ɫ void ��������
	 * @throws null
	 */
	public void produceHero(Graphics2D g) {
		try {
			// ����ͼƬ
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
	 * ����������ɫ��
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
			// ����ͼƬ
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

	// ������
	public void goUp() {
		roleImageUrl = "roleup.png";
		this.actionState=MOVE_UP;
		// ��ʱʱ�ӷ����������� ֻ�ڽ�ɫ�ƶ���ʱ��㲥
		for (Map.Entry<String, Hero> me : MainGame.heroMap.entrySet()) {
			Hero tempH = me.getValue();
			tempH.setY(tempH.getY() + speed);
		}
		rolePoint.y=rolePoint.y-speed;
		World.Y=World.Y+speed;
	}

	// ������
	public void goLeft() {
		// �˶�ʱ��ɫͼƬ
		roleImageUrl = "roleleft.png";
		// �����˶�����
		actionState = MOVE_LEFT;
		// ��ʱʱ�ӷ����������� ֻ�ڽ�ɫ�ƶ���ʱ��㲥
		for (Map.Entry<String, Hero> me : MainGame.heroMap.entrySet()) {
			Hero tempH = me.getValue();
			tempH.setX(tempH.getX() + speed);
		}
		rolePoint.x = rolePoint.x - speed;
		// ��ͼ���ŷ������ƶ�
		World.X = World.X + speed;
	}

	// ������
	public void goRight() {
		roleImageUrl = "roleright.png";
		actionState=MOVE_RIGHT;
		// ��ʱʱ�ӷ����������� ֻ�ڽ�ɫ�ƶ���ʱ��㲥
		for (Map.Entry<String, Hero> me : MainGame.heroMap.entrySet()) {
			Hero tempH = me.getValue();
			tempH.setX(tempH.getX() - speed);
		}
		rolePoint.x=rolePoint.x+speed;
		World.X=World.X-speed;
	}

	// ������
	public void goDown() {
		roleImageUrl = "roledown.png";
		actionState=MOVE_DOWN;
		// ��ʱʱ�ӷ����������� ֻ�ڽ�ɫ�ƶ���ʱ��㲥
		for (Map.Entry<String, Hero> me : MainGame.heroMap.entrySet()) {
			Hero tempH = me.getValue();
			tempH.setY(tempH.getY() - speed);
		}
		rolePoint.y=rolePoint.y+speed;
		World.Y=World.Y-speed;
	}

	// ------------------------------------get/set------------------------------
	/**
	 * ���ý�ɫx����
	 */
	public void setX(int x) {
		rolePoint.x = x;
	}

	/**
	 * ���ý�ɫy����
	 */
	public void setY(int y) {
		rolePoint.y = y;
	}

	/**
	 * �õ���ɫx����
	 */
	public int getX() {
		return rolePoint.x;
	}

	/**
	 * �õ���ɫy����
	 */
	public int getY() {
		return rolePoint.y;
	}

	// ���ý�ɫ����
	public void setRolePoint(int x, int y) {
		rolePoint.setLocation(x, y);
	}

	/**
	 * �õ�Ӣ������
	 */
	public String getName() {
		return name;
	}

	/**
	 * ����Ӣ������
	 */
	public void setName(String name) {
		this.name = name;
	}

	// �õ���ǰ��ɫͼƬ
	public String getRoleImageUrl() {
		return roleImageUrl;
	}

	/**
	 * �õ���ɫ�����
	 * @return
	 */

	/**
	 * ���ý�ɫ�����
	 * @param rolePoint
	 */
	public Hero setRolePoint(Point rolePoint) {
		this.rolePoint = rolePoint;
		return this;
	}

	// ���õ�ǰ��ɫͼƬ
	public void setRoleImage(BufferedImage roleImage) {
		this.roleImage = roleImage;
	}

	// �õ�y���и�λ��
	public int getSplitY() {
		return splitY;
	}

	// ����y���и�λ��
	public void setSplitY(int splitY) {
		this.splitY = splitY;
	}

	// ��ȡ��ǰ��ɫͼƬ
	public void setRoleImageUrl(String roleImageUrl) {
		this.roleImageUrl = roleImageUrl;
	}

	// �õ��и�X��λ��
	public int getSplitX() {
		return splitX;
	}

	// �����и�X��λ��
	public void setSplitX(int splitX) {
		this.splitX = splitX;
	}

	// �õ���ɫͼƬ
	public Image getRoleImage() {
		return roleImage;
	}

	// ����ͼƬλ�ڴ�������
	public void setCenterPoint(Point centerPoint) {
		this.centerPoint = centerPoint;
	}

	// �õ���ɫ���
	public int getRoleWidth() {
		return roleWidth;
	}

	// ���ý�ɫ���
	public void setRoleWidth(int roleWidth) {
		this.roleWidth = roleWidth;
	}

	// �õ���ɫ�߶�

	public int getRoleHeight() {
		// �õ���ɫ���
		return roleHeight;
	}

	public void setRoleHeight(int roleHeight) {
		this.roleHeight = roleHeight;
	}

	// �õ���ɫ�ƶ��ٶ� (�Զ����Ի���100)
	public int getSpeed() {
		return speed;
	}

	// ���ý�ɫ�ƶ��ٶ�

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
 * �õ���ǰtoken
 */
	public String getToken() {
		return token;
	}
/**
 * ���õ�ǰtoken
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
	 * �õ�������
	 */
	public int getCommand() {
		return command;
	}
	/**
	 * ����������
	 */
	public void setCommand(int command) {
		this.command = command;
	}
   
	
}
