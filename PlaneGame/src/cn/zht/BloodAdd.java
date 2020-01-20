package cn.zht;
/**
* @author zht
* @version 创建时间：2020年1月15日 上午10:54:39
*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class BloodAdd extends GameObject{
	double x=(int)(Math.random()*470);
	double y=(int)(Math.random()*650);
	public BloodAdd(Image bloodImg, int i, int j) {
		// TODO 自动生成的构造函数存根
	}
	public void drawSelf(Graphics g) {
		g.drawImage(img, (int)x, (int)y, null);
	}
	public BloodAdd(Image img,double x,double y) {
		this.img = img;
		this.x=x;
		this.y=y;
}
}
