package starter;

import java.awt.Font;

public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final int BUTTON_HEIGHT = 120;
	public static final int BUTTON_WIDTH = 50;
	public static Font titleFont = new Font("Serif", Font.BOLD, 48);
//	public static final String MUSIC_FOLDER = "sounds";
//	private static final String[] SOUND_FILES = { "r2d2.mp3", "somethinlikethis.mp3" };

	private Menu menu;
	private Graphics graphics;
	private GameOver gameOver;
//	private Stage stage;

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		menu = new Menu(this);
		graphics=new Graphics(this);
		gameOver= new GameOver(this);
		switchToGraphics();
	}
	
	public void switchToGraphics() {
		switchToScreen(graphics);
	}

	public void switchToMenu() {
		switchToScreen(menu);
	}
	
	public void switchToGameOver() {
		switchToScreen(gameOver);
	}
	
//	public void switchToNewStage() {
//		switchToScreen(stage);
//	}
}
