package starter;

import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bullet implements ActionListener{
	public static final int WINDOW_HEIGHT = 600;
	public static final int WINDOW_WIDTH = 800;
	public static final int WIDTH = 5;
	public static final int HEIGHT = 15;
	public static final int MS = 50;
	
	private MainApplication program;
	private space start;
	private int speed;
	private GImage bullet,image, enemyBullet;
	private ArrayList<GImage> bullets, enemyBullets;
	private Timer movement;
	
//Constructor
	Bullet(double x, double y, int speed, GImage image){
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
		GImage tempBullet = image;
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
		for(GImage bullet:bullets) {
			bullet.move(0,speed);
			removeBullet();
		}
	}
	
	public void moveAllEnemyBullets() {
		for(GImage enemy:enemyBullets) {
			enemy.move(0,speed);
			removeEnemyBullet();
		}
	}
	
	//Remove bullet from bullets if it hits enemy/fighter or if it goes off screen
	public void removeBullet() {
		for(GImage bullet:bullets) {
			GObject fighterElement= program.getElementAt(bullet.getX()+(WIDTH/2), bullet.getY()-1);//NULL POINTER EXCEPTION
			
			if(fighterElement!=null && fighterElement instanceof GImage || bullet.getY()<-15) {
				program.remove(bullet);
				bullets.remove(bullet);
			}
		}
	}
	
	public void removeEnemyBullet() {
		for(GImage enemy:enemyBullets) {
			GObject enemyElement= program.getElementAt(enemy.getX()+(WIDTH/2), enemy.getY()-1);
			
			if(enemy.getY()>(WINDOW_HEIGHT+15) || (enemyElement!=null && enemyElement instanceof GImage)) {
				program.remove(enemy);
				bullets.remove(enemy);
			}
		}
	}
	
//event methods
	public void actionPerformed(ActionEvent e) {
		moveAllBullets();
//		moveAllEnemyBullets();
	}
	
//	public void run() {
//		bullets= new ArrayList<GRect>();
//		movement= new Timer(MS, listener);
//		movement.start();
//	}
}

