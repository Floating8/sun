package tank;


/**
 * �ӵ��࣬
 * ��Ϊ����ӵ�ͬʱ�˶�������Ҫ���ڲ������߳�
 * @author zhang
 *
 */
public class Bullet {
    private int x;
    private int y;
    private int speed;
    private int drect;
    public boolean islive=true;
    public Bullet(int x, int y, int speed, int drect) {
        super();
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.drect = drect;
        new Thread(new BulletThread()).start();
    }
    public Bullet() {
        super();
    }

    public int getX() {
        return x;
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

    class BulletThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                switch (drect) {//�жϷ��������ƶ�
                case 0:
                    y-=speed;
                    break;
                case 1:
                    x+=speed;
                    break;
                case 2:
                    y+=speed;
                    break;
                case 3:
                    x-=speed;
                    break;
                }
                if (x < 0 || y < 0 || x > 500 || y > 500||!islive) {
                    islive=false;
                    break;
                }
            }
        }
    }
}

