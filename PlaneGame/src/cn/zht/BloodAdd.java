package cn.zht;
/**
* @author zht
* @version ����ʱ�䣺2020��1��15�� ����10:54:39
*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class BloodAdd extends GameObject{
	double x=(int)(Math.random()*470);
	double y=(int)(Math.random()*650);
	public BloodAdd(Image bloodImg, int i, int j) {
		// TODO �Զ����ɵĹ��캯�����
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
