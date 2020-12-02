package starter;
public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
//	public static final String MUSIC_FOLDER = "sounds";
//	private static final String[] SOUND_FILES = { "r2d2.mp3", "somethinlikethis.mp3" };

	private Menu menu;
	private Graphics graphics;
//	private Stage stage;

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		menu = new Menu(this);
		graphics=new Graphics(this);
		switchToGraphics();
	}
	
	public void switchToGraphics() {
		switchToScreen(graphics);
	}

	public void switchToMenu() {
		switchToScreen(menu);
	}
	
//	public void switchToNewStage() {
//		switchToScreen(stage);
//	}
}
