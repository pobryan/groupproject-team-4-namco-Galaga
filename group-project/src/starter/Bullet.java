package starter;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;
import javax.swing.*;

public class Bullet extends GraphicsProgram{
	public static final int WINDOW_HEIGHT = 600;
	public static final int WINDOW_WIDTH = 800;
	public static final int WIDTH = 5;
	public static final int HEIGHT = 15;
	public static final int MS = 50;
	public static final int SPEED=-4;
	
	private space start= new space(400,  WINDOW_HEIGHT-10);
	private double speed;
	private GRect bullet;
	private ArrayList<GRect> bullets=new ArrayList<GRect>();
	ActionListener listen;
	private Timer movement;
	
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
	
	//methods
	public GRect makeBullet(double x, double y) {
		GRect tempBullet = new GRect(x, WINDOW_HEIGHT-10,WIDTH, HEIGHT);
		tempBullet.setColor(Color.ORANGE);
		tempBullet.setFilled(true);
		return tempBullet;
	}
	
	public void addBullet(int x) {
		bullet= makeBullet(x, HEIGHT);
		add(bullet);
		bullets.add(bullet);
	}
	
	public void moveAllBullets() {
		for(GRect bullet:bullets) {
			bullet.move(0,SPEED);
		}
	}
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	
	private void keyInput() {
		JFrame frame= new JFrame();
		KeyboardInput k= new KeyboardInput();
		frame.setBackground(Color.black);
		frame.add(k);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
				
	}
	
	//event methods
	public void actionPerformed(ActionEvent e) {
		moveAllBullets();
	}
	
//	public void mousePressed(MouseEvent e) {
//		addBullet(e.getX());
//		setStart(e.getX(), WINDOW_HEIGHT-10);
//	}
	
	//test code
	public void run() {
		bullets= new ArrayList<GRect>();
		movement=new Timer(MS,this);
		movement.start();
		
//		addMouseListeners();
		keyInput();
	}
}

