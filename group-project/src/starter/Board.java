package starter;
import java.util.*;

/*checks the fighter stays within the bounds of the board*/

public class Board {
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
}
