package com.zss.tank;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourceMgr {
	static BufferedImage goodTankL,goodTankR,goodTankU,goodTankD;
	static BufferedImage badTankL,badTankR,badTankU,badTankD;
	static BufferedImage bulletL,bulletR,bulletU,bulletD;
	public static BufferedImage[] explodes = new BufferedImage[16];

	static {
		try {
			goodTankU =  ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
			goodTankR =  ImageUtil.rotateImage(goodTankU, 90);
			goodTankD =  ImageUtil.rotateImage(goodTankR, 90);
			goodTankL =  ImageUtil.rotateImage(goodTankD, 90);
			
			badTankU =  ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
			badTankR =  ImageUtil.rotateImage(badTankU, 90);
			badTankD =  ImageUtil.rotateImage(badTankR, 90);
			badTankL =  ImageUtil.rotateImage(badTankD, 90);
			
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
