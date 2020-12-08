package starter;

import java.util.ArrayList;

public class Stage {
	public static final int PROGRAM_WIDTH = 800;
	public static final int PROGRAM_HEIGHT = 600;
	public static final int ENTITY_SIZE = 45;
	public static final int FIGHTER_X = PROGRAM_WIDTH/2-ENTITY_SIZE/2;
	public static final int FIGHTER_Y = PROGRAM_HEIGHT-ENTITY_SIZE*2;
	public static final int RED_ENEMY_X = PROGRAM_WIDTH/2-ENTITY_SIZE/2;
	public static final int RED_ENEMY_Y = PROGRAM_HEIGHT/2-ENTITY_SIZE/2;
	public static final int BLUE_ENEMY_X = PROGRAM_WIDTH/2-ENTITY_SIZE/2;
	public static final int BLUE_ENEMY_Y = PROGRAM_HEIGHT/2-100-ENTITY_SIZE/2;
	
	private Board board;
	private Scores scores;
	
	Stage(){
		board = new Board();
		
	}
	
	public void setUpStage() {
		board.addFighterToBoard();
		board.addRedEnemyToBoard(RED_ENEMY_X-ENTITY_SIZE-10, RED_ENEMY_Y);
		board.addRedEnemyToBoard(RED_ENEMY_X, RED_ENEMY_Y);
		board.addRedEnemyToBoard(RED_ENEMY_X+ENTITY_SIZE+10, RED_ENEMY_Y);
		board.addBlueEnemyToBoard(BLUE_ENEMY_X-ENTITY_SIZE-10, BLUE_ENEMY_Y);
		board.addBlueEnemyToBoard(BLUE_ENEMY_X, BLUE_ENEMY_Y);
		board.addBlueEnemyToBoard(BLUE_ENEMY_X+ENTITY_SIZE+10, BLUE_ENEMY_Y);
	}
	public void removeRedEnemyFromStage(Red e) {
		board.removeRedEnemyFromBoard(e);
	}
	public void removeBlueEnemyFromStage(Blue e) {
		board.removeBlueEnemyFromBoard(e);
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
}
