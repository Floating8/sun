package cn.zht;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
* @author zht
* @version ����ʱ�䣺2019��11��24�� ����3:56:28
*��Ϸ����ĸ���
*/
public class GameObject {
	 Image img;
	 double x,y;
	 int speed;
	 int width,height;
	
	public void drawself(Graphics g)
	{
		g.drawImage(img, (int)x, (int)y, null);
	}

	public GameObject(Image img, double x, double y, int speed, int width, int height) {
		super();
		this.img=img;
		this.x=x;
		this.y=y;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}

	public GameObject(Image img, double x, double y) {
		super();
		this.img=img;
		this.x=x;
		this.y=y;
	}

	public GameObject() {
		
	}
	
	public Rectangle getRectangle() {//�����������ڵľ��Σ����ں�������ײ���
		return new Rectangle((int)x,(int)y,width,height);
	}

	
}