package starter;
import java.util.ArrayList;

/*checks the fighter stays within the bounds of the board*/

public class Board {
	public static final int WINDOW_HEIGHT = 600;
	public static final int WINDOW_WIDTH = 800;
	private Fighter fighter;
	private enemy enemy;
	private ArrayList<enemy> enemyList;
	
	Fighter[][] grid;
	private int numRows;
	private int numCols;
	
	public Board(int rows, int cols) {
		numCols = cols;
		numRows = rows;
		grid = new Fighter[rows][cols];
	}
	public int getNumCols() {
		return numCols;
	}
	public int getNumRows() {
		return numRows;
	}
	
	public void setupEnemyFormation() {
		
	}
	
	public ArrayList<enemy> getEnnemiesOnBoard() {
		return enemyList;
	}
	
	public boolean hit() {
		return false;
	}
}
