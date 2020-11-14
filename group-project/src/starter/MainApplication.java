package starter;
public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
//	public static final String MUSIC_FOLDER = "sounds";
//	private static final String[] SOUND_FILES = { "r2d2.mp3", "somethinlikethis.mp3" };

	private MenuPane menu;
	private Graphics graphics;

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		menu = new MenuPane(this);
		graphics=new Graphics(this);
		switchToGraphics();
	}
	
	public void switchToGraphics() {
		switchToScreen(graphics);
	}

	public void switchToMenu() {
		switchToScreen(menu);
	}
}
