package starter;

public class Fighter {
	private space position;
	double speed;
	int lives;
	Bullet shoot;
	
	//Getters
	public int getLives() {
		return lives;
	}
	
	public space getPosition() {
		return position;
	}
	
	//Setters
	public void setPosition(int x, int y) {
		position.setX(x);
		position.setY(y);
	}
	
	//Constructors
	Fighter(){
		position = new space(0, 0);
		lives = 3;
	}
	
	Fighter(int x, int y, /*space p,*/ int l){
		position = new space(x, y);
		//position = p;
		lives = l;
	}
	
	//Methods
	public void addLife() {
		lives++;
	}
	
	public void loseLife() {
		lives--;
	}
	
	public boolean isLivesEmpty() {
		if(lives==-1) {
			return true;
		}
		return false;
	}
	
	public boolean isFighterHit() {
		return true;
	}
	
	public void shoot() {
		
	}
	
	public void moveLeft() {
		
	}
	
	public void moveRight() {
		
	}
	
	
}
