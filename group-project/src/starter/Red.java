package starter;

import acm.graphics.GImage;

public class Red extends enemy{
	public static final int SPEED = 4;
	
	Fighter target;
	private double degToAttack, degToRetreat;
	//add GImage object
	private GImage redEnemyImage;
	private space spaceToAttack, spaceToRetreat;
	private boolean attacking, retreating;
	
	Red(){
		this.setLocation(0, 0);
		degToAttack = 0;
		degToRetreat = 0;
		redEnemyImage = new GImage("Red.png", 0, 0);
		redEnemyImage.setLocation(0, 0);
		attacking = false;
	}
	
	Red(int x, int y, Fighter target){
		this.setLocation(x, y);
		this.target = target;
		//spaceToReturn = start;
		redEnemyImage = new GImage("Red.png", x, y);
		spaceToAttack = new space(target.getX(), target.getY());
		spaceToRetreat = new space(x, y);
		attacking = false;
	}
	
	// methods
	
	//takes in a red Enemy object and returns the degrees to move toward the Fighter.
	public double calculateDegToAttack() {
		if(target.getX() == this.getX()) {
			return 270;
		}
		double tempX = target.getX()-this.getX();
		double tempY = this.getY()-target.getY();
		double degRads = Math.atan(tempY/tempX);
		double deg = Math.toDegrees(degRads);
		if(deg < 0) {
			deg+=360;
		}
		if(tempX < 0 && tempY < 0) {
			deg+=180;
		}
		//outputs degrees
		System.out.println(deg);
		return deg;
	}
	
	public double calculateDegToRetreat() {
		double newDeg = (degToAttack + 180) % 360;
		System.out.println(newDeg);
		return newDeg;
	}
	
	public void attack() {
		if( ( this.getY() == spaceToRetreat.getY() ) && (attacking == false && retreating == false)) {
			degToAttack = calculateDegToAttack();
			attacking = true;
		}
		if( ( this.getY() >= spaceToAttack.getY() ) && (attacking == true && retreating == false)){
			degToRetreat = calculateDegToRetreat();
			attacking = false;
			retreating = true;
		}
		if( ( this.getY() <= spaceToRetreat.getY() ) && (attacking == false && retreating == true)){
			retreating = false;
		}
		if(attacking == true) {
			redEnemyImage.movePolar(SPEED, degToAttack);
			this.setLocation(redEnemyImage.getX(), redEnemyImage.getY());
		}
		if(retreating == true) {
			redEnemyImage.movePolar(SPEED, degToRetreat);
			this.setLocation(redEnemyImage.getX(), redEnemyImage.getY());
		}
	}
	
	// get  functions
	
	public Fighter getRedTarget() {
		return target;
	}
	
	public double getDegToAttack() {
		return degToAttack;
	}
	
	public double getDegToRetreat() {
		return degToRetreat;
	}
	
	public GImage getRedEnemyImage() {
		return redEnemyImage;
	}
	
	public space getSpaceToAttack() {
		return spaceToReturn;
	}
	
	public space getSpaceRetreat() {
		return spaceToRetreat;
	}
	
	public boolean getAttacking() {
		return attacking;
	}
	
	public boolean getRetreating() {
		return retreating;
	}
	// set functions
	
	public void setRedTarget(Fighter f) {
		target = f;
	}
	
	public void setDegToAttack(double d) {
		degToAttack = d;
	}
	
	public void setDegToRetreat(double d) {
		degToRetreat = d;
	}
	public void setRedEnemyPosition(GImage i) {
		double imageX = i.getX();
		double imageY = i.getY();
		this.setLocation(imageX, imageY);
	}
	
	public void setRedEnemyPosition(double x, double y) {
		this.setLocation(x, y);
		redEnemyImage.setLocation(x, y);
	}
	
	public void setSpaceToAttack(double x, double y) {
		spaceToAttack = new space(x, y);
	}
	
	public void setSpaceToRetreat(double x, double y) {
		spaceToRetreat = new space(x, y);
	}
	
	public void setAttacking(boolean tf) {
		attacking = tf;
	}
	
	public void setRetreating(boolean tf) {
		retreating = tf;
	}
}
