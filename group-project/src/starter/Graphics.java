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
	//private Red redEnemy;
	//private Blue blueEnemy;
	private Green greenEnemy;
	private Stage stage;
	//private Fighter fighter;
	
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
		
//		fighter = new Fighter(FIGHTER_X, FIGHTER_Y, 3);
//		fighter.setSize(ENTITY_SIZE+1, ENTITY_SIZE);
//		fighter.getFighterImage().setSize(ENTITY_SIZE+1, ENTITY_SIZE);
//		fighter.getFighterImage().setVisible(true);
		
//		redEnemy = new Red(RED_ENEMY_X, RED_ENEMY_Y, fighter);
//		redEnemy.setSize(ENTITY_SIZE, ENTITY_SIZE);
//		redEnemy.getRedEnemyImage().setSize(ENTITY_SIZE, ENTITY_SIZE);
//		redEnemy.getRedEnemyImage().setVisible(true);

//		blueEnemy = new Blue(BLUE_ENEMY_X, BLUE_ENEMY_Y, fighter);
//		blueEnemy.setSize(ENTITY_SIZE, ENTITY_SIZE);
//		blueEnemy.getBlueEnemyImage().setSize(ENTITY_SIZE, ENTITY_SIZE);
//		blueEnemy.getBlueEnemyImage().setVisible(true);
		
//		greenEnemy = new Green(BLUE_ENEMY_X, BLUE_ENEMY_Y, fighter);
//		greenEnemy.setSize(ENTITY_SIZE, ENTITY_SIZE);
//		greenEnemy.getGreenEnemyImage().setSize(ENTITY_SIZE, ENTITY_SIZE);
		
		//sets the target and direction for the enemy to travel
//		redEnemy.setRedTarget(fighter);
		stage = new Stage();
		stage.setUpStage();
		stage.getBoard().getFighter().setSize(ENTITY_SIZE+1, ENTITY_SIZE);
		stage.getBoard().getFighter().getFighterImage().setSize(ENTITY_SIZE+1, ENTITY_SIZE);
		
		for(Red it: stage.getBoard().getRedEnemyList()) {
			it.setSize(ENTITY_SIZE, ENTITY_SIZE);
			it.getRedEnemyImage().setSize(ENTITY_SIZE, ENTITY_SIZE);
			it.getRedEnemyImage().setVisible(true);
		}
		for(Blue it: stage.getBoard().getBlueEnemyList()) {
			it.setSize(ENTITY_SIZE, ENTITY_SIZE);
			it.getBlueEnemyImage().setSize(ENTITY_SIZE, ENTITY_SIZE);
			it.getBlueEnemyImage().setVisible(true);
		}
		
		
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
		program.add(stage.getBoard().getFighter().getFighterImage());
		for(Red it: stage.getBoard().getRedEnemyList()) {
			program.add(it.getRedEnemyImage());
		}
		for(Blue it: stage.getBoard().getBlueEnemyList()) {
			program.add(it.getBlueEnemyImage());
		}
		int space=5;
		for(GImage life:stage.getBoard().getFighter().getLives()) {
			life.setLocation(LIVES_X+space, LIVES_Y);
			program.add(life);
			space=ENTITY_SIZE+space+5;
		}
	}

	@Override
	public void hideContents() {
		program.removeAll();
		gameTimer.stop();
		
		stage.getBoard().getFighter().getBullet().removeAllBullets();
//		blueEnemy.getBullet().removeAllBullets();
		for(Blue it: stage.getBoard().getBlueEnemyList()) {
			it.getBullet().removeAllBullets();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_SPACE && stage.getBoard().getFighter().getFighterImage().isVisible()) {
			stage.getBoard().getFighter().shoot(program, this);
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			stage.getBoard().getFighter().moveRight();
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			stage.getBoard().getFighter().moveLeft();
		}
		else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			program.switchToMenu();
		}
	}
	
	//Moves the enemy toward the Fighter(temporary)
	public void actionPerformed(ActionEvent e) {
		boolean blueVis = false;
		boolean redVis = false;
		if(!restart.isVisible() && stage.getBoard().getFighter().getFighterImage().isVisible()) {
			for(Blue it: stage.getBoard().getBlueEnemyList()) {
				if(it.getBlueEnemyImage().isVisible()) {
					blueVis = true;
					//blueEnemy.shoot(program, this);
					it.shoot(program, this);
				}
			}
			if(blueVis == true) {
				stage.getBoard().blueEnemiesAttack();
				blueVis = false;
			}
			for(Blue it: stage.getBoard().getBlueEnemyList()) {
				it.shoot(program, this);
			}
			for(Red it: stage.getBoard().getRedEnemyList()) {
				if(it.getRedEnemyImage().isVisible()) {
					//redEnemy.setRedTarget(fighter);
					redVis = true;
				}
			}
			if(redVis == true) {
				stage.getBoard().redEnemiesAttack();
				redVis = false;
			}
			fighterHit();
		}
		
		else if(restart.isVisible() && numTimes % 100 == 0) {
			stage.getBoard().getFighter().getFighterImage().setVisible(true);
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
		for(Blue it: stage.getBoard().getBlueEnemyList()) {
			if(!it.getBlueEnemyImage().isVisible()) {
				score+=400;
			}
		}
		for(Red it: stage.getBoard().getRedEnemyList()) {
			if(!it.getRedEnemyImage().isVisible()) {
				score+=500;
			}
		}
	}
	
	public void bulletHit() {
		program.remove(stage.getBoard().getFighter().getLives().get(stage.getBoard().getFighter().getLives().size()-1));
		stage.getBoard().getFighter().loseLife();
		
		restart.setVisible(true);
		stage.getBoard().getFighter().setFighterPosition(FIGHTER_X-100, FIGHTER_Y);
	}
	
	public void fighterHit() {
		for(Red it: stage.getBoard().getRedEnemyList()) {
			if(stage.getBoard().getFighter().isFighterHit(it)) {
				stage.getBoard().getFighter().getFighterImage().setVisible(false);
				program.remove(stage.getBoard().getFighter().getLives().get(stage.getBoard().getFighter().getLives().size()-1));
				stage.getBoard().getFighter().loseLife();
				
				
				restart.setVisible(true);
				stage.getBoard().getFighter().setFighterPosition(FIGHTER_X-100, FIGHTER_Y);
			}
		}
	}
}
