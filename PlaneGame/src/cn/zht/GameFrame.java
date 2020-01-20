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
	Plane plane = new Plane(planeImg,200,550);//���÷ɻ���ʼλ��
	BloodAdd bloodadd = new BloodAdd(bloodImg,100,400);//����Ѫ��
	Shell[] shell = new Shell[50]; 
	Blood blood = new Blood();//����Ѫ��
	Explode bao;
	Date startTime=new Date();
	Date endTime;
	int period;//��Ϸ����ʱ��
	public void lunch(){
		this.setTitle("zht��Ʒ");
		this.setVisible(true);
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		this.setLocation(200, 50);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		new PaintThread().start();//�����ػ������߳�
		addKeyListener(new KeyMonitor());//���Ӽ��̵ļ���
		
		for(int i=0;i<shell.length;i++) {//��ʼ���ڵ�
			shell[i]=new Shell();
		}
		blood = new Blood();
	}
	
	public void paint(Graphics g) {//�˷����Զ������ã�g�൱��һֻ����
		g.drawImage(bg, 0, 0, null);
		plane.drawSelf(g); //���ɻ�
		bloodadd.drawSelf(g);
		g.drawImage(bloodImg, 300, 300,null);//��Ѫ��
		for(int i=0;i<shell.length;i++) {
		shell[i].draw(g);//���ڵ�
		blood.draw(g);//��Ѫ��
		blood.drawself(g);
		boolean boom = shell[i].getRectangle().intersects(plane.getRectangle());
		boolean relife = bloodadd.getRectangle().intersects(plane.getRectangle());
		if(relife) {
			blood.width=100;
		}
		if(boom) {//��ײ���
			
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
		g.drawString("��Ϸʱ��Ϊ��"+period+"��",(int)plane.x,(int)plane.y);
		}
		}
	}
	
	class PaintThread extends Thread{//���������ػ�����
		@Override
		public void run() {
			while(true)
			{
				repaint();//�ػ�
				try {
					Thread.sleep(45);//1s=1000ms
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		}
	}
	
	class KeyMonitor extends KeyAdapter{//���Ӽ��̼������¼�
		public void keyPressed(KeyEvent e) {
			plane.addDirection(e);
		}
		public void keyReleased(KeyEvent e) {
			plane.minusDirection(e);
		}
		
	}
	public Image offScreenImage = null;//����˫������������˸����
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
