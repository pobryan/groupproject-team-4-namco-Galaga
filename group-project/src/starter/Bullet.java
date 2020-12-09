package starter;

import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GRect;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bullet implements ActionListener{
	private MainApplication program;
	private Graphics screen;
	
	public static final int PROGRAM_HEIGHT = 600;
	public static final int WIDTH = 5;
	public static final int HEIGHT = 15;
	public static final int MS = 25;
	
	
	private space start;
	private int speed, numTimes=0;
	private GImage bullet;
	private String image;
	private ArrayList<GImage> bullets, enemyBullets;
	private Timer movement;
	private Fighter fighter;
	
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
	
	//Adds fighter bullets on screen
	public void addBullet(double x, double y, MainApplication program, Graphics screen) {
		this.program=program;
		this.screen=screen;
		bullet= makeBullet(x,y);
		bullets.add(bullet);
		program.add(bullet);
		program.add(bullet);
 	}
	
	//Adds enemy bullets on screen
	public void addEnemyBullet(double x, double y, MainApplication program,Graphics screen) {
		if(numTimes % 40 == 0 ) {
			this.program=program;
			this.screen=screen;
			bullet= makeBullet(x,y);
			enemyBullets.add(bullet);
			program.add(bullet);
		}
	}
	
	//Continuously moves all fighter bullets on screen with actionPerformed 
	public void moveAllBullets() {
		for(GImage bullet: bullets) {
			bullet.move(0, speed);
		}
		removeBullet();
	}
	
	//Continuously moves all enemy bullets on screen with actionPerformed
	public void moveAllEnemyBullets() {
		for(GImage enemy: enemyBullets) {			
			enemy.move(0,speed);
		}
		removeEnemyBullet();
	}
	
	//Remove fighter bullet from bullets if it hits enemy/fighter or if it goes off screen
	public void removeBullet() {
		int sizeBefore;
		for(int i=0; i<bullets.size(); i++) {
			sizeBefore = bullets.size();
			bullet= bullets.get(i);
			GObject enemyElement= program.getElementAt(bullet.getX()+(WIDTH/2), bullet.getY()-1);
			if(bullet.getY()<-15) {
				program.remove(bullet);
				bullets.remove(i);
			}
			else if(enemyElement != null && enemyElement instanceof GImage && enemyElement.getWidth() == 45 && enemyElement.isVisible()) {
				program.remove(bullet);
				enemyElement.setVisible(false);
				screen.enemyHit();
				for(int j = 0; j < screen.getStage().getRedEnemyList().size(); j++) {
					if(enemyElement.getX() == screen.getStage().getRedEnemyList().get(j).getX()) {
						screen.getStage().removeRedEnemyFromStage(screen.getStage().getRedEnemyList().get(j));
					}
				}
				for(int k= 0; k < screen.getStage().getBlueEnemyList().size(); k++) {
					if(enemyElement.getX() == screen.getStage().getBlueEnemyList().get(k).getX()) {
						screen.getStage().removeBlueEnemyFromStage(screen.getStage().getBlueEnemyList().get(k));
					}
				}
				
				program.remove(enemyElement);
				bullets.remove(i);
				
			}
		}
	}
	
	//Remove enemy bullet from bullets if it hits enemy/fighter or if it goes off screen
	public void removeEnemyBullet() {
		for(int i=0; i<enemyBullets.size(); i++) {
			bullet=enemyBullets.get(i);
			GObject fighterElement= program.getElementAt(bullet.getX()+(WIDTH/2), bullet.getY()-1);
			
			if(bullet.getY()>(PROGRAM_HEIGHT+15)) {
				program.remove(bullet);
				enemyBullets.remove(i);
			}
			else if(fighterElement != null && fighterElement instanceof GImage && fighterElement.getWidth()==46 && fighterElement.isVisible() && !screen.getStage().getFighter().isInvincible()) {
				program.remove(bullet);
				fighterElement.setVisible(false);
				screen.bulletHit();
				screen.getStage().getFighter().setInvincible(true);
				
				enemyBullets.remove(i);
			}
		}
	}
	
	//removes all bullets on screen
	public void removeAllBullets() {
		if(bullets.size() != 0) {
			for(int i=0; i<bullets.size(); i++) {
				if(bullets.size() == 0) {
				
				}
				else {
					program.remove(bullets.get(0));
					bullets.remove(0);
				}
			}
		}
		//out of bounds
		if(enemyBullets.size() != 0) {
			for(int i=0; i<enemyBullets.size(); i++) {
        		if(enemyBullets.size() == 0) {}
        		else {
        			program.remove(enemyBullets.get(0));
        			enemyBullets.remove(0);
        		}
        	}
			bullets.clear();
			enemyBullets.clear();
		}
	}
	
//event methods
	public void actionPerformed(ActionEvent e) {
		moveAllBullets();
		moveAllEnemyBullets();
		numTimes++;
	}
}