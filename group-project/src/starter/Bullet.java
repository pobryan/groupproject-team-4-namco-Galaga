package starter;

import java.util.ArrayList;

import acm.graphics.GImage;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bullet implements ActionListener{
	public static final int WINDOW_HEIGHT = 600;
	public static final int WINDOW_WIDTH = 800;
	public static final int WIDTH = 7;
	public static final int HEIGHT = 15;
	public static final int MS = 50;
	
	private space start;
	private int speed;
	private GImage bullet;
	private ArrayList<GImage> bullets;
	private Timer movement;
	
//Constructor
	Bullet(double x, double y, int speed){
		bullets= new ArrayList<GImage>();
		movement= new Timer(MS, this);
		movement.start();
		start= new space(x,y);
		this.speed=speed;
	}
	
//Getters
	public space getStart() {
		return start;
	}
	
	public ArrayList<GImage> getBullets(){
		return bullets;
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
	public GImage makeBullet(double x, double y) {
		GImage tempBullet = new GImage("fighter bullet.png",x, y);
		tempBullet.setSize(WIDTH, HEIGHT);;
		return tempBullet;
	}
	
	//Adds bullets on screen
	public void addBullet(double x, double y) {
		bullet= makeBullet(x,y);
		bullets.add(bullet);
	}
	
	//Continuously moves all bullets on screen with actionPerformed 
	public void moveAllBullets() {
		for(GImage bullet:bullets) {
			bullet.move(0,speed);
			removeBullet(false);
		}
	}
	
	//Remove bullet from bullets if it hits enemy/fighter or if it goes off screen
	public void removeBullet(boolean hit) {
		for(GImage bullet:bullets) {
			if(bullet.getX()>WINDOW_HEIGHT|| hit) {
				bullets.remove(bullet);
			}
		}
	}
	
//event methods
	public void actionPerformed(ActionEvent e) {
		moveAllBullets();
	}
}

