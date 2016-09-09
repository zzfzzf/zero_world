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
 * 主程序 主采用地图移动方式以此减少误差
 * 
 * @author 赵召阳
 * @date 2015年8月25日 下午2:04:52
 * @version V1.0
 */
public class MainGame extends JFrame implements MouseListener, Runnable, IoHandler, MainInterFace {
	// 允许移动flag
	boolean allowMove = false;
	ZeroClient z;
	// 转码
	private EasyCharset ec = new EasyCharset();
	// 用来读取图片 无法显示动态
	// Image backImage =
	// ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("tupian.gif"));
	private static final long serialVersionUID = 1L;// 身份证 修改后反序列化要用
	// 移动前记录原点
	private Point originPoint = new Point();
	// 移动前记录目标点
	private Point movePoint = new Point();
	// 第一层画布
	JPanel bottomPanel = new JPanel();
	// 双缓冲背景图
	private Image doubleBuffer = null;
	// 双缓冲画笔
	private Graphics bufferGraphics = null;
	// 角色声明
	private Hero hero;
	// 世界声明
	private World world;
	// 移动的距离
	private int moveX;
	private int moveY;

	// -pp;
	IoConnector connector;
	IoSession session;

	public MainGame(IoConnector connector, ZeroClient z) {
		this.z = z;
		// 为连接通道初始化
		this.connector = connector;
		// 新建一个线程并开启
		new Thread(this).start();
		// 实例化英雄
		hero = new Hero("");
		// 实例化地图
		world = new World();
		// 初始化地图位置
		// this.getCurrentPoint();

	}

	/**
	 * 实现初始化 void 返回类型
	 * 
	 * @throws null
	 */
	private void init() {
		// 添加底层面板
		this.add(bottomPanel);
		// 设置窗口布局为空（自定义布局）
		this.setLayout(null);
		// 设置窗口大小
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		// 设置窗口默认无法关闭
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// 设置窗口标题
		this.setTitle("我是窗口");
		// 设置为null默认居中
		this.setLocationRelativeTo(null);
		// 设置是否可改变其大小 默认为true
		this.setResizable(false);
		// 为窗体添加监听事件
		this.addMouseListener(this);
		// 设置窗口关闭事件监听
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int a = JOptionPane.showConfirmDialog(null, "你确定要关闭我么(┬＿┬)", "我叫提示框", JOptionPane.YES_NO_OPTION);
				// 确认为0
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
		// 设置显示窗体
		this.setVisible(true);

	}

	// 根据人物坐标画地图算法
	/*
	 * public void getCurrentPoint() { world.setX(hero.getCenterPoint().x -
	 * hero.getRolePoint().x); world.setY(hero.getCenterPoint().y -
	 * hero.getRolePoint().y); }
	 */

	/**
	 * 速度和距离算法
	 * @param e 鼠标事件
	 */
	public void speedAlgorithm(MouseEvent e) {
		moveX = hero.getCenterPoint().x - e.getX() + hero.getRoleWidth() / 2;
		moveY = hero.getCenterPoint().y - e.getY() + hero.getRoleHeight() / 2;
	}

	public int getAction() {
		// 左上角
		if (moveX > 0 && moveY > 0) {
			// 如果x大于y 往左 否则往上
			if (Math.abs(moveX) > Math.abs(moveY)) {
				// 角色x坐标左移
				return Hero.MOVE_LEFT;
			} else {
				return Hero.MOVE_UP;
			}
		}
		// 右上角
		else if (moveX < 0 && moveY > 0) {
			// 如果大于x大于y 往右 否则往上
			if (Math.abs(moveX) > Math.abs(moveY)) {
				return Hero.MOVE_RIGHT;
			} else {
				return Hero.MOVE_UP;
			}
		}
		// 左下角
		else if (moveX > 0 && moveY < 0) {
			// 如果大于x大于y 往左 否则往下
			if (Math.abs(moveX) > Math.abs(moveY)) {
				return Hero.MOVE_LEFT;
			} else {
				return Hero.MOVE_DOWN;
			}

		}
		// 右下角
		else if (moveX < 0 && moveY < 0) {
			// 如果大于x大于y 往右 否则往下
			if (Math.abs(moveX) > Math.abs(moveY)) {
				return Hero.MOVE_RIGHT;
			} else {
				return Hero.MOVE_DOWN;
			}
		}
		return 10086;
	}

