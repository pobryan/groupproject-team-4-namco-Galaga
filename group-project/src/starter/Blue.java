package starter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.ArrayList;
import acm.graphics.GImage;

public class Blue extends enemy implements ActionListener{
	private Timer movement;
	private GImage blueEnemyImage;
	private ArrayList<GImage> blues;
	public static final int MS = 50;
	Blue(){
		this.setLocation(0, 0);
		blueEnemyImage = new GImage("Blue.png", 0, 0);
		blueEnemyImage.setLocation(0, 0);
	}
	
	public GImage getBlueEnemyImage() {
		return blueEnemyImage;
	}
	
	public void setBlueEnemyPosition(GImage i) {
		double imageX = i.getX();
		double imageY = i.getY();
		this.setLocation(imageX, imageY);
	}
	
	public void setBlueEnemyPosition(double x, double y) {
		this.setLocation(x, y);
		blueEnemyImage.setLocation(x, y);
	}
	
	public void runBlue() {
		getBlueEnemyImage();
		move();
		
	}
	
	private void move() {
		for(GImage blue : blues) {
		blue.move(20,0);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
