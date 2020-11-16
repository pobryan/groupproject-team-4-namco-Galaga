package starter;

import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

public class Fighter extends GRectangle{
	public static final int IMAGE_SIZE = 45;
	public static final int FIGHTER_MID=(IMAGE_SIZE/2)-3;
	
	//private space position;				We are now inheriting GRectangle.
	double speed;
	private ArrayList<GImage> lives;
	Bullet shoot;
	
	private GImage fighterImage;
	
	
	//Getters
	public ArrayList<GImage> getLives() {
		return lives;
	}
	
	/*
	public space getPosition() {
		return position;
	}*/
	
	public GImage getFighterImage() {
		return fighterImage;
	}
	
	public Bullet getBullet() {
		return shoot;
	}
	
	//Setters
//	public void setFighterPosition(GImage i) {
//		double imageX = i.getX();
//		double imageY = i.getY();
//		this.setLocation(imageX, imageY);
//	}
	
	public void setFighterPosition(double x, double y) {
		this.setLocation(x,y);
		fighterImage.setLocation(x, y);
	}
	
	public void setLives(int lives) {
		this.lives = new ArrayList<GImage>(lives);
	}
	
	//Constructors
	Fighter(){
		//position = new space(0, 0);
		this.setLocation(0, 0);
		fighterImage = new GImage("Fighter.png", 0, 0);
		fighterImage.setLocation(0, 0);
		lives = new ArrayList<GImage>(3);
		for(int i=0;i<3;i++) {
			GImage life=new GImage("Fighter.png");
			life.setSize(IMAGE_SIZE, IMAGE_SIZE);
			lives.add(life);
		}
		shoot=new Bullet(0,0,-4);
	}
	
	Fighter(double x, double y, /*space p,*/ int l){
		//position = new space(x, y);
		//position = p;
		this.setLocation(x, y);
		fighterImage = new GImage("Fighter.png", x, y);
		lives = new ArrayList<GImage>(l);
		for(int i=0;i<l;i++) {
			GImage life=new GImage("Fighter.png");
			life.setSize(IMAGE_SIZE, IMAGE_SIZE);
			lives.add(life);
		}
		shoot=new Bullet(x,y,-4);
	}
	
	//Methods
	public void addLife() {
		lives.add(fighterImage);
	}
	
	public void loseLife() {
		lives.remove(fighterImage);
	}
	
	public boolean isLivesEmpty() {
		return lives.isEmpty();
	}
	
	public boolean isFighterHit() {
		return true;
	}
	
	public void shoot() {
		shoot.addBullet(this.getLocation().getX()+FIGHTER_MID, this.getLocation().getY());
	}
	
	public void moveLeft() {
		
	}
	
	public void moveRight() {
		
	}
	
	
}
