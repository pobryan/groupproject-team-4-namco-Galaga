package starter;

import acm.graphics.GImage;

public class Red extends enemy{
	
	Fighter target;
	private double degToMove;
	//add GImage object
	private GImage redEnemyImage;
	private space spaceToAttack, spaceToRetreat;
	private boolean attacking, retreating;
	
	Red(){
		this.setLocation(0, 0);
		degToMove = 0;
		redEnemyImage = new GImage("Red.png", 0, 0);
		redEnemyImage.setLocation(0, 0);
		attacking = false;
	}
	
	Red(int x, int y, Fighter target){
		degToMove = 0;
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
	public double calculateDegMoveAttack() {
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
		degToMove = deg;
		return deg;
	}
	
	public double calculateDegMoveRetreat() {
		double newDeg = (degToMove + 180) % 360;
		return newDeg;
	}
	
	// get  functions
	
	public Fighter getRedTarget() {
		return target;
	}
	
	public double getDeg() {
		return degToMove;
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
	
	public void setDeg(double d) {
		degToMove = d;
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
