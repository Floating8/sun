package tank;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import tank.Mypanel;

/**
 * �¼�����
 * �����и�����������ӵ���
 * @author zhang
 */
public class KeyListen implements KeyListener{
    private Mypanel mp=null;
    
    public KeyListen(Mypanel mp) {
        super();
        this.mp = mp;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        //���������
        if(e.getKeyCode()==KeyEvent.VK_W){
            mp.mytank.setDrect(0);
            mp.mytank.moveUp();
        }else if(e.getKeyCode()==KeyEvent.VK_S){
            mp.mytank.setDrect(2);
            mp.mytank.moveDown();
        }else if(e.getKeyCode()==KeyEvent.VK_D){
            mp.mytank.setDrect(1);
            mp.mytank.moveRight();
        }else if(e.getKeyCode()==KeyEvent.VK_A){
            mp.mytank.setDrect(3);
            mp.mytank.moveLeft();
        }
        //�����ӵ�����
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            if(mp.mytank.mybs.size()<5)
            mp.mytank.shot();
        }
        mp.repaint();
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}

