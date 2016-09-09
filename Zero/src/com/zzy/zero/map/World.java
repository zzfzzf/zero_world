package com.zzy.zero.map;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.zzy.zero.util.EasyImage;

/**    
* 地图类
* @author 赵召阳   
* @date 2015年8月26日 下午4:16:31 
* @version V1.0   
*/
public class World {
	// 地图初始坐标
	public static int X= 0;
	public static int Y = 0;
	// 地图长宽
	private int width;
	private int height;
	BufferedImage bgimage;

	// 定义地图数组
	BufferedImage[][] brr;
	// 图片工具
	EasyImage easyImage;

	public World() {
		try {
			bgimage = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/bg.png"));
			easyImage = new EasyImage(bgimage);
			// 初始化地图宽度长度
			width = bgimage.getWidth();
			height = bgimage.getHeight();
			// 调用工具将图片转换为数组
			brr = easyImage.imageToArray(bgimage);

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("我是地图");
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
	 * 得到宽度
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * 设置宽度
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * 得到高度
	 * @return
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * 设置高度
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}


}
