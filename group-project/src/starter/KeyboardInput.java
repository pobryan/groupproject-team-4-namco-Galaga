package starter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class KeyboardInput extends JPanel implements ActionListener, KeyListener{
	Bullet b= new Bullet();
	public static final int WINDOW_HEIGHT = 520;
	public static final int WINDOW_WIDTH = 800;
	public static final int WIDTH = 5;
	public static final int HEIGHT = 15;
	public static final int MS = 50;
	
	int x=400,y=520, velx=0,vely=-2;
	private Timer move;
	
	public KeyboardInput() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		move=new Timer(MS,this);
//		move.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2=(Graphics2D) g;
		g.setColor(Color.orange);
		g.fillRect(x, y, WIDTH, HEIGHT);
		setBackground(Color.black);
	}
	
	public void spacebar(int m) {
		repaint();
//		b.addBullet(m);
	}
	
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_SPACE) {
			spacebar(400);
		}
	}

	public void keyReleased(KeyEvent e) {}

	public void keyTyped(KeyEvent e) {}
	
	public void actionPerformed(ActionEvent e) {
		y+=vely;
//		b.moveAllBullets();
//		repaint();
		
	}
	
}