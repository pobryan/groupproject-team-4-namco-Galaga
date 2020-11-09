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
	public static final int FIGHTER_X = PROGRAM_WIDTH/2-ENEMY_WIDTH/2;
	public static final int FIGHTER_Y = PROGRAM_HEIGHT-ENEMY_HEIGHT*2;
	public static final int RED_ENEMY_X = PROGRAM_WIDTH/2-ENEMY_WIDTH/2;
	public static final int RED_ENEMY_Y = PROGRAM_HEIGHT/2-ENEMY_HEIGHT/2;
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
		
		fighter = new Fighter(3);
		fighter.setLocation(FIGHTER_X+200, FIGHTER_Y);
		redEnemy = new Red(fighter, 0);
		redEnemy.setLocation(RED_ENEMY_X, RED_ENEMY_Y);
		
		//draws the fighter and enemy
		drawFighter(fighter);
		drawEnemy(redEnemy);
		
		//sets the target and direction for the enemy to travel
		redEnemy.setRedTarget(fighter);
		redEnemy.setDeg(calculateDegMove(redEnemy.getRedTarget()));
		
		//initializes and starts the timer
		Timer gameTimer = new Timer(DELAY_MS, this);
		gameTimer.start();
	}
	
	//Moves the enemy toward the Fighter(temporary)
	public void actionPerformed(ActionEvent e) {
		//TODO: Meant to make the enemy start moving once every 2.5(x) seconds.
		if(numTimes % 100 == 0) {
			
		}
		
		fighter.setLocation(fighterImage.getX(), fighterImage.getY());
		
		//moves enemy toward player
		enemyImage.movePolar(ENEMY_SPEED, redEnemy.getDeg());
		
		//tests if the enemy hits the fighter
		if(redEnemy.intersects(fighter)) {
			fighter.setLives(fighter.getLives()-1);
			fighter.setLocation(0, 0);
			
			//removes fighter from the game
			fighterImage.setVisible(false);
			fighterImage.setLocation(0, 0);
		}
		if(redEnemy.getY() == fighter.getY()) {
			//build a function 
		}
		numTimes++;
	}
	
	//Finds the degrees for the movePolar function
	public double calculateDegMove(Fighter target) {
		double tempX = fighter.getX()-redEnemy.getX();
		double tempY = redEnemy.getY()-fighter.getY();
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
	
	//TODO: draws the Galaga background
	public void drawGalagaStars() {
		
	}
	
	public void drawEnemy(enemy e) {
		//if(redEnemy.getEnemyType() == enemyType.RED) { //null-pointer exception
			enemyImage = new GImage("Red.png", e.getX(), e.getY());
			enemyImage.setSize(ENEMY_WIDTH, ENEMY_HEIGHT);
			add(enemyImage);
		//}
	}
	
	
	//TODO: This function is meant to draw all of the enemies
	public void drawAllEnemies() {
		
	}
	
	public void drawFighter(Fighter f) {
		fighterImage = new GImage("Fighter.png", f.getX(), f.getY());
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
