package starter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

import acm.graphics.GLabel;

public class Stage extends GraphicsPane implements ActionListener{
	public static final int PROGRAM_WIDTH = 800;
	public static final int PROGRAM_HEIGHT = 600;
	public static final int ENTITY_SIZE = 45;
	public static final int FIGHTER_X = PROGRAM_WIDTH/2-ENTITY_SIZE/2;
	public static final int FIGHTER_Y = PROGRAM_HEIGHT-ENTITY_SIZE*2;
	public static final int RED_ENEMY_X = PROGRAM_WIDTH/2-ENTITY_SIZE/2;
	public static final int RED_ENEMY_Y = PROGRAM_HEIGHT/2-ENTITY_SIZE/2;
	public static final int BLUE_ENEMY_X = PROGRAM_WIDTH/2-ENTITY_SIZE/2;
	public static final int BLUE_ENEMY_Y = PROGRAM_HEIGHT/2-100-ENTITY_SIZE/2;
	public static final int DELAY_MS = 25;
	
	private Board board;
	private Scores scores;
	private MainApplication program;
	private Timer stageTimer;
	private int numTimes;
	
	Stage(MainApplication m){
		board = new Board();
		program = m;
		stageTimer = new Timer(DELAY_MS, this);
	}
	
	public void setUpStage(int i) {
		board.addFighterToBoard(i);
		board.addRedEnemyToBoard(RED_ENEMY_X-ENTITY_SIZE-200, RED_ENEMY_Y);
		board.addRedEnemyToBoard(RED_ENEMY_X, RED_ENEMY_Y);
		board.addRedEnemyToBoard(RED_ENEMY_X+ENTITY_SIZE+200, RED_ENEMY_Y);
		board.addBlueEnemyToBoard(BLUE_ENEMY_X-ENTITY_SIZE-10, BLUE_ENEMY_Y);
		board.addBlueEnemyToBoard(BLUE_ENEMY_X, BLUE_ENEMY_Y);
		board.addBlueEnemyToBoard(BLUE_ENEMY_X+ENTITY_SIZE+10, BLUE_ENEMY_Y);
		
		for(Red it: board.getRedEnemyList()) {
			it.setSize(ENTITY_SIZE, ENTITY_SIZE);
			it.getRedEnemyImage().setSize(ENTITY_SIZE, ENTITY_SIZE);
			it.getRedEnemyImage().setVisible(true);
		}
		for(Blue it: board.getBlueEnemyList()) {
			it.setSize(ENTITY_SIZE, ENTITY_SIZE);
			it.getBlueEnemyImage().setSize(ENTITY_SIZE, ENTITY_SIZE);
			it.getBlueEnemyImage().setVisible(true);
		}
	}
	public void removeRedEnemyFromStage(Red e) {
		board.removeRedEnemyFromBoard(e);
	}
	public void removeBlueEnemyFromStage(Blue e) {
		board.removeBlueEnemyFromBoard(e);
	}
	
	public boolean isStagePassed() {
		if(board.getRedEnemyList().size() + board.getBlueEnemyList().size() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public enemy getEnemyLocation() {
		return null;
	}
	
	public Fighter getFighterLocation() {
		return null;
	}
	
	public ArrayList<enemy> getEnemiesonBoard() {
		return null;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public Fighter getFighter() {
		return board.getFighter();
	}
	
	public ArrayList<Red> getRedEnemyList() {
		return board.getRedEnemyList();
	}
	
	public ArrayList<Blue> getBlueEnemyList() {
		return board.getBlueEnemyList();
	}
	
	public boolean isEnemyDead() {
		return false;
	}
	
	public boolean passedStage() {
		return false;
	}
	
	public void GameOver() {
		
	}

	@Override
	public void showContents() {
		// TODO Auto-generated method stub
		GLabel newStage = new GLabel("New Stage", -50 + PROGRAM_WIDTH/2, PROGRAM_HEIGHT/2);
		newStage.setColor(Color.white);
		newStage.setFont(new Font("Consolas",Font.BOLD, 30));
		program.add(newStage);
		stageTimer.start();
	}

	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		program.removeAll();
		stageTimer.stop();
		numTimes = 0;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(numTimes == 50) {
			program.switchToGraphics();
		}
		
		
		numTimes++;
	}
}
