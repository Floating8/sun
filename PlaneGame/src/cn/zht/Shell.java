package cn.zht;

import java.awt.Color;
import java.awt.Graphics;

/**
* @author zht
* @version 创建时间：2019年11月24日 下午5:11:40
* 炮弹类
*/
public class Shell extends GameObject{
	double degree;
	boolean hp=true;
	public Shell() {
		x=200;
		y=200;
		width=10;
		height=10;
		speed=3;
		degree=Math.random()*Math.PI*2;
	}
	
	public	void draw(Graphics g) {
		if(hp) {
		Color c = g.getColor();
		g.setColor(Color.green);
		g.fillOval((int)x, (int)y, width, height);
		
		x+=speed*Math.cos(degree);//炮弹沿着任意角度去飞
		y+=speed*Math.sin(degree);
		if(x<0||x>Constant.GAME_WIDTH-width) {
			degree = Math.PI-degree;
		}
		if(y<30||y>Constant.GAME_HEIGHT-height) {
			degree = -degree;
		}
	g.setColor(c);
	}
		else {
			g.setColor(Color.WHITE);
			g.fillOval((int)x, (int)y, width, height);
		}                                  
	}
	
}
