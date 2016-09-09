package com.zzy.zero.run;

import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.sf.json.JSONObject;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import com.zzy.zero.exception.CustomException;
import com.zzy.zero.thread.ClientHandle;
import com.zzy.zero.util.EasyCharset;

/**    
* 主程序 主采用地图移动方式以此减少
* @author 赵召阳   
* @date 2015年8月25日 下午2:04:52 
* @version V1.0   
*/
public class ZeroClient extends JFrame {
	IoConnector connector;
	// 声明连接地址 和 连接端口
	private static String URL = "127.0.0.1";
	private static int PORT = 1024;
	// 创建连接对象
	IoSession session;
	// 声明登录按钮
	JButton login = new JButton("登录");
	// 声明注册按钮
	JButton register = new JButton("注册");
	// 声明帐号标签
	JLabel userLabel = new JLabel("帐号");
	// 声明密码标签
	JLabel passLabel = new JLabel("密码");
	// 声明帐号输入框
	JTextField userText = new JTextField();
	// 声明密码输入框
	JTextField passText = new JTextField();
	// 萌萌哒识别码
	private static final long serialVersionUID = 1L;
	// 导入字符工具包
	private EasyCharset ec = new EasyCharset();

	public static void main(String[] args) throws Exception {
		try {
			new ZeroClient();
			new MainGame(null, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ZeroClient() throws UnknownHostException, CustomException, InterruptedException {
		// 创建一个nio连接
		connector = new NioSocketConnector();
		// 创建接收数据的过滤器
		DefaultIoFilterChainBuilder chain = connector.getFilterChain();
		// 设置客户端一行行读取数据
		chain.addLast("stringFilter", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("utf-8"))));
		// 设置操作类
		// 设置连接超时
		connector.setConnectTimeoutMillis(300);
		connector.setHandler(new MainGame(connector, this));
		connector.setDefaultRemoteAddress(new InetSocketAddress(URL, PORT));
		// 连接到服务器:
		ConnectFuture cf = connector.connect(new InetSocketAddress(URL, PORT));
		// 连接成功后执行下一步
		cf.awaitUninterruptibly();
		init();

		try {
			session = cf.getSession();
		} catch (Exception e) {
			while (true) {
				ConnectFuture future = connector.connect();
				future.awaitUninterruptibly();
				System.out.println(future.isConnected());
				if (future.isConnected()) {
					session = future.getSession();
					JOptionPane.showMessageDialog(null, "连接成功");
					return;
				} else {
					int a=JOptionPane.showConfirmDialog(null, "与服务端断开连接，是否重连", "我叫提示框", JOptionPane.YES_NO_OPTION);
					if(a==1){
						System.exit(0);
					}
					Thread.sleep(3000);
				}
			}
		}

	}

	public MouseAdapter ma = new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getSource().getClass().getSimpleName().equals("JTextField")) {
				JTextField text = (JTextField) e.getSource();
				if (text.equals(userText)) {
					userText.setText("");
				}
				if (text.equals(passText)) {
					passText.setText("");
				}
			}
			if (e.getSource().getClass().getSimpleName().equals("JButton")) {
				JButton b = (JButton) e.getSource();
				if (b.equals(login)) {
					// 获取帐号
					String user = userText.getText();
					// 获取密码
					String userPass = passText.getText();
					// 验证帐号密码是否合格
					if (user == null || user.length() < 6) {
						userText.setText("用户名不能小于6位数");
					} else if (userPass == null || userPass.length() < 6) {
						passText.setText("密码不能小于6位数");
					} else {
						JSONObject jo = new JSONObject();
						jo.put("command", MainGame.COMMAND_LOGIN);
						jo.put("token", "");
						jo.put("userName", userText.getText());
						jo.put("passWord", passText.getText());
						session.write(jo);
					}

				} else if (b.equals(register)) {
					//
					Desktop desktop = Desktop.getDesktop();
					try {
						// 默认浏览器打开
						desktop.browse(new URI("www.baidu.com"));
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	};

	public void init() {
		// 默认布局为空 (方便自定义布局)
		this.setLayout(null);
		// 添加标签到面板
		this.add(userLabel);
		userLabel.setBounds(40, 10, 30, 30);
		this.add(passLabel);
		passLabel.setBounds(40, 40, 30, 30);
		// 添加输入框到面板
		this.add(userText);
		userText.setBounds(80, 10, 130, 30);
		// 给帐号输入框添加监听
		userText.addMouseListener(ma);
		this.add(passText);
		passText.setBounds(80, 40, 130, 30);
		// 给密码输入框添加监听
		passText.addMouseListener(ma);
		// 设置窗口默认无法关闭
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// 添加按钮到面板
		this.add(login);
		login.setBounds(40, 80, 75, 30);

		this.add(register);
		register.setBounds(135, 80, 75, 30);
		// 设置窗口大小
		this.setSize(300, 150);
		// 设置窗口标题
		this.setTitle("我是窗口");
		// 设置窗口默认无法关闭
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// 设置为null默认居中
		this.setLocationRelativeTo(null);
		// 设置是否可改变其大小 默认为true
		this.setResizable(false);
		// 为按钮添加监听事件
		login.addMouseListener(ma);
		register.addMouseListener(ma);
		// 窗口关闭时发送关闭流信息到服务器
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int a = JOptionPane.showConfirmDialog(null, "你确定要关闭我么(┬＿┬)", "我叫提示框", JOptionPane.YES_NO_OPTION);
				// 确认为0
				if (a == 0) {
					session.close();
					connector.dispose();
					// 注意命令行格式
					System.exit(0);
				}
			}
		});
		// 设置显示窗体
		this.setVisible(true);

	}

}
