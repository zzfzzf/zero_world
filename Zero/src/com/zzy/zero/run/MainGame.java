package com.zzy.zero.run;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.commons.collections.map.HashedMap;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import net.sf.json.JSONObject;

import com.zzy.zero.map.World;
import com.zzy.zero.map.MainInterFace;
import com.zzy.zero.role.Hero;
import com.zzy.zero.role.HeroInterFace;
import com.zzy.zero.thread.RoleThread;
import com.zzy.zero.util.EasyCharset;

/**
 * ������ �����õ�ͼ�ƶ���ʽ�Դ˼������
 * 
 * @author ������
 * @date 2015��8��25�� ����2:04:52
 * @version V1.0
 */
public class MainGame extends JFrame implements MouseListener, Runnable, IoHandler, MainInterFace {
	// �����ƶ�flag
	boolean allowMove = false;
	ZeroClient z;
	// ת��
	private EasyCharset ec = new EasyCharset();
	// ������ȡͼƬ �޷���ʾ��̬
	// Image backImage =
	// ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("tupian.gif"));
	private static final long serialVersionUID = 1L;// ���֤ �޸ĺ����л�Ҫ��
	// �ƶ�ǰ��¼ԭ��
	private Point originPoint = new Point();
	// �ƶ�ǰ��¼Ŀ���
	private Point movePoint = new Point();
	// ��һ�㻭��
	JPanel bottomPanel = new JPanel();
	// ˫���屳��ͼ
	private Image doubleBuffer = null;
	// ˫���廭��
	private Graphics bufferGraphics = null;
	// ��ɫ����
	private Hero hero;
	// ��������
	private World world;
	// �ƶ��ľ���
	private int moveX;
	private int moveY;

	// -pp;
	IoConnector connector;
	IoSession session;

	public MainGame(IoConnector connector, ZeroClient z) {
		this.z = z;
		// Ϊ����ͨ����ʼ��
		this.connector = connector;
		// �½�һ���̲߳�����
		new Thread(this).start();
		// ʵ����Ӣ��
		hero = new Hero("");
		// ʵ������ͼ
		world = new World();
		// ��ʼ����ͼλ��
		// this.getCurrentPoint();

	}