	/**
	 * 人物移动及切换形态
	 * @throws IOException 
	 */
	public void roleMove() throws IOException {
		// 是否允许移动
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
			// 发送移动信息
			hero.Timer++;
			// 注意 这里的60应该是帧数
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
			// json对象
			JSONObject jsonobj = new JSONObject();
			// 命令行
			jsonobj.put("command", COMMAND_MOVE);
			// x坐标y坐标
			jsonobj.put("x", hero.getX());
			jsonobj.put("y", hero.getY());
			// 移动状态
			jsonobj.put("moveState", hero.getMoveState());
			// token
			jsonobj.put("token", hero.getToken());
			// 角色运动方向
			jsonobj.put("actionState", hero.getActionState());
			session.write(jsonobj.toString());
		}
	}

	@Override
	// 鼠标点击事件
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	// 鼠标按下事件
	public void mousePressed(MouseEvent e) {
		// 允许移动开启
		allowMove = true;
		// 调用速度算法
		this.speedAlgorithm(e);
	}

	@Override
	// 鼠标松开事件
	public void mouseReleased(MouseEvent e) {
		allowMove = false;
	}

	@Override
	// 鼠标进入事件
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	// 鼠标移出事件
	public void mouseExited(MouseEvent e) {

	}

	public void rolePaint(Graphics g) {
		// 判断并实例化缓冲图片
		if (doubleBuffer == null) {
			doubleBuffer = createImage(this.getSize().width, this.getSize().height);
		}
		// 得到缓冲图片画笔
		bufferGraphics = doubleBuffer.getGraphics();
		// 父类paint自动清理 swing
		/*
		 * bufferGraphics.setColor(Color.gray); bufferGraphics.fillRect(0, 0,
		 * this.getWidth(), this.getHeight());
		 */
		// 调用父类清屏操作
		super.paint(bufferGraphics);
		// 注意画出顺序 顺序将会影响图片图层
		// 生成世界
		world.produceWorld((Graphics2D) bufferGraphics);
		hero.produceHero((Graphics2D) bufferGraphics);
		// 生成英雄 如果同名会导致remove角色出错
		for (Map.Entry<String,Hero> me : heroMap.entrySet()) {
			me.getValue().produceOther((Graphics2D) bufferGraphics);
		}
		g.drawImage(doubleBuffer, 0, 0, null);
	}

	@Override
	public void paint(Graphics g) {
		try {
			// 角色运动逻辑
			this.roleMove();
			// 角色绘图逻辑
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

	// 获取原点
	public Point getOriginPoint() {
		return originPoint;
	}

	// 设置原点
	public void setOriginPoint(Point originPoint) {
		this.originPoint = originPoint;
	}

	// 得到鼠标点击位置
	public Point getMovePoint() {
		return movePoint;
	}

	// 设置鼠标点击位置
	public void setMovePoint(Point movePoint) {
		this.movePoint = movePoint;
	}

	// 拿到底层JPanel
	public JPanel getBottomPanel() {
		return bottomPanel;
	}

	// 设置底层JPanel
	public void setBottomPanel(JPanel bottomPanel) {
		this.bottomPanel = bottomPanel;
	}

	// 得到双缓冲图片
	public Image getDoubleBuffer() {
		return doubleBuffer;
	}

	// 设置双缓冲图片
	public void setDoubleBuffer(Image doubleBuffer) {
		this.doubleBuffer = doubleBuffer;
	}

	// 得到双缓冲画笔
	public Graphics getBufferGraphics() {
		return bufferGraphics;
	}

	// 设置双缓冲画笔
	public void setBufferGraphics(Graphics bufferGraphics) {
		this.bufferGraphics = bufferGraphics;
	}

	// 得到英雄类
	public Hero getHero() {
		return hero;
	}

	// 设置英雄类
	public void setHero(Hero hero) {
		this.hero = hero;
	}

	// 得到地图类
	public World getWorld() {
		return world;
	}

	// 设置地图类
	public void setWorld(World world) {
		this.world = world;
	}

	// 得到要移动距离
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
		// 创建session 但没有连接

	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		this.session = session;
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		int a = JOptionPane.showConfirmDialog(null, "与服务端断开连接，是否重连", "我叫提示框", JOptionPane.YES_NO_OPTION);
		if (a == 0) {
			while (true) {
				ConnectFuture future = connector.connect();
				future.awaitUninterruptibly();
				if (future.isConnected()) {
					z.session = future.getSession();
					return;
				} else {
					JOptionPane.showConfirmDialog(null, "与服务端断开连接，是否重连", "我叫提示框", JOptionPane.YES_NO_OPTION);
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
	 * 处理token的方法
	 */
	private void tokenLogic(JSONObject jo) {
		hero.setToken(jo.getString("token"));
	}
    /**
     * 处理login的方法
     */
	private void loginLogic(JSONObject jo) {
		if ("ok".equals(jo.getString("state"))) {
			init();
			z.setVisible(false);
			// 验证成功之后才返回该字段
			System.out.println("成功登录,你的token是" + hero.getToken());
		}
	}
	  /**
     * 处理look的方法
     */
	private void lookLogic(JSONObject jo){
		// 处理角色离开后还在当前位置
		Hero h = new Hero(jo.getString("name"));
		// 根据当前地图坐标来画角色位置
		h.setX(jo.getInt("x") + World.X);
		h.setY(jo.getInt("y") + World.Y);
		h.setActionState(jo.getInt("actionState"));
		h.setMoveState(jo.getInt("moveState"));
		heroMap.put(jo.getString("token"), h);
	}
	/**
	 * 处理remove方法
	 */
	private void removeLogic(JSONObject jo){
		heroMap.remove(jo.get("token"));
		System.out.println("已经移除用户" + jo.get("token") + "-当前剩余用户:" + heroMap.size());
	}
	/**
	 * 处理exit方法 
	 */
	private void exitLogic(JSONObject jo){
		onlineMap.remove(jo.get("token"));
	}
	/**
	 * 处理add方法
	 */
	private void addLogic(JSONObject jo){
		// 目前只添加这些
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
