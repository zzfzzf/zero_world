package com.zzy.zero.map;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.zzy.zero.util.EasyImage;

/**    
* ��ͼ��
* @author ������   
* @date 2015��8��26�� ����4:16:31 
* @version V1.0   
*/
public class World {
	// ��ͼ��ʼ����
	public static int X= 0;
	public static int Y = 0;
	// ��ͼ����
	private int width;
	private int height;
	BufferedImage bgimage;

	// �����ͼ����
	BufferedImage[][] brr;
	// ͼƬ����
	EasyImage easyImage;

	public World() {
		try {
			bgimage = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/bg.png"));
			easyImage = new EasyImage(bgimage);
			// ��ʼ����ͼ��ȳ���
			width = bgimage.getWidth();
			height = bgimage.getHeight();
			// ���ù��߽�ͼƬת��Ϊ����
			brr = easyImage.imageToArray(bgimage);

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("���ǵ�ͼ");
	}

	int countX = 0;
	int countY = 0;

	public void produceWorld(Graphics2D g) {
		Image tempImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < brr.length; i++) {
			for (int j = 0; j < brr[0].length; j++) {
				tempImage.getGraphics().drawImage(brr[i][j], i * 50, j * 50, null);
			}
		}

		g.drawImage(tempImage, X, Y, null);
	}

	// ----------------------------------------------set/get-------------------------------------


	/**
	 * �õ����
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * ���ÿ��
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * �õ��߶�
	 * @return
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * ���ø߶�
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}


}
