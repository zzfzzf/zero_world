package com.zzy.zero.util;

import java.awt.image.BufferedImage;

/**    
* 图片工具 
* @author 赵召阳   
* @date 2015年9月6日 下午4:10:01 
* @version V1.0   
*/
public class EasyImage {
	// 图片切割规格
	private int splitSizeX = 50;
	private int splitSizeY = 50;
	// 图片切割数量
	private int splitNumX;
	private int splitNumY;
	BufferedImage bi;

	/**
	 * 将图片转换为数组(垂直切割) 建议图片为切割规格的整数倍
	 * @param bi 待处理图片
	 * @return 一个图片二维数组
	 */
	public EasyImage(BufferedImage bi) {
		this.bi = bi;
		// 默认尺寸大小
		splitNumX = bi.getWidth() / this.splitSizeX;
		splitNumY = bi.getHeight() / this.splitSizeY;
	}

	/**
	 * 分割图片 不调用此方法则使用默认切割大小
	 */
	public void split(int splitSizeX, int splitSizeY) {
		this.splitSizeX = splitSizeX;
		this.splitSizeY = splitSizeY;
		splitNumX = (bi.getWidth() % splitSizeX)>0?(bi.getWidth() / splitSizeX)+1:(bi.getWidth() / splitSizeX);
		splitNumY = (bi.getHeight() % splitSizeY)>0? (bi.getHeight() / splitSizeY)+1: (bi.getHeight() / splitSizeY);
	}

	public BufferedImage[][] imageToArray(BufferedImage bi) {
		BufferedImage[][] brr = null;
		if (bi != null) {
			// 尺寸大小为图片宽高除以规格
			brr = new BufferedImage[splitNumX][splitNumY];
			for (int i = 0; i < brr.length; i++) {
				for (int j = 0; j < brr[0].length; j++) {
					brr[i][j] = bi.getSubimage(i * splitSizeX, j * splitSizeX, splitSizeX, splitSizeY);
				}
			}
		}
		return brr;

	}

	// -------------------------------------------get/set-------------------------------------------------

	/**
	 * 得到横向切割图片数量
	 */
	public int getSplitNumX() {
		return splitNumX;
	}

	public int getSplitSizeX() {
		return splitSizeX;
	}

	public void setSplitSizeX(int splitSizeX) {
		this.splitSizeX = splitSizeX;
	}

	public int getSplitSizeY() {
		return splitSizeY;
	}

	public void setSplitSizeY(int splitSizeY) {
		this.splitSizeY = splitSizeY;
	}

	/**
	 * 得到纵向切割图片数量
	 */
	public int getSplitNumY() {
		return splitNumY;
	}

}
