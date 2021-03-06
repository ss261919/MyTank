package com.zss.tank;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {

	private int x,y;
	public static final int WIDTH = ResourceMgr.bulletD.getWidth(),HEIGHT = ResourceMgr.bulletD.getHeight();
	private static final int SPEED = 8;
	private Dir dir;
	private TankFrame tf;
	private boolean living = true;
	private  Group group;
	
	Rectangle rect = new Rectangle();
	
	public Bullet(int x, int y, Dir dir,Group group,TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		this.tf = tf;
		rect.x = x;
		rect.y = y;
		rect.width = WIDTH;
		rect.height = HEIGHT;
		
	}
	
	public void paint(Graphics g) {
		if(!living) {
			tf.bulletList.remove(this);
		}
		
		switch (dir) {
			case LEFT:
				g.drawImage(ResourceMgr.bulletL, x, y, null);
				break;
			case RIGHT:
				g.drawImage(ResourceMgr.bulletR, x, y, null);
				break;
			case UP:
				g.drawImage(ResourceMgr.bulletU, x, y, null);
				break;
			case DOWN:
				g.drawImage(ResourceMgr.bulletD, x, y, null);
				break;
		}
		
		move();
		
	}
	
	private void move() {
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
		if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
			living = false;
		}
		rect.x = x;
		rect.y = y;
	}
	
	public void collideWith(Tank tank) {
		if(this.group == tank.getGroup()) {
			return;
		}
		//TODO:用一个rectangle来记录子弹的位置
//		Rectangle rBullet = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
//		Rectangle tBullet = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,tank.HEIGHT);
		if(rect.intersects(tank.rect)) {
			this.die();
			tank.die();
			int ex = tank.getX()+tank.WIDTH/2-Explode.WIDTH/2 ;
			int ey =tank.getY() + tank.HEIGHT/2-Explode.HEIGHT/2 ;
			tf.explodeList.add(new Explode(ex,ey, tf));
		}
	}

	private void die() {
		this.living = false;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Dir getDir() {
		return dir;
	}
	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
}
