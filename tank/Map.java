package tank;
/**
 * ��ͼ������
 * ��ֹ�з�̹���ص�
 * @author zhang
 *
 */
public class Map {
    public int[][] location=new int[500][500];
    public Map() {
        for (int i = 0; i < 500; i++) {
            for (int j = 0; j <500; j++) {
                location[i][j]=0;
            }
        }
    }
}

