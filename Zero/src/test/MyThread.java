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
* 用一句话描述该文件做什么
* @author 赵召阳   
* @date 2015年8月27日 上午9:39:02 
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
		// 设置窗口标题
		this.setTitle("我是窗口");
		// 设置关闭窗口结束进程
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 设置为null默认居中
		this.setLocationRelativeTo(null);
		// 设置是否可改变其大小 默认为true
		this.setResizable(false);
		// 设置显示窗体
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
