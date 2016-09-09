package test;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**    
* ��һ�仰�������ļ���ʲô
* @author ������   
* @date 2015��8��27�� ����9:39:02 
* @version V1.0   
*/
public class MyThread extends JFrame implements Runnable {
	BufferedImage image;
	BufferedImage[][] arr=new BufferedImage[10][6];
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws IOException {
		
//		new MyThread();
	}

	public boolean b;

	public MyThread() throws IOException {
		image = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/test.png"));
		System.out.println(arr[0].length);
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<6;j++){
				arr[i][j]=image.getSubimage(i*50, j*50, 50, 50);
			}
		}
		this.setSize(500, 600);
		// ���ô��ڱ���
		this.setTitle("���Ǵ���");
		// ���ùرմ��ڽ�������
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ����ΪnullĬ�Ͼ���
		this.setLocationRelativeTo(null);
		// �����Ƿ�ɸı����С Ĭ��Ϊtrue
		this.setResizable(false);
		// ������ʾ����
		this.setVisible(true);
	}
    
	public void paint(Graphics g){
		for(int i=0;i<10;i++){
			for(int j=0;j<6;j++){
				g.drawImage(arr[i][j], i*50+3, j*50+25, null);
			}
		}
	}
	@Override
	public void run() {
	}
}
