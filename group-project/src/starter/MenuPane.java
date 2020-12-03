package starter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GRect;

public class MenuPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GButton rect;
	
	private GButton playGame = new GButton("Play", 280, 180, MainApplication.BUTTON_HEIGHT,
			MainApplication.BUTTON_WIDTH, Color.green);
	/*in MainApplication.java:
	public static final int BUTTON_HEIGHT = 120;
	public static final int BUTTON_WIDTH = 50;
	public static Font titleFont = new Font("Serif", Font.BOLD, 48);*/
	private GRect textBox = new GRect(233, 583, 233, 100);
	private GLabel titleLabel = new GLabel("Galaga", 150, 87.5);
	

	public MenuPane(MainApplication app) {
		super();
		program = app;
		rect = new GButton("Next", 200, 200, 200, 200);
		rect.setFillColor(Color.RED);
		playGame.setFillColor(Color.YELLOW);
		//
		
		titleLabel.setFont(MainApplication.titleFont);
		textBox.setFillColor(Color.YELLOW);
		textBox.setFilled(true);
		
	}

	@Override
	public void showContents() {
		program.add(rect);
		program.add(textBox);
		program.add(titleLabel);
		program.add(playGame);
	}

	@Override
	public void hideContents() {
		program.remove(rect);
		program.add(textBox);
		program.add(titleLabel);
		program.add(playGame);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == rect) {
//			program.switchToSome();
		}
	}
	
	
}
