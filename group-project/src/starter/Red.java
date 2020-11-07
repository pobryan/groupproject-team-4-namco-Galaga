package starter;

public class Red extends enemy{
	Fighter target;
	private double degToMove;
	
	Red(){
		start.setX(0);
		start.setY(0);
		degToMove = 0;
	}
	
	Red(int x, int y, Fighter target, double degToMove){
		start = new space(x, y);
		this.target = target;
		spaceToReturn = start;
		this.degToMove = degToMove;
	}
	
	/*public void attack() {
		space temp = new space(start.getX(),start.getY());
		move(start, target.getPosition());
		move(start, temp);
	}*/
	
	/*still working on this
	public void moveTowardTarget(int speed) {
		moving = true;
		move(start, target.getPosition());
	}
	
	public void moveBackToStart() {
		moving = true;
		move(start, spaceToReturn);
	}*/
	
	// get/set  functions
	public void setRedTarget(Fighter f) {
		target = f;
	}
	
	public Fighter getRedTarget() {
		return target;
	}
	
	public void setDeg(double d) {
		degToMove = d;
	}
	
	public double getDeg() {
		return degToMove;
	}
}
