package cn.zht;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
* @author zht
* @version ����ʱ�䣺2019��11��24�� ����11:36:38
*/
public class GameUtil {
		private GameUtil() {}
		
		public static Image getImage(String path){
			BufferedImage bi = null;
			try {
				URL u = GameUtil.class.getClassLoader().getResource(path);
				bi =ImageIO.read(u);
			}catch(IOException e) {
				e.printStackTrace();
			}
			return bi;
		}
}
