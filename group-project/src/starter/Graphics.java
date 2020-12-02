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
	
	private int numTimes=0, score=0;
	private GLabel restart, scoreTotal, SCORE;
	private Timer gameTimer;
	
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
		restart.setVisible(false);
		
		scoreTotal= new GLabel(""+score, 20,30);
		scoreTotal.setColor(Color.cyan);
		scoreTotal.setFont(new Font("Consolas",Font.PLAIN, 20));
		
		SCORE= new GLabel("SCORE", 10, 15);
		SCORE.setColor(Color.cyan);
		SCORE.setFont(new Font("Consolas",Font.PLAIN, 15));
		
		fighter = new Fighter(FIGHTER_X, FIGHTER_Y, 3);
//		fighter.setSize(ENTITY_SIZE+1, ENTITY_SIZE);
		fighter.getFighterImage().setSize(ENTITY_SIZE+1, ENTITY_SIZE);
		fighter.getFighterImage().setVisible(true);
		
		redEnemy = new Red(RED_ENEMY_X, RED_ENEMY_Y, fighter);
//		redEnemy.setSize(ENTITY_SIZE, ENTITY_SIZE);
		redEnemy.getRedEnemyImage().setSize(ENTITY_SIZE, ENTITY_SIZE);
		redEnemy.getRedEnemyImage().setVisible(true);

		blueEnemy = new Blue(BLUE_ENEMY_X, BLUE_ENEMY_Y, fighter);
//		blueEnemy.setSize(ENTITY_SIZE, ENTITY_SIZE);
		blueEnemy.getBlueEnemyImage().setSize(ENTITY_SIZE, ENTITY_SIZE);
		blueEnemy.getBlueEnemyImage().setVisible(true);
		
//		greenEnemy = new Green(BLUE_ENEMY_X, BLUE_ENEMY_Y, fighter);
//		greenEnemy.setSize(ENTITY_SIZE, ENTITY_SIZE);
//		greenEnemy.getGreenEnemyImage().setSize(ENTITY_SIZE, ENTITY_SIZE);
		
		//sets the target and direction for the enemy to travel
		redEnemy.setRedTarget(fighter);
		
		//initializes and starts the timer
		gameTimer = new Timer(DELAY_MS, this);
		gameTimer.start();
	}
	

	@Override
	public void showContents() {
		program.setBackground(Color.black);
		program.add(restart);
		program.add(scoreTotal);
		program.add(SCORE);
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
		program.removeAll();
		gameTimer.stop();
		
		fighter.getBullet().removeAllBullets();
		blueEnemy.getBullet().removeAllBullets();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_SPACE && fighter.getFighterImage().isVisible()) {
			fighter.shoot(program, this);
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			fighter.moveRight();
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			fighter.moveLeft();
		}
		else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			program.switchToMenu();
		}
	}
	
	//Moves the enemy toward the Fighter(temporary)
	public void actionPerformed(ActionEvent e) {
		if(!restart.isVisible() && fighter.getFighterImage().isVisible()) {
				if(blueEnemy.getBlueEnemyImage().isVisible()) {
					blueEnemy.attack();
					blueEnemy.shoot(program, this);
				}
				if(redEnemy.getRedEnemyImage().isVisible()) {
					redEnemy.setRedTarget(fighter);
					redEnemy.attack(fighter);
				}
			fighterHit();
		}
		
		else if(restart.isVisible() && numTimes % 100 == 0) {
			fighter.getFighterImage().setVisible(true);
			restart.setVisible(false);
		}
		numTimes++;
		scoreTotal.setLabel(""+score);
	}
	
	//TODO: draws the Galaga background
	public void drawGalagaStars() {
		
	}
	
	public void drawEnemy() {
		
	}
	
	
	//TODO: This function is meant to draw all of the enemies
	public void drawAllEnemies() {
		
	}
	
	//TODO: draws the user's current score in the top left.
	public void drawScore() {
		
	}
	
	public void enemyHit() {
		if(!blueEnemy.getBlueEnemyImage().isVisible()) {
			score+=400;
		}
		else if(!redEnemy.getRedEnemyImage().isVisible()) {
			score+=500;
		}
	}
	
	public void bulletHit() {
		program.remove(fighter.getLives().get(fighter.getLives().size()-1));
		fighter.loseLife();
		
		restart.setVisible(true);
		fighter.setFighterPosition(FIGHTER_X-100, FIGHTER_Y);
	}
	
	public void fighterHit() {
		if(fighter.isFighterHit(redEnemy)) {
			fighter.getFighterImage().setVisible(false);
			program.remove(fighter.getLives().get(fighter.getLives().size()-1));
			fighter.loseLife();
			
			restart.setVisible(true);
			fighter.setFighterPosition(FIGHTER_X-100, FIGHTER_Y);
		}
	}
}
