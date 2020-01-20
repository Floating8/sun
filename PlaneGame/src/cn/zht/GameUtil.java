package cn.zht;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
* @author zht
* @version 创建时间：2019年11月24日 上午11:36:38
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
