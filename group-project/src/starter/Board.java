package starter;
import java.util.ArrayList;

/*checks the fighter stays within the bounds of the board*/

public class Board {
	public static final int PROGRAM_WIDTH = 800;
	public static final int PROGRAM_HEIGHT = 600;
	public static final int ENTITY_SIZE = 45;
	public static final int FIGHTER_X = PROGRAM_WIDTH/2-ENTITY_SIZE/2;
	public static final int FIGHTER_Y = PROGRAM_HEIGHT-ENTITY_SIZE*2;
	private Fighter fighter;
	private ArrayList<Red> redEnemyList;
	private ArrayList<Blue> blueEnemyList;
	
	public Board() {
		fighter = new Fighter();
		redEnemyList = new ArrayList<Red>();
		blueEnemyList = new ArrayList<Blue>();
	}
	//methods
	public void addFighterToBoard() {
		Fighter fighterToAdd = new Fighter(FIGHTER_X, FIGHTER_Y, 3);
		fighter = fighterToAdd;
		fighter.getFighterImage().setLocation(fighter.getX(), fighter.getY());
	}
	public void addRedEnemyToBoard(int x, int y) {
		Red enemyToAdd = new Red(x, y, fighter);
		enemyToAdd.getRedEnemyImage().setLocation(x, y);
		redEnemyList.add(enemyToAdd);
	}
	public void addBlueEnemyToBoard(int x, int y) {
		Blue enemyToAdd = new Blue(x, y, fighter);
		enemyToAdd.getBlueEnemyImage().setLocation(x, y);
		blueEnemyList.add(enemyToAdd);
	}
	
	public void removeRedEnemyFromBoard(Red e) {
		redEnemyList.remove(e);
	}
	public void removeBlueEnemyFromBoard(Blue e) {
		blueEnemyList.remove(e);
	}
	public void redEnemiesAttack() {
		for(Red it: redEnemyList) {
			it.attack();
		}
	}
	public void blueEnemiesAttack() {
		for(Blue it: blueEnemyList) {
			it.attack();
		}
	}
	
	public Fighter getFighter() {
		return fighter;
	}
	public ArrayList<Blue> getBlueEnemyList(){
		return blueEnemyList;
	}
	public ArrayList<Red> getRedEnemyList(){
		return redEnemyList;
	}
	
	public void setupEnemyFormation() {
		
	}
	
	public boolean hit() {
		return false;
	}
}
