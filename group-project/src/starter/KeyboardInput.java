package starter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class KeyboardInput extends JPanel implements ActionListener, KeyListener{
	Bullet b= new Bullet();
	public static final int WINDOW_HEIGHT = 550;
	public static final int WINDOW_WIDTH = 800;
	public static final int WIDTH = 5;
	public static final int HEIGHT = 15;
	public static final int MS = 50;
	
	int x=400,y=520, velx=0,vely=-2;
	private Timer move= new Timer(MS,this);
	
	Graphics g;
	Graphics2D g2 = (Graphics2D) g;
	ArrayList<Graphics2D> bullets= new ArrayList<Graphics2D>();
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D tempg2 = (Graphics2D) g;
		tempg2.setColor(Color.orange);
		tempg2.fillRect(x, y, WIDTH, HEIGHT);
		setBackground(Color.black);
		move.start();
		bullets.add(tempg2);
	}
	
	public void spacebar() {
		g2.create(x, y, WIDTH, HEIGHT);
		paintComponent(g2);
	}
	
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_SPACE) {
			spacebar();
		}
	}

	public void keyReleased(KeyEvent e) {}

	public void keyTyped(KeyEvent e) {}
	
	public void actionPerformed(ActionEvent e) {
		y+=vely;
		repaint();
	}
	
}