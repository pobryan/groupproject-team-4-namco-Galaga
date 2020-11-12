package starter;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

public class Fighter extends GRectangle{
	public static final int IMAGE_WIDTH = 45;
	public static final int IMAGE_HEIGHT = 45;
	
	//private space position;				We are now inheriting GRectangle.
	double speed;
	int lives;
	Bullet shoot;
	//add a GImage
	private GImage fighterImage;
	
	
	//Getters
	public int getLives() {
		return lives;
	}
	
	/*
	public space getPosition() {
		return position;
	}*/
	
	public GImage getFighterImage() {
		return fighterImage;
	}
	//Setters
	public void setFighterPosition(GImage i) {
		double imageX = i.getX();
		double imageY = i.getY();
		this.setLocation(imageX, imageY);
	}
	public void setFighterPosition(double x, double y) {
		this.setLocation(x,y);
		fighterImage.setLocation(x, y);
	}
	public void setLives(int lives) {
		this.lives = lives;
	}
	
	//Constructors
	Fighter(){
		//position = new space(0, 0);
		lives = 3;
		this.setLocation(0, 0);
		fighterImage = new GImage("Fighter.png", 0, 0);
		fighterImage.setLocation(0, 0);
	}
	
	Fighter(int x, int y, /*space p,*/ int l){
		//position = new space(x, y);
		//position = p;
		lives = l;
		this.setLocation(x, y);
		fighterImage = new GImage("Fighter.png", x, y);
	}
	
	//Methods
	public void addLife() {
		lives++;
	}
	
	public void loseLife() {
		lives--;
	}
	
	public boolean isLivesEmpty() {
		if(lives==-1) {
			return true;
		}
		return false;
	}
	
	public boolean isFighterHit() {
		return true;
	}
	
	public void shoot() {
		
	}
	
	public void moveLeft() {
		
	}
	
	public void moveRight() {
		
	}
	
	
}
