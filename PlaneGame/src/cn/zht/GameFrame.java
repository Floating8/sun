package cn.zht;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

public class GameFrame extends Frame {
	Image bg=GameUtil.getImage("images/bg.png");
	Image planeImg=GameUtil.getImage("images/plane.png");
	Image bloodImg=GameUtil.getImage("images/blood.png");
	Plane plane = new Plane(planeImg,200,550);//设置飞机初始位置
	BloodAdd bloodadd = new BloodAdd(bloodImg,100,400);//设置血包
	Shell[] shell = new Shell[50]; 
	Blood blood = new Blood();//设置血量
	Explode bao;
	Date startTime=new Date();
	Date endTime;
	int period;//游戏持续时间
	public void lunch(){
		this.setTitle("zht作品");
		this.setVisible(true);
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		this.setLocation(200, 50);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		new PaintThread().start();//启动重画窗口线程
		addKeyListener(new KeyMonitor());//增加键盘的监听
		
		for(int i=0;i<shell.length;i++) {//初始化炮弹
			shell[i]=new Shell();
		}
		blood = new Blood();
	}
	
	public void paint(Graphics g) {//此方法自动被调用，g相当于一只画笔
		g.drawImage(bg, 0, 0, null);
		plane.drawSelf(g); //画飞机
		bloodadd.drawSelf(g);
		g.drawImage(bloodImg, 300, 300,null);//画血包
		for(int i=0;i<shell.length;i++) {
		shell[i].draw(g);//画炮弹
		blood.draw(g);//画血条
		blood.drawself(g);
		boolean boom = shell[i].getRectangle().intersects(plane.getRectangle());
		boolean relife = bloodadd.getRectangle().intersects(plane.getRectangle());
		if(relife) {
			blood.width=100;
		}
		if(boom) {//碰撞检测
			
			blood.width=blood.width-2;
			System.out.println(blood.width);
			this.shell[i].hp=false;
			
			
			if(bao==null) {
			bao = new Explode(plane.x,plane.y);
			
			period = (int)((endTime.getTime()-startTime.getTime())/1000);
			}
			if(blood.width==0) {
				plane.live=false;
				endTime	= new Date();
				bao.draw(g);
			}
			
	}
		if(!plane.live) {
		g.setColor(Color.red);
		g.drawString("游戏时间为："+period+"秒",(int)plane.x,(int)plane.y);
		}
		}
	}
	
	class PaintThread extends Thread{//帮助我们重画窗口
		@Override
		public void run() {
			while(true)
			{
				repaint();//重画
				try {
					Thread.sleep(45);//1s=1000ms
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		}
	}
	
	class KeyMonitor extends KeyAdapter{//增加键盘监听的事件
		public void keyPressed(KeyEvent e) {
			plane.addDirection(e);
		}
		public void keyReleased(KeyEvent e) {
			plane.minusDirection(e);
		}
		
	}
	public Image offScreenImage = null;//利用双缓冲解决窗口闪烁问题
	public void update(Graphics g) {
		if(offScreenImage==null)
			offScreenImage=this.createImage(475,669);
		
		Graphics goff=offScreenImage.getGraphics();
		paint(goff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	public static void main(String args[]) {
		GameFrame f = new GameFrame();
		f.lunch();
	}
}
