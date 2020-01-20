package cn.zht;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
* @author zht
* @version 创建时间：2019年11月24日 下午3:56:28
*游戏物体的父类
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
	
	public Rectangle getRectangle() {//返回物体所在的矩形，便于后续的碰撞检测
		return new Rectangle((int)x,(int)y,width,height);
	}

	
}