	/**
	 * ʵ�ֳ�ʼ�� void ��������
	 * 
	 * @throws null
	 */
	private void init() {
		// ��ӵײ����
		this.add(bottomPanel);
		// ���ô��ڲ���Ϊ�գ��Զ��岼�֣�
		this.setLayout(null);
		// ���ô��ڴ�С
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		// ���ô���Ĭ���޷��ر�
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// ���ô��ڱ���
		this.setTitle("���Ǵ���");
		// ����ΪnullĬ�Ͼ���
		this.setLocationRelativeTo(null);
		// �����Ƿ�ɸı����С Ĭ��Ϊtrue
		this.setResizable(false);
		// Ϊ������Ӽ����¼�
		this.addMouseListener(this);
		// ���ô��ڹر��¼�����
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int a = JOptionPane.showConfirmDialog(null, "��ȷ��Ҫ�ر���ô(�Уߩ�)", "�ҽ���ʾ��", JOptionPane.YES_NO_OPTION);
				// ȷ��Ϊ0
				if (a == 0) {
/*					JSONObject jo=new JSONObject();
					jo.put("command",COMMAND_EXIT);
					jo.put("name", hero.getName());
					session.write(jo.toString());
					session.close();
					connector.dispose();*/
					System.exit(0);
				}
			}
		});
		// ������ʾ����
		this.setVisible(true);

	}

	// �����������껭��ͼ�㷨
	/*
	 * public void getCurrentPoint() { world.setX(hero.getCenterPoint().x -
	 * hero.getRolePoint().x); world.setY(hero.getCenterPoint().y -
	 * hero.getRolePoint().y); }
	 */

	/**
	 * �ٶȺ;����㷨
	 * @param e ����¼�
	 */
	public void speedAlgorithm(MouseEvent e) {
		moveX = hero.getCenterPoint().x - e.getX() + hero.getRoleWidth() / 2;
		moveY = hero.getCenterPoint().y - e.getY() + hero.getRoleHeight() / 2;
	}

	public int getAction() {
		// ���Ͻ�
		if (moveX > 0 && moveY > 0) {
			// ���x����y ���� ��������
			if (Math.abs(moveX) > Math.abs(moveY)) {
				// ��ɫx��������
				return Hero.MOVE_LEFT;
			} else {
				return Hero.MOVE_UP;
			}
		}
		// ���Ͻ�
		else if (moveX < 0 && moveY > 0) {
			// �������x����y ���� ��������
			if (Math.abs(moveX) > Math.abs(moveY)) {
				return Hero.MOVE_RIGHT;
			} else {
				return Hero.MOVE_UP;
			}
		}
		// ���½�
		else if (moveX > 0 && moveY < 0) {
			// �������x����y ���� ��������
			if (Math.abs(moveX) > Math.abs(moveY)) {
				return Hero.MOVE_LEFT;
			} else {
				return Hero.MOVE_DOWN;
			}

		}
		// ���½�
		else if (moveX < 0 && moveY < 0) {
			// �������x����y ���� ��������
			if (Math.abs(moveX) > Math.abs(moveY)) {
				return Hero.MOVE_RIGHT;
			} else {
				return Hero.MOVE_DOWN;
			}
		}
		return 10086;
	}

	/**
	 * �����ƶ����л���̬
	 * @throws IOException 
	 */
	public void roleMove() throws IOException {
		// �Ƿ������ƶ�
		if (allowMove == true) {
			switch (getAction()) {
			case Hero.MOVE_DOWN:
				hero.goDown();
				break;
			case Hero.MOVE_LEFT:
				hero.goLeft();
				break;
			case Hero.MOVE_RIGHT:
				hero.goRight();
				break;
			case Hero.MOVE_UP:
				hero.goUp();
				break;
			}
			// �����ƶ���Ϣ
			hero.Timer++;
			// ע�� �����60Ӧ����֡��
			switch (hero.Timer / 8) {
			case 3:
				hero.Timer = 0;
				break;
			case 2:
				hero.setMoveState(Hero.STEP_RIGHT);
				break;
			case 1:
				hero.setMoveState(Hero.STEP_LEFT);
				break;
			case 0:
				hero.setMoveState(Hero.MOVE_STAND);
				break;
			}
			// json����
			JSONObject jsonobj = new JSONObject();
			// ������
			jsonobj.put("command", COMMAND_MOVE);
			// x����y����
			jsonobj.put("x", hero.getX());
			jsonobj.put("y", hero.getY());
			// �ƶ�״̬
			jsonobj.put("moveState", hero.getMoveState());
			// token
			jsonobj.put("token", hero.getToken());
			// ��ɫ�˶�����
			jsonobj.put("actionState", hero.getActionState());
			session.write(jsonobj.toString());
		}
	}

	@Override
	// ������¼�
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	// ��갴���¼�
	public void mousePressed(MouseEvent e) {
		// �����ƶ�����
		allowMove = true;
		// �����ٶ��㷨
		this.speedAlgorithm(e);
	}

	@Override
	// ����ɿ��¼�
	public void mouseReleased(MouseEvent e) {
		allowMove = false;
	}

	@Override
	// �������¼�
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	// ����Ƴ��¼�
	public void mouseExited(MouseEvent e) {

	}

	public void rolePaint(Graphics g) {
		// �жϲ�ʵ��������ͼƬ
		if (doubleBuffer == null) {
			doubleBuffer = createImage(this.getSize().width, this.getSize().height);
		}
		// �õ�����ͼƬ����
		bufferGraphics = doubleBuffer.getGraphics();
		// ����paint�Զ����� swing
		/*
		 * bufferGraphics.setColor(Color.gray); bufferGraphics.fillRect(0, 0,
		 * this.getWidth(), this.getHeight());
		 */
		// ���ø�����������
		super.paint(bufferGraphics);
		// ע�⻭��˳�� ˳�򽫻�Ӱ��ͼƬͼ��
		// ��������
		world.produceWorld((Graphics2D) bufferGraphics);
		hero.produceHero((Graphics2D) bufferGraphics);
		// ����Ӣ�� ���ͬ���ᵼ��remove��ɫ����
		for (Map.Entry<String,Hero> me : heroMap.entrySet()) {
			me.getValue().produceOther((Graphics2D) bufferGraphics);
		}
		g.drawImage(doubleBuffer, 0, 0, null);
	}

	@Override
	public void paint(Graphics g) {
		try {
			// ��ɫ�˶��߼�
			this.roleMove();
			// ��ɫ��ͼ�߼�
			this.rolePaint(g);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			long beforeTime = System.currentTimeMillis();
			repaint();
			long afterTime = System.currentTimeMillis();
			long difference = afterTime - beforeTime;
			long sleepTime = 1000 / FPS;
			try {
				if (difference > sleepTime) {
					sleepTime = 0;
				} else {
					sleepTime = sleepTime - difference;
				}
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	// -----------------------------get/set-------------------------------------

	// ��ȡԭ��
	public Point getOriginPoint() {
		return originPoint;
	}

	// ����ԭ��
	public void setOriginPoint(Point originPoint) {
		this.originPoint = originPoint;
	}

	// �õ������λ��
	public Point getMovePoint() {
		return movePoint;
	}

	// ���������λ��
	public void setMovePoint(Point movePoint) {
		this.movePoint = movePoint;
	}

	// �õ��ײ�JPanel
	public JPanel getBottomPanel() {
		return bottomPanel;
	}

	// ���õײ�JPanel
	public void setBottomPanel(JPanel bottomPanel) {
		this.bottomPanel = bottomPanel;
	}

	// �õ�˫����ͼƬ
	public Image getDoubleBuffer() {
		return doubleBuffer;
	}

	// ����˫����ͼƬ
	public void setDoubleBuffer(Image doubleBuffer) {
		this.doubleBuffer = doubleBuffer;
	}

	// �õ�˫���廭��
	public Graphics getBufferGraphics() {
		return bufferGraphics;
	}

	// ����˫���廭��
	public void setBufferGraphics(Graphics bufferGraphics) {
		this.bufferGraphics = bufferGraphics;
	}

	// �õ�Ӣ����
	public Hero getHero() {
		return hero;
	}

	// ����Ӣ����
	public void setHero(Hero hero) {
		this.hero = hero;
	}

	// �õ���ͼ��
	public World getWorld() {
		return world;
	}

	// ���õ�ͼ��
	public void setWorld(World world) {
		this.world = world;
	}

	// �õ�Ҫ�ƶ�����
	public int getMoveX() {
		return moveX;
	}

	public void setMoveX(int moveX) {
		this.moveX = moveX;
	}

	public int getMoveY() {
		return moveY;
	}

	public void setMoveY(int moveY) {
		this.moveY = moveY;
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		// ����session ��û������

	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		this.session = session;
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		int a = JOptionPane.showConfirmDialog(null, "�����˶Ͽ����ӣ��Ƿ�����", "�ҽ���ʾ��", JOptionPane.YES_NO_OPTION);
		if (a == 0) {
			while (true) {
				ConnectFuture future = connector.connect();
				future.awaitUninterruptibly();
				if (future.isConnected()) {
					z.session = future.getSession();
					return;
				} else {
					JOptionPane.showConfirmDialog(null, "�����˶Ͽ����ӣ��Ƿ�����", "�ҽ���ʾ��", JOptionPane.YES_NO_OPTION);
					Thread.sleep(3000);
				}
			}
		} else {
			System.exit(0);
		}

	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		Exception e = (Exception) cause;
		e.printStackTrace();
	}

	/**
	 * ����token�ķ���
	 */
	private void tokenLogic(JSONObject jo) {
		hero.setToken(jo.getString("token"));
	}
    /**
     * ����login�ķ���
     */
	private void loginLogic(JSONObject jo) {
		if ("ok".equals(jo.getString("state"))) {
			init();
			z.setVisible(false);
			// ��֤�ɹ�֮��ŷ��ظ��ֶ�
			System.out.println("�ɹ���¼,���token��" + hero.getToken());
		}
	}
	  /**
     * ����look�ķ���
     */
	private void lookLogic(JSONObject jo){
		// �����ɫ�뿪���ڵ�ǰλ��
		Hero h = new Hero(jo.getString("name"));
		// ���ݵ�ǰ��ͼ����������ɫλ��
		h.setX(jo.getInt("x") + World.X);
		h.setY(jo.getInt("y") + World.Y);
		h.setActionState(jo.getInt("actionState"));
		h.setMoveState(jo.getInt("moveState"));
		heroMap.put(jo.getString("token"), h);
	}
	/**
	 * ����remove����
	 */
	private void removeLogic(JSONObject jo){
		heroMap.remove(jo.get("token"));
		System.out.println("�Ѿ��Ƴ��û�" + jo.get("token") + "-��ǰʣ���û�:" + heroMap.size());
	}
	/**
	 * ����exit���� 
	 */
	private void exitLogic(JSONObject jo){
		onlineMap.remove(jo.get("token"));
	}
	/**
	 * ����add����
	 */
	private void addLogic(JSONObject jo){
		// Ŀǰֻ�����Щ
		Hero h=new Hero();
		h.setName(jo.getString("name"));
		h.setToken(jo.getString("token"));
		onlineMap.put(jo.getString("token"), h);
		System.out.println("online="+onlineMap.size());
	}
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		String rmsg = (String) message;
		if (rmsg != null && rmsg.length() > 0) {
			JSONObject jo = JSONObject.fromObject(rmsg);
			int command = jo.getInt("command");
			switch (command) {
			case COMMAND_ADD:
				this.addLogic(jo);
				break;
			case COMMAND_TOKEN:
				this.tokenLogic(jo);
				break;
			case COMMAND_LOGIN:
				this.loginLogic(jo);
				break;
			case COMMAND_LOOK:
				this.lookLogic(jo);
				break;
			case COMMAND_REMOVE:
				this.removeLogic(jo);
				break;
			case COMMAND_EXIT:
				this.exitLogic(jo);
			}

		}
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {

	}

}
