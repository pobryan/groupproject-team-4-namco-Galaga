package starter;

import acm.graphics.GImage;
import acm.graphics.GLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

public class Graphics extends GraphicsPane implements ActionListener{
	private MainApplication program;
	
	public static final int PROGRAM_WIDTH = 800;
	public static final int PROGRAM_HEIGHT = 600;
	public static final int ENTITY_SIZE = 45;
	public static final int FIGHTER_X = PROGRAM_WIDTH/2-ENTITY_SIZE/2;
	public static final int FIGHTER_Y = PROGRAM_HEIGHT-ENTITY_SIZE*2;
	public static final int RED_ENEMY_X = PROGRAM_WIDTH/2-ENTITY_SIZE/2;
	public static final int RED_ENEMY_Y = PROGRAM_HEIGHT/2-ENTITY_SIZE/2;
	public static final int BLUE_ENEMY_X = PROGRAM_WIDTH/2-ENTITY_SIZE/2;
	public static final int BLUE_ENEMY_Y = PROGRAM_HEIGHT/2-100-ENTITY_SIZE/2;
	public static final int ENEMY_SPEED = 4;
	public static final int DELAY_MS = 25;
	private static final int LIVES_X = 0;
	private static final int LIVES_Y = 550;
	
	private int numTimes=0;
	private GLabel restart;
	
	//to test
	private Red redEnemy;
	private Blue blueEnemy;
	private Green greenEnemy;
	private Fighter fighter;
	
//Constructor
	public Graphics(MainApplication app) {
		this.program=app;
		
		restart= new GLabel("READY", PROGRAM_WIDTH/2, PROGRAM_HEIGHT/2);
		restart.setColor(Color.cyan);
		restart.setFont(new Font("Consolas",Font.BOLD, 30));
		
		fighter = new Fighter(FIGHTER_X, FIGHTER_Y, 3);
		fighter.setSize(ENTITY_SIZE, ENTITY_SIZE);
		fighter.getFighterImage().setSize(ENTITY_SIZE, ENTITY_SIZE);
		
		redEnemy = new Red(RED_ENEMY_X, RED_ENEMY_Y, fighter);
		redEnemy.setSize(ENTITY_SIZE, ENTITY_SIZE);
		redEnemy.getRedEnemyImage().setSize(ENTITY_SIZE, ENTITY_SIZE);

		blueEnemy = new Blue(BLUE_ENEMY_X, BLUE_ENEMY_Y, fighter);
		blueEnemy.setSize(ENTITY_SIZE, ENTITY_SIZE);
		blueEnemy.getBlueEnemyImage().setSize(ENTITY_SIZE, ENTITY_SIZE);
		
//		greenEnemy = new Green(BLUE_ENEMY_X, BLUE_ENEMY_Y, fighter);
//		greenEnemy.setSize(ENTITY_SIZE, ENTITY_SIZE);
//		greenEnemy.getGreenEnemyImage().setSize(ENTITY_SIZE, ENTITY_SIZE);
		
		//sets the target and direction for the enemy to travel
		redEnemy.setRedTarget(fighter);
		
		//initializes and starts the timer
		Timer gameTimer = new Timer(DELAY_MS, this);
		gameTimer.start();
	}
	

	@Override
	public void showContents() {
		program.setBackground(Color.black);
		program.add(fighter.getFighterImage());
		program.add(redEnemy.getRedEnemyImage());
		program.add(blueEnemy.getBlueEnemyImage());
		int space=5;
		for(GImage life:fighter.getLives()) {
			life.setLocation(LIVES_X+space, LIVES_Y);
			program.add(life);
			space=ENTITY_SIZE+space+5;
		}
	}

	@Override
	public void hideContents() {
		program.remove(fighter.getFighterImage());
		program.remove(redEnemy.getRedEnemyImage());
		for(GImage life:fighter.getLives()) {
			program.remove(life);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			fighter.shoot(program);
				
			for(int i=0; i<fighter.getBullet().getBullets().size(); i++) {
				program.add(fighter.getBullet().getBullets().get(i));
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			fighter.moveRight();
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			fighter.moveLeft();
		}
	}
	
	//Moves the enemy toward the Fighter(temporary)
	public void actionPerformed(ActionEvent e) {
		//TODO: Meant to make the enemy start moving once every 2.5(x) seconds.
		if(numTimes % 2500 == 0) {
			
		}
		
//		redEnemy.getRedEnemyImage().movePolar(4, 0);
//		redEnemy.attack(fighter);
//		System.out.println("fighter x: " + fighter.getX() + ", y: " + fighter.getY());
//		System.out.println("red enemy x: " + redEnemy.getX() + ", y: " + redEnemy.getY());
		
		blueEnemy.attack();
		if(numTimes % 40 == 0) {
			blueEnemy.shoot(program);
		}
		
		//tests if the enemy hits the fighter and removes fighter
			fighterHit();
			
//			fighter.getFighterImage().setVisible(false);
//			fighter.getFighterImage().setLocation(0, 0);
//		}
		
		if(redEnemy.getY() == fighter.getY()) {
			//build a function 
		}
		numTimes++;
	}
	
	//TODO: draws the Galaga background
	public void drawGalagaStars() {
		
	}
	
	public void drawEnemy(enemy e) {
		
	}
	
	
	//TODO: This function is meant to draw all of the enemies
	public void drawAllEnemies() {
		
	}
	
	//TODO: draws the user's current score in the top left.
	public void drawScore() {
		
	}
	
	public void fighterHit() {
		if(fighter.isFighterHit(redEnemy)) {
			program.remove(fighter.getFighterImage());
			program.remove(fighter.getLives().get(fighter.getLives().size()-1));
			fighter.loseLife();
			
//			if(numTimes % 5 == 0) {
//				ready();
//				program.add(restart);
//			}
//			else if(numTimes % 20 == 0) {
//				fighter.setFighterPosition(FIGHTER_X, FIGHTER_Y);
				fighter.setFighterPosition(50, 50);
				program.add(fighter.getFighterImage());
//			}
//			for(int i=numTimes % 10; numTimes<numTimes % 50;i=numTimes % 10) {
//				program.add(restart);
//			}
		}
	}
}
