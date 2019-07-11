package tank;
import java.util.Vector;
/**
 * ̹����
 * ÿ��̹�˾���һ���̣߳�
 * �����Լ�̹�˲�û�������߳�
 * @author zhang
 *
 */
public class Tank implements Runnable {
    private int x = 0;
    private int y = 0;// ����
    private int drect = 0;// ���� 0���ϣ�1���ң�2���£�3����
    private int type = 0;// ̹������ 0��ʾ�Լ�
    private int speed = 3;// �ٶ�
    public Vector<Bullet> mybs = new Vector<Bullet>();// �ӵ���
    private Bullet myBullet;// �ӵ�
    public boolean islive = true;
    private Map map;
    public boolean start = true;
    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Tank(int x, int y, int drect, int type) {
        super();
        this.x = x;
        this.y = y;
        this.drect = drect;
        this.type = type;
    }

    public Tank() {
        super();
    }

    public Bullet getMyBullet() {
        return myBullet;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public int getDrect() {
        return drect;
    }

    public void setDrect(int drect) {
        this.drect = drect;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveUp() {
        if (y - speed < 0)
            y = 0;
        else {
            y -= speed;
             map.location[x][y]=1;//��Ǵ�̹�������ڵ�ͼ�Ϸ�ֹ����̹�˹���ռ�õ����ص�
//             ����ֻ�����̹��������һ���㣬����bug������̹�˻������ص�����
//             ������Ա�������̹�����꣨x��x+20��y��y+30�����ñ�ǡ�
            for(int i=x;i<x+20;i++){
                 for (int j = y; j < y+30; j++) {
                     map.location[x][y]=1;
               }
            }
        }
    }

    public void moveDown() {
        if (y + speed > 470)
            y = 470;
        else {
            y += speed;
             map.location[x][y]=1;
        }
    }

    public void moveRight() {
        if (x + speed > 470)
            x = 470;
        else {
            x += speed;
             map.location[x][y]=1;
        }
    }

    public void moveLeft() {
        if (x - speed < 0)
            x = 0;
        else {
            x -= speed;
             map.location[x][y]=1;
        }
    }

    public void shot() {
        switch (drect) {
        case 0:
            myBullet = new Bullet(x + 10, y, 5, 0);
            mybs.add(myBullet);
            break;
        case 1:
            myBullet = new Bullet(x + 30, y + 10, 5, 1);
            mybs.add(myBullet);
            break;
        case 2:
            myBullet = new Bullet(x + 10, y + 30, 5, 2);
            mybs.add(myBullet);
            break;
        case 3:
            myBullet = new Bullet(x, y + 10, 5, 3);
            mybs.add(myBullet);
            break;
        }
    }

    @Override
    public void run() {
        while (islive) {
            if (start) {
                int step;
                int s;
                try {
                    switch (drect) {
                    case 0:
                        step = (int) (Math.random() * 30);
                        for (int i = 0; i < step; i++) {
                            moveUp();
                            if (y <= 0)
                                break;// ײǽ����ѭ��
                            if (y >= 30)// ������Խ��
                                if (map.location[x][y - 30] == 1 || map.location[x][y - 20] == 1) {
                                    map.location[x][y - 30] = 0;//����û�ֿ��ж�
                                    map.location[x][y - 20] = 0;
                                    break;
                                }
                            Thread.sleep(80);
                        }
                        break;
                    case 1:
                        step = (int) (Math.random() * 30);
                        for (int i = 0; i < step; i++) {
                            moveRight();
                            if (x >= 500)
                                break;
                            if (x < 470)
                                if (map.location[x + 20][y] == 1 || map.location[x + 30][y] == 1) {
                                    map.location[x + 20][y] = 0;
                                    map.location[x + 30][y] = 0;
                                    break;
                                }
                            Thread.sleep(80);
                        }
                        break;
                    case 2:
                        step = (int) (Math.random() * 30);
                        for (int i = 0; i < step; i++) {
                            moveDown();
                            if (y >= 500)
                                break;
                            if (y < 470)
                                if (map.location[x][y + 30] == 1 || map.location[x][y + 20] == 1) {
                                    map.location[x][y + 30] = 0;
                                    map.location[x][y + 20] = 0;
                                    break;
                                }
                            Thread.sleep(80);
                        }
                        break;
                    case 3:
                        step = (int) (Math.random() * 30);
                        for (int i = 0; i < step; i++) {
                            moveLeft();
                            if (x <= 0)
                                break;
                            if (x >= 30)
                                if (map.location[x - 20][y] == 1 || map.location[x - 30][y] == 1) {
                                    map.location[x - 20][y] = 0;
                                    map.location[x - 30][y] = 0;
                                    break;
                                }
                            Thread.sleep(80);
                        }
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                drect = (int) (Math.random() * 4);// �������
                s = (int) (Math.random() * 10);
                if (s > 8) {
                    shot();
                }
            }
        }
    }
}

