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
* ������ �����õ�ͼ�ƶ���ʽ�Դ˼���
* @author ������   
* @date 2015��8��25�� ����2:04:52 
* @version V1.0   
*/
public class ZeroClient extends JFrame {
	IoConnector connector;
	// �������ӵ�ַ �� ���Ӷ˿�
	private static String URL = "127.0.0.1";
	private static int PORT = 1024;
	// �������Ӷ���
	IoSession session;
	// ������¼��ť
	JButton login = new JButton("��¼");
	// ����ע�ᰴť
	JButton register = new JButton("ע��");
	// �����ʺű�ǩ
	JLabel userLabel = new JLabel("�ʺ�");
	// ���������ǩ
	JLabel passLabel = new JLabel("����");
	// �����ʺ������
	JTextField userText = new JTextField();
	// �������������
	JTextField passText = new JTextField();
	// ������ʶ����
	private static final long serialVersionUID = 1L;
	// �����ַ����߰�
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
		// ����һ��nio����
		connector = new NioSocketConnector();
		// �����������ݵĹ�����
		DefaultIoFilterChainBuilder chain = connector.getFilterChain();
		// ���ÿͻ���һ���ж�ȡ����
		chain.addLast("stringFilter", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("utf-8"))));
		// ���ò�����
		// �������ӳ�ʱ
		connector.setConnectTimeoutMillis(300);
		connector.setHandler(new MainGame(connector, this));
		connector.setDefaultRemoteAddress(new InetSocketAddress(URL, PORT));
		// ���ӵ�������:
		ConnectFuture cf = connector.connect(new InetSocketAddress(URL, PORT));
		// ���ӳɹ���ִ����һ��
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
					JOptionPane.showMessageDialog(null, "���ӳɹ�");
					return;
				} else {
					int a=JOptionPane.showConfirmDialog(null, "�����˶Ͽ����ӣ��Ƿ�����", "�ҽ���ʾ��", JOptionPane.YES_NO_OPTION);
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
					// ��ȡ�ʺ�
					String user = userText.getText();
					// ��ȡ����
					String userPass = passText.getText();
					// ��֤�ʺ������Ƿ�ϸ�
					if (user == null || user.length() < 6) {
						userText.setText("�û�������С��6λ��");
					} else if (userPass == null || userPass.length() < 6) {
						passText.setText("���벻��С��6λ��");
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
						// Ĭ���������
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
		// Ĭ�ϲ���Ϊ�� (�����Զ��岼��)
		this.setLayout(null);
		// ��ӱ�ǩ�����
		this.add(userLabel);
		userLabel.setBounds(40, 10, 30, 30);
		this.add(passLabel);
		passLabel.setBounds(40, 40, 30, 30);
		// �����������
		this.add(userText);
		userText.setBounds(80, 10, 130, 30);
		// ���ʺ��������Ӽ���
		userText.addMouseListener(ma);
		this.add(passText);
		passText.setBounds(80, 40, 130, 30);
		// �������������Ӽ���
		passText.addMouseListener(ma);
		// ���ô���Ĭ���޷��ر�
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// ��Ӱ�ť�����
		this.add(login);
		login.setBounds(40, 80, 75, 30);

		this.add(register);
		register.setBounds(135, 80, 75, 30);
		// ���ô��ڴ�С
		this.setSize(300, 150);
		// ���ô��ڱ���
		this.setTitle("���Ǵ���");
		// ���ô���Ĭ���޷��ر�
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// ����ΪnullĬ�Ͼ���
		this.setLocationRelativeTo(null);
		// �����Ƿ�ɸı����С Ĭ��Ϊtrue
		this.setResizable(false);
		// Ϊ��ť��Ӽ����¼�
		login.addMouseListener(ma);
		register.addMouseListener(ma);
		// ���ڹر�ʱ���͹ر�����Ϣ��������
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int a = JOptionPane.showConfirmDialog(null, "��ȷ��Ҫ�ر���ô(�Уߩ�)", "�ҽ���ʾ��", JOptionPane.YES_NO_OPTION);
				// ȷ��Ϊ0
				if (a == 0) {
					session.close();
					connector.dispose();
					// ע�������и�ʽ
					System.exit(0);
				}
			}
		});
		// ������ʾ����
		this.setVisible(true);

	}

}
