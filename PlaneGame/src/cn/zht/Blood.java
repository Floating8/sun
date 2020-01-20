package cn.zht;

import java.awt.Color;
import java.awt.Graphics;

/**
* @author zht
* @version ����ʱ�䣺2020��1��17�� ����9:02:18
*/
public class Blood extends GameObject {
	public Blood() {
		x=0;
		y=31;
		width=100;
		height=10;
	}
	public void draw(Graphics g) {
		Color c = g.getColor();  
		g.setColor(Color.red);
		g.fillRect((int)x,(int)y, width, height);
		g.setColor(c);
	}
}
