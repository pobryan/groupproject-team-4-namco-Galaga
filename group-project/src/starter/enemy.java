package starter;

public class enemy {
	private enemyType eType;
	private space start;
	double speed;
	
	enemy(int x, int y, double speed, enemyType type) {
		start.setX(x);
		start.setY(y);
		this.speed=speed;
		eType=type;
	}
	
	//TODO: Finish this method. This method should check if the enemy was hit.
	public boolean isEnemyDead(){
		return true;
	}
	
	//TODO: Finish this method. It needs to use Bullet to fire at Fighter.
	public void shoot() {
		
	}
	
	public void move(space s1, space s2) {
		int difX=s1.getX()-s2.getX();
		int difY=s1.getY()-s2.getY();
		
		start.setX(start.getX()+difX);
		start.setY(start.getY()+difY);
	}
	
	public space getSpace() {
		return start;
	}
	
	public void setSpace(int x, int y) {
		start.setX(x);
		start.setY(y);
	}
}
