package com.zzy.zero.util;

import java.awt.image.BufferedImage;

/**    
* ͼƬ���� 
* @author ������   
* @date 2015��9��6�� ����4:10:01 
* @version V1.0   
*/
public class EasyImage {
	// ͼƬ�и���
	private int splitSizeX = 50;
	private int splitSizeY = 50;
	// ͼƬ�и�����
	private int splitNumX;
	private int splitNumY;
	BufferedImage bi;

	/**
	 * ��ͼƬת��Ϊ����(��ֱ�и�) ����ͼƬΪ�и����������
	 * @param bi ������ͼƬ
	 * @return һ��ͼƬ��ά����
	 */
	public EasyImage(BufferedImage bi) {
		this.bi = bi;
		// Ĭ�ϳߴ��С
		splitNumX = bi.getWidth() / this.splitSizeX;
		splitNumY = bi.getHeight() / this.splitSizeY;
	}

	/**
	 * �ָ�ͼƬ �����ô˷�����ʹ��Ĭ���и��С
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
			// �ߴ��СΪͼƬ��߳��Թ��
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
	 * �õ������и�ͼƬ����
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
	 * �õ������и�ͼƬ����
	 */
	public int getSplitNumY() {
		return splitNumY;
	}

}
