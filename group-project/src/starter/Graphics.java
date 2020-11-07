package starter;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Graphics extends GraphicsProgram implements ActionListener{
	public static final int PROGRAM_WIDTH = 800;
	public static final int PROGRAM_HEIGHT = 600;
	public static final int ENEMY_WIDTH = 45;
	public static final int ENEMY_HEIGHT = 45;
	public static final int ENEMY_SPEED = 4;
	public static final int DELAY_MS = 25;
	
	
	private int numTimes;
	
	//to test
	private Red redEnemy = new Red();
	private GImage enemyImage;
	
	private Fighter fighter = new Fighter();
	private GImage fighterImage;
	
	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
	}
	
	//Feel free to change this to test what you need to:
	public void run() {
		numTimes = 0;
		
		//for this to work, you need to remove the 3rd input in the Fighter constructor(p/position).
		fighter = new Fighter(PROGRAM_WIDTH/2-ENEMY_WIDTH/2, PROGRAM_HEIGHT-ENEMY_HEIGHT*2, 3);
		redEnemy = new Red(PROGRAM_WIDTH/2-ENEMY_WIDTH/2, PROGRAM_HEIGHT/2-ENEMY_HEIGHT/2, fighter, 0);
		
		drawFighter(fighter);
		drawEnemy(redEnemy);
		
		redEnemy.setRedTarget(fighter);
		redEnemy.setDeg(calculateDegMove(redEnemy.getRedTarget()));
		
		Timer gameTimer = new Timer(DELAY_MS, this);
		gameTimer.start();
	}
	
	//Moves the enemy toward the Fighter(temporary)
	public void actionPerformed(ActionEvent e) {
		//TODO: Meant to make the enemy start moving once every 2.5(x) seconds.
		if(numTimes % 100 == 0) {
			
		}
		enemyImage.movePolar(ENEMY_SPEED, redEnemy.getDeg());
		
		numTimes++;
	}
	
	//Finds the degrees for the movePolar function
	public double calculateDegMove(Fighter target) {
		int tempX = fighter.getPosition().getX()-redEnemy.getSpace().getX();
		int tempY = redEnemy.getSpace().getY()-fighter.getPosition().getY();
		double degRads = Math.atan(tempY/(double)tempX);
		double deg = Math.toDegrees(degRads);
		if(deg < 0) {
			deg+=360;
		}
		if(tempX < 0 && tempY < 0) {
			deg+=180;
		}
		System.out.println(deg);
		return deg;
	}
	
	//TODO: draws the Galaga background
	public void drawGalagaStars() {
		
	}
	
	public void drawEnemy(enemy e) {
		//if(redEnemy.getEnemyType() == enemyType.RED) { //null-pointer exception
			enemyImage = new GImage("Red.png", e.getSpace().getX(), e.getSpace().getY());
			enemyImage.setSize(ENEMY_WIDTH, ENEMY_HEIGHT);
			add(enemyImage);
		//}
	}
	
	
	//TODO: This function is meant to draw all of the enemies
	public void drawAllEnemies() {
		
	}
	
	public void drawFighter(Fighter f) {
		fighterImage = new GImage("Fighter.png", f.getPosition().getX(), f.getPosition().getY());
		fighterImage .setSize(ENEMY_WIDTH, ENEMY_HEIGHT);
		add(fighterImage);
	}
	
	//TODO: draws "lives" number of fighter images to represent how many lives the user has left.
	public void drawRemainingLives() {
		
	}
	
	//TODO: draws the user's current score in the top left.
	public void drawScore() {
		
	}
}
