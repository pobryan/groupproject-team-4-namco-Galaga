package starter;

import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.*; 

public class Scores {
	private Scores newScore;
	
	public static void main(String[] args)throws Exception {
		
		File fileName = new File("");
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		//still figuring out reading in and editing files in java
	}
	
	public Scores getScore() {
		return newScore;
	}
	
	public void setScore() {
		
	}

	public void displayScores(Graphics text) {
		text.drawString("sample text", 100, 200);
	}
	
	public void keyPressed(KeyEvent e) { 
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_ESCAPE) {
	       
	      }
	}
	
}
