package com.zss.tank;

import java.awt.Graphics;
import java.util.Random;

public class Tank {

	private int x;
	private int y;
	public static final int WIDTH = ResourceMgr.tankD.getWidth(),HEIGHT = ResourceMgr.tankD.getHeight();
	private static final int SPEED = 2;
	private Dir dir;
	private boolean moving = true;
	private boolean living = true;
	private  Group group = Group.BAD;
	private Random random = new Random();
	private TankFrame tf;
	
	public Tank() {
		
	}
	public Tank(int x, int y, Dir dir,Group group,TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		this.tf = tf;
	}
	
	public void paint(Graphics g) {
		if(!living) {
			tf.tanks.remove(this);
		}
		switch (dir) {
			case LEFT:
				g.drawImage(ResourceMgr.tankL, x, y, null);
				break;
			case RIGHT:
				g.drawImage(ResourceMgr.tankR, x, y, null);
				break;
			case UP:
				g.drawImage(ResourceMgr.tankU, x, y, null);
				break;
			case DOWN:
				g.drawImage(ResourceMgr.tankD, x, y, null);
				break;
		}
		
		move();
	}
	
	private void move() {
		if(!moving) return;
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
		if(this.group == group.BAD && random.nextInt(100) > 95)this.fire();
		if(this.group == group.BAD && random.nextInt(100) > 95)
			randomDir();
		
	}
	
	private void randomDir() {
		this.dir = Dir.values()[random.nextInt(4)];
		
	}
	public void fire() {
		int x = this.x + this.WIDTH/2-Bullet.WIDTH/2 ;
		int y = this.y + this.HEIGHT/2-Bullet.HEIGHT/2 ;
		tf.bulletList.add(new Bullet(x,y,this.dir,this.group,tf));
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
	public boolean isMoving() {
		return moving;
	}
	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	public boolean isLiving() {
		return living;
	}
	public void setLiving(boolean living) {
		this.living = living;
	}
	public void die() {
		living = false;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}

	

}
