package starter;

import acm.graphics.GImage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

public class Graphics extends GraphicsPane implements ActionListener{
	private MainApplication program;
	
	public static final int PROGRAM_WIDTH = 800;
	public static final int PROGRAM_HEIGHT = 600;
	public static final int ENTITY_WIDTH = 45;
	public static final int ENTITY_HEIGHT = 45;
	public static final int FIGHTER_X = PROGRAM_WIDTH/2-ENTITY_WIDTH/2;
	public static final int FIGHTER_Y = PROGRAM_HEIGHT-ENTITY_HEIGHT*2;
	public static final int RED_ENEMY_X = PROGRAM_WIDTH/2-ENTITY_WIDTH/2;
	public static final int RED_ENEMY_Y = PROGRAM_HEIGHT/2-ENTITY_HEIGHT/2;
	public static final int ENEMY_SPEED = 4;
	public static final int DELAY_MS = 25;
	private static final int LIVES_X = 0;
	private static final int LIVES_Y = 550;
	
	private int numTimes=0;
	
	//to test
	private Red redEnemy;
	private Fighter fighter;
	
//Constructor
	public Graphics(MainApplication app) {
		this.program=app;
		
		fighter = new Fighter(FIGHTER_X, FIGHTER_Y, 3);
		fighter.setSize(ENTITY_WIDTH, ENTITY_HEIGHT);
		fighter.getFighterImage().setSize(ENTITY_WIDTH, ENTITY_HEIGHT);
		
		redEnemy = new Red(RED_ENEMY_X, RED_ENEMY_Y, fighter);
		redEnemy.setSize(ENTITY_WIDTH, ENTITY_HEIGHT);
		redEnemy.getRedEnemyImage().setSize(ENTITY_WIDTH, ENTITY_HEIGHT);
		
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
		int space=5;
		for(GImage life:fighter.getLives()) {
//			life.setSize(ENTITY_WIDTH, ENTITY_HEIGHT);
			life.setLocation(LIVES_X+space, LIVES_Y);
			program.add(life);
			space=ENTITY_WIDTH+space+5;
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
			fighter.shoot();
			for(GImage bullet:fighter.getBullet().getBullets()) {
				program.remove(fighter.getFighterImage());
				program.add(bullet);
				program.add(fighter.getFighterImage());
			}
		}
	}
	
	//Moves the enemy toward the Fighter(temporary)
	public void actionPerformed(ActionEvent e) {
		//TODO: Meant to make the enemy start moving once every 2.5(x) seconds.
		if(numTimes % 2500 == 0) {
			
		}
		
		//redEnemy.getRedEnemyImage().movePolar(4, 0);
//		redEnemy.attack(fighter);
		
		//System.out.println("fighter x: " + fighter.getX() + ", y: " + fighter.getY());
		System.out.println("red enemy x: " + redEnemy.getX() + ", y: " + redEnemy.getY());
		
		
		//tests if the enemy hits the fighter
		if(fighter.intersects(redEnemy)) {
			fighter.setLives(fighter.getLives().size()-1);
			fighter.setFighterPosition(0, 0);
			System.out.print(fighter.getX() +", " + fighter.getY());
			
			//removes fighter from the game
//			fighterHit();
//			fighter.getFighterImage().setVisible(false);
//			fighter.getFighterImage().setLocation(0, 0);
		}
		
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
		if(fighter.isFighterHit()) {
			program.remove(fighter.getFighterImage());
			program.remove(fighter.getLives().get(0));
			fighter.getLives().remove(0);
		}
	}
}
