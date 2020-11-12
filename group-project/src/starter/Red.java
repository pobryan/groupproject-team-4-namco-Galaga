package starter;

import acm.graphics.GImage;

public class Red extends enemy{
	
	Fighter target;
	private double degToMove;
	//add GImage object
	private GImage redEnemyImage;
	private space spaceToTravel, spaceToReturn;
	
	Red(){
		this.setLocation(0, 0);
		degToMove = 0;
		redEnemyImage = new GImage("Red.png", 0, 0);
		redEnemyImage.setLocation(0, 0);
	}
	
	Red(int x, int y, Fighter target, double degToMove){
		this.setLocation(x, y);
		this.target = target;
		//spaceToReturn = start;
		this.degToMove = degToMove;
		redEnemyImage = new GImage("Red.png", x, y);
		spaceToTravel = new space(target.getX(), target.getY());
		spaceToReturn = new space(x, y);
	}
	
	// methods
	
	
	
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
}
