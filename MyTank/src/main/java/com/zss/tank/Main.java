package com.zss.tank;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		TankFrame frame = new TankFrame();
		while (true) {
			try {
				TimeUnit.MILLISECONDS.sleep(50);
				frame.repaint();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
