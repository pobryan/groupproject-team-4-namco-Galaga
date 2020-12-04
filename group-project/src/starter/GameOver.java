package starter;

import acm.graphics.GLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

public class GameOver extends GraphicsPane {
	private MainApplication program;
	
	private GLabel gameOver, enter;
	
	public GameOver(MainApplication program) {
		this.program=program;
		
		gameOver= new GLabel("GAME OVER", program.getWidth()/3, program.getHeight()/2);
		gameOver.setColor(Color.red);
		gameOver.setFont(new Font("Consolas",Font.BOLD, 50));
		
		enter= new GLabel("Press Enter to continue", program.getWidth()/3, program.getHeight()/2+60);
		enter.setColor(Color.pink);
		enter.setFont(new Font("Consolas",Font.BOLD, 20));
	}
	
	@Override
	public void showContents() {
		program.setBackground(Color.black);
		program.add(gameOver);
		program.add(enter);
	}

	@Override
	public void hideContents() {
		program.removeAll();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			program.switchToMenu();
			//switch to scores screen when it's made
		}
	}
}