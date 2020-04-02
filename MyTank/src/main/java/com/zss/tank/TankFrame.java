package com.zss.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {

	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;
	Tank myTank = new Tank(GAME_WIDTH/2-Tank.WIDTH/2,GAME_HEIGHT/2-Tank.HEIGHT/2,Dir.DOWN,this);
	List<Bullet> bulletList = new ArrayList<Bullet>();
	
	
	public TankFrame(){
		setResizable(false);
		setVisible(true);
		setBounds(GAME_WIDTH, GAME_HEIGHT,GAME_WIDTH,GAME_HEIGHT);
		setTitle("myTank war");
		
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
		
		Color color = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("子弹数量："+bulletList.size(), 10, 60);
		g.setColor(color);
		
		myTank.paint(g);
		
		for (int i = 0; i < bulletList.size(); i++) {
			bulletList.get(i).paint(g);
		}
	}
	
	
	Image offScreenImage = null;
	/**
	 * 解决闪烁 双缓冲问题
	 */
	@Override
	public void update(Graphics g) {
		if(offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
		
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
			case KeyEvent.VK_SPACE:
				myTank.fire();
				break;
			}
			setMainTankDir();
		}

		private void setMainTankDir() {
			if(!l && !r && !u && !d) {
				myTank.setMoving(false);
			}else {
				myTank.setMoving(true);
				if(l)  myTank.setDir(Dir.LEFT);
				if(r)  myTank.setDir(Dir.RIGHT);
				if(u)  myTank.setDir(Dir.UP);
				if(d)  myTank.setDir(Dir.DOWN);
			}
			
		}
		
	}

}
