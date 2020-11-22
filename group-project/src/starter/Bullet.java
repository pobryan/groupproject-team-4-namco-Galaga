package starter;

import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bullet implements ActionListener{
	private MainApplication program;
	
	public static final int PROGRAM_HEIGHT = 600;
	public static final int WIDTH = 5;
	public static final int HEIGHT = 15;
	public static final int MS = 25;
	
	
	private space start;
	private int speed, numTimes=0;
	private GImage bullet, enemyBullet;
	private String image;
	private ArrayList<GImage> bullets, enemyBullets;
	private Timer movement;
	
//Constructor
	Bullet(double x, double y, int speed, String image){
		this.image=image;
		bullets= new ArrayList<GImage>();
		enemyBullets= new ArrayList<GImage>();
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
	
	public ArrayList<GImage> getEnemyBullets(){
		return enemyBullets;
	}
//Setters
	public void setStart(int x, int y) {
		start.setX(x);
		start.setY(y);
	} 
	
//Methods
	//Makes bullets to add on screen
	public GImage makeBullet(double x, double y) {
		GImage tempBullet = new GImage(image);
		tempBullet.setLocation(x, y);
		tempBullet.setSize(WIDTH, HEIGHT);
		return tempBullet;
	}
	
	//Adds bullets on screen
	public void addBullet(double x, double y,MainApplication program) {
		this.program=program;
		bullet= makeBullet(x,y);
		bullets.add(bullet);
 	}
	
	public void addEnemyBullet(double x, double y, MainApplication program) {
		this.program=program;
		enemyBullet= makeBullet(x,y);
		enemyBullets.add(enemyBullet);
	}
	
	//Continuously moves all bullets on screen with actionPerformed 
	public void moveAllBullets() {
		for(GImage bullet: bullets) {
			bullet.move(0, speed);
		}
		removeBullet();
	}
	
	public void moveAllEnemyBullets() {
		for(int i=0; i<enemyBullets.size(); i++) {
			enemyBullet=enemyBullets.get(i);
			
			enemyBullet.move(0,speed);
			removeEnemyBullet();
		}
	}
	
	//Remove bullet from bullets if it hits enemy/fighter or if it goes off screen
	public void removeBullet() {
		for(int i=0; i<bullets.size(); i++) {
			bullet= bullets.get(i);
			GObject fighterElement= program.getElementAt(bullet.getX()+(WIDTH/2), bullet.getY()-1);
			
			if(bullet.getY()<-15 || (fighterElement!=null && fighterElement instanceof GImage)) {
				program.remove(bullet);
				bullets.remove(i);
			}
		}
	}
	
	public void removeEnemyBullet() {
		for(int i=0; i<enemyBullets.size(); i++) {
			enemyBullet=enemyBullets.get(i);
			GObject enemyElement= program.getElementAt(enemyBullet.getX()+(WIDTH/2), enemyBullet.getY()-1);
			
			if(enemyBullet.getY()>(PROGRAM_HEIGHT+15) || (enemyElement!=null && enemyElement instanceof GImage)) {
				program.remove(enemyBullet);
				bullets.remove(i);
			}
		}
	}
	
//event methods
	public void actionPerformed(ActionEvent e) {
		moveAllBullets();
//		moveAllEnemyBullets();
		numTimes++;
	}
	
//	public void run() {
//		bullets= new ArrayList<GRect>();
//		movement= new Timer(MS, listener);
//		movement.start();
//	}
}

