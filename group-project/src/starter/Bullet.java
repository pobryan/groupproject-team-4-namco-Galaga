package starter;

import java.awt.Color;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Bullet extends GraphicsProgram{
	public static final int WIDTH = 5;
	public static final int HEIGHT = 15;
	
	private space start;
	private double speed;
	private GRect bullet;
	
	public GRect makeBullet(double x, double y) {
		GRect tempBullet = new GRect(x-WIDTH/2, y-HEIGHT/2, WIDTH, HEIGHT);
		tempBullet.setColor(Color.ORANGE);
		tempBullet.setFilled(true);
		return tempBullet;
	}
	
	//getters
	public space getStart() {
		return start;
	}
	public double getSpeed() {
		return speed;
	}
	
	//setters
	public void setStart(int x, int y) {
		start.setX(x);
		start.setY(x);
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
}
