package starter;

import java.util.ArrayList;
import acm.graphics.GRect;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bullet {
	public static final int WINDOW_HEIGHT = 600;
	public static final int WINDOW_WIDTH = 800;
	public static final int WIDTH = 5;
	public static final int HEIGHT = 15;
	public static final int MS = 50;
	
	private space start;
	private int speed;
	private GRect bullet;
	private ActionListener listener;
	private ArrayList<GRect> bullets;
	private Timer movement;
	
//Constructor
	Bullet(int x, int y, int speed){
		start.setX(x);
		start.setY(y);
		this.speed=speed;
	}
	
//Getters
	public space getStart() {
		return start;
	}
	
//Setters
	public void setStart(int x, int y) {
		start.setX(x);
		start.setY(y);
	}
	public void setSpeed(int s) {
		this.speed = s;
	}
	
//Methods
	//Makes bullets to add on screen
	public GRect makeBullet(int x) {
		GRect tempBullet = new GRect(x, start.getY(),WIDTH, HEIGHT);
		tempBullet.setColor(Color.ORANGE);
		tempBullet.setFilled(true);
		return tempBullet;
	}
	
	//Adds bullets on screen
	public void addBullet(int x) {
		bullet= makeBullet(x);
		bullets.add(bullet);
	}
	
	//Continuously moves all bullets on screen with actionPerformed 
	public void moveAllBullets() {
		for(GRect bullet:bullets) {
			bullet.move(0,speed);
			removeBullet(false);
		}
	}
	
	//Remove bullet from bullets if it hits enemy/fighter or if it goes off screen
	public void removeBullet(boolean hit) {
		for(GRect bullet:bullets) {
			if(bullet.getX()>WINDOW_HEIGHT|| hit) {
				bullets.remove(bullet);
			}
		}
	}
	
//event methods
	public void actionPerformed(ActionEvent e) {
		moveAllBullets();
	}
	
	public void run() {
		start= new space(400,  WINDOW_HEIGHT-10);
		bullets= new ArrayList<GRect>();
		movement= new Timer(MS, listener);
		movement.start();
	}
}

