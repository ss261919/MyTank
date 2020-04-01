package com.zss.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

	private  int  x = 200;
	private  int  y = 200;
	Dir dir = Dir.DOWN;
	private static final int SPEED = 10;
	
	public TankFrame(){
		setResizable(false);
		setVisible(true);
		setBounds(800, 500, 500, 500);
		setTitle("tank war");
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		addKeyListener(new MyKeyListener());
		
	}
	
	@Override
	public void paint(Graphics g) {
		g.fillRect(x, y, 50, 50);
		
		switch (dir) {
			case LEFT:
				x-=SPEED;
				break;
			case RIGHT:
				x+=SPEED;	
				break;
			case UP:
				y-=SPEED;
				break;
			case DOWN:
				y+=SPEED;
				break;
		}
		
	}
	
	class MyKeyListener extends KeyAdapter{
		boolean l = false;
		boolean r = false;
		boolean u = false;
		boolean d = false;

		@Override
		public void keyTyped(KeyEvent e) {
			super.keyTyped(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				l = true;
				break;
			case KeyEvent.VK_RIGHT:
				r = true;
				break;
			case KeyEvent.VK_UP:
				u = true;
				break;
			case KeyEvent.VK_DOWN:
				d = true;
				break;
			}
			setMainTankDir();
		}
		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				l = false;
				break;
			case KeyEvent.VK_RIGHT:
				r = false;
				break;
			case KeyEvent.VK_UP:
				u = false;
				break;
			case KeyEvent.VK_DOWN:
				d = false;
				break;
			}
			setMainTankDir();
		}

		private void setMainTankDir() {
			if(l) dir = Dir.LEFT;
			if(r) dir = Dir.RIGHT;
			if(u) dir = Dir.UP;
			if(d) dir = Dir.DOWN;
		}
		
		
		
	}

}
