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
	
	private int numTimes=0, score=0, invincibleClock = 0;
	private GLabel restart, scoreTotal, SCORE;
	private Timer gameTimer;
	
	private Stage stage;
	
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

		stage = new Stage();
		stage.setUpStage();
		stage.getFighter().setSize(ENTITY_SIZE+1, ENTITY_SIZE);
		stage.getFighter().getFighterImage().setSize(ENTITY_SIZE+1, ENTITY_SIZE);
		
		for(Red it: stage.getRedEnemyList()) {
			it.setSize(ENTITY_SIZE, ENTITY_SIZE);
			it.getRedEnemyImage().setSize(ENTITY_SIZE, ENTITY_SIZE);
			it.getRedEnemyImage().setVisible(true);
		}
		for(Blue it: stage.getBlueEnemyList()) {
			it.setSize(ENTITY_SIZE, ENTITY_SIZE);
			it.getBlueEnemyImage().setSize(ENTITY_SIZE, ENTITY_SIZE);
			it.getBlueEnemyImage().setVisible(true);
		}
		
		//initializes timer
		gameTimer = new Timer(DELAY_MS, this);
	}
	

	@Override
	public void showContents() {
		program.setBackground(Color.black);
		program.add(restart);
		program.add(scoreTotal);
		program.add(SCORE);
		program.add(stage.getFighter().getFighterImage());
		for(Red it: stage.getRedEnemyList()) {
			program.add(it.getRedEnemyImage());
		}
		for(Blue it: stage.getBlueEnemyList()) {
			program.add(it.getBlueEnemyImage());
		}
		int space=5;
		for(GImage life:stage.getFighter().getLives()) {
			life.setLocation(LIVES_X+space, LIVES_Y);
			program.add(life);
			space=ENTITY_SIZE+space+5;
		}
		gameTimer.start();
	}

	@Override
	public void hideContents() {
		program.setScore(score);
		program.removeAll();
		gameTimer.stop();
		
		stage.getFighter().getBullet().removeAllBullets();
		for(Blue it: stage.getBlueEnemyList()) {
			it.getBullet().removeAllBullets();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_SPACE && stage.getFighter().getFighterImage().isVisible()) {
			if(numTimes % 5 == 0) {
				stage.getFighter().shoot(program, this);
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			stage.getFighter().moveRight();
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			stage.getFighter().moveLeft();
		}
		else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			program.switchToMenu();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			stage.getFighter().shoot(program, this);
		}
	}
	
	//Moves the enemy toward the Fighter(temporary)
	public void actionPerformed(ActionEvent e) {
		boolean blueVis = false;
		boolean redVis = false;
		if(!restart.isVisible() && stage.getFighter().getFighterImage().isVisible()) {
			for(Blue it: stage.getBlueEnemyList()) {
				if(it.getBlueEnemyImage().isVisible()) {
					blueVis = true;
				}
			}
			if(blueVis == true) {
				stage.getBoard().blueEnemiesAttack();
				blueVis = false;
			}
			if(!restart.isVisible() && stage.getFighter().getFighterImage().isVisible()) {
				for(Blue it: stage.getBlueEnemyList()) {
					it.shoot(program, this);
				}
			}
			for(Red it: stage.getRedEnemyList()) {
				if(it.getRedEnemyImage().isVisible()) {
					redVis = true;
				}
			}
			if(redVis == true) {
				stage.getBoard().redEnemiesAttack();
				redVis = false;
			}
			fighterHit();
			if(stage.getFighter().isInvincible()) {
				invincibleClock++;
			}
		}
		
		else if(restart.isVisible() && numTimes % 100 == 0) {
			stage.getFighter().getFighterImage().setVisible(true);
			restart.setVisible(false);
		}
		if(invincibleClock % 175 == 0) {
			stage.getFighter().setInvincible(false);
		}
		numTimes++;
		scoreTotal.setLabel(""+score);
		GameOver();
	}
	
	public void GameOver() {
		if(stage.getBoard().getFighter().isLivesEmpty()) {
			program.switchToGameOver();
		}
	}
	
	public void enemyHit() {
		for(Blue it: stage.getBlueEnemyList()) {
			if(!it.getBlueEnemyImage().isVisible()) {
				score+=400;
			}
		}
		for(Red it: stage.getRedEnemyList()) {
			if(!it.getRedEnemyImage().isVisible()) {
				score+=500;
			}
		}
	}
	
	public void bulletHit() {
		program.remove(stage.getFighter().getLives().get(stage.getFighter().getLives().size()-1));
		stage.getFighter().loseLife();
		
		restart.setVisible(true);
		stage.getFighter().setFighterPosition(FIGHTER_X-100, FIGHTER_Y);
	}
	
	public void fighterHit() {
		for(Red it: stage.getRedEnemyList()) {
			if(stage.getFighter().isFighterHit(it) && !stage.getFighter().isInvincible()) {
				stage.getFighter().getFighterImage().setVisible(false);
				program.remove(stage.getFighter().getLives().get(stage.getFighter().getLives().size()-1));
				stage.getFighter().loseLife();
				
				
				restart.setVisible(true);
				stage.getFighter().setFighterPosition(FIGHTER_X-100, FIGHTER_Y);
				stage.getFighter().setInvincible(true);
			}
		}
	}
	
	public Stage getStage() {
		return stage;
	}
}
