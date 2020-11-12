package starter;

public class space {
	private double x;
	private double y;
	
	space(){
		x = 0;
		y = 0;
	}
	
	public space(double newX, double newY) {
		x = newX;
		y = newY;
	}
	
	public void setX(double newX) {
		x = newX;
	}
	
	public void setY(double newY) {
		y = newY;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
}
