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
	private final int SPEED = 10;
	
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
				r = false;
				break;
			case KeyEvent.VK_RIGHT:
				r = true;
				l = false;
				break;
			case KeyEvent.VK_UP:
				u = true;
				d = false;
				break;
			case KeyEvent.VK_DOWN:
				d = true;
				u = false;
				break;
			}
			move();
			repaint();
			
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
		}
		
		private void move() {
			if(l&&u) {
				x-=SPEED;
				y-=SPEED;
			}else if(l&&d) {
				x-=SPEED;
				y+=SPEED;
			}else if(r&&u) {
				x+=SPEED;
				y-=SPEED;
			}else if(r&&d) {
				x+=SPEED;
				y+=SPEED;
			}else if(l) {
				x-=SPEED;
			}else if(r) {
				x+=SPEED;
			}else if(u) {
				y-=SPEED;
			}else if(d) {
				y+=SPEED;
			}
		}
		
	}

}
