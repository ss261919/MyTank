package com.zss.tank;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourceMgr {
	static BufferedImage tankL,tankR,tankU,tankD;
	static BufferedImage bulletL,bulletR,bulletU,bulletD;
	public static BufferedImage[] explodes = new BufferedImage[16];

	static {
		try {
			tankU =  ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
			tankR =  ImageUtil.rotateImage(tankU, 90);
			tankD =  ImageUtil.rotateImage(tankR, 90);
			tankL =  ImageUtil.rotateImage(tankD, 90);
			
			bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
			bulletR = ImageUtil.rotateImage(bulletU, 90);
			bulletD = ImageUtil.rotateImage(bulletR, 90);
			bulletL = ImageUtil.rotateImage(bulletD, 90);
			
			for(int i=0; i<16; i++) 
				explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i+1) + ".gif"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
