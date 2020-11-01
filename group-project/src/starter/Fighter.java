package starter;

public class Fighter {
	private space position;
	double speed;
	int lives;
	
	Fighter(int x, int y, space p, int l){
		position.setX(x);
		position.setY(y);
		position = p;
		lives = l;
	}
	
	public space getPosition() {
		return position;
	}
	public void setPosition(int x, int y) {
		position.setX(x);
		position.setY(y);
	}
}
