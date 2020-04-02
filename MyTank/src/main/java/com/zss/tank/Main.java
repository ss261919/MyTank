package com.zss.tank;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		TankFrame tf = new TankFrame();
		
		for (int i = 0; i < 5; i++) {
			tf.tanks.add(new Tank(50+80*i,200,Dir.DOWN,Group.BAD,tf));
		}
		
		while (true) {
			try {
				TimeUnit.MILLISECONDS.sleep(50);
				tf.repaint();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
