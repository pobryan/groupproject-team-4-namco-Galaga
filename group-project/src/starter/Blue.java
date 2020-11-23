package starter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import acm.graphics.GImage;

public class Blue extends enemy {
	public static final int Y_HEIGHT = 20;
	public static final int MIN_X = 20;
	public static final int MAX_X = 780;
	public static final int SPEED = 4;

	private GImage blueEnemyImage;
	private Fighter target;
	private double degToAttack, degToRetreat, degToShoot;
	private space spaceToAttack, spaceToRetreat;
	private boolean attacking, retreating;
	private Bullet shoot;
	private String bulletImage;
	
	
	//constructors
	
	Blue(){
		this.setLocation(0, 0);
		blueEnemyImage = new GImage("Blue.png", 0, 0);
		blueEnemyImage.setLocation(0, 0);
		setDegToAttack(0);
		setDegToRetreat(0);
		setDegToShoot(0);
		setSpaceToAttack(new space(0, 0));
		setSpaceToRetreat(new space(0, 0));
		bulletImage=new String("enemy bullet.png");
		shoot=new Bullet(0,0,4, bulletImage);
	}
	
	Blue(int x, int y, Fighter target){
		this.setLocation(x, y);
		this.setTarget(target);
		blueEnemyImage = new GImage("Blue.png", x, y);
		spaceToRetreat = new space(x, y);
		bulletImage=new String("enemy bullet.png");
		shoot=new Bullet(0,0,4, bulletImage);
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
	}

	//methods
	
	//creates a random angle for the blue enemy to travel
	public double calculateDegToAttack() {
		double randX = Math.random() * (MAX_X - MIN_X + 1) + MIN_X;
		double tempX = randX - this.getX();
		double tempY = this.getY() - Y_HEIGHT;
		double degRads = 0;
		double deg = 0;
		System.out.println("x: " + tempX + " y: " + tempY);
		if(tempX<0) {
			tempX*=-1;
			degRads = Math.atan(tempY/tempX);
			deg = Math.toDegrees(degRads);
			deg = deg + ((90-deg)*2);
		}else {
			degRads = Math.atan(tempY/tempX);
			deg = Math.toDegrees(degRads);
		}
		if(deg < 0) {
			deg+=360;
		}
		System.out.println("degs: " + deg);
		spaceToAttack = new space(randX, Y_HEIGHT);
		return deg;
	}
	
	//calculates the degrees for the blue enemy to return after attacking
	public double calculateDegToRetreat() {
		double newDeg = (degToAttack + 180) % 360;
		System.out.println(newDeg);
		return newDeg;
	}
	
	//TODO: calculates the degrees to shoot a bullet(toward the fighter)
//	public double calculateDegToShoot() {
//		return 0;
//	}
	
	public void attack() {
		if( ( this.getY() == spaceToRetreat.getY() ) && (attacking == false && retreating == false)) {
			degToAttack = calculateDegToAttack();
			attacking = true;
		}
		if(attacking == true) {
			blueEnemyImage.movePolar(SPEED, degToAttack);
			this.setLocation(blueEnemyImage.getX(), blueEnemyImage.getY());	
		}
		if(this.getY() <= spaceToAttack.getY() && (attacking == true && retreating == false) ) {
			retreating = true;
			attacking = false;
			degToRetreat = calculateDegToRetreat();	
		}
		if(retreating == true) {
			blueEnemyImage.movePolar(SPEED, degToRetreat);
			this.setLocation(blueEnemyImage.getX(), blueEnemyImage.getY());
		}
		if(this.getY() >= spaceToRetreat.getY() && (attacking == false && retreating == true)) {
			retreating = false;
			spaceToRetreat = new space(this.getX(), this.getY());
		}
	}
	
	public void shoot(MainApplication program) {
		shoot.addEnemyBullet(this.getX()+(45/2), this.getY()+45, program);
		for(GImage bullet: shoot.getEnemyBullets()) {
			program.add(bullet);
		}
	}
	
//getters
	public Bullet getBullet() {
		return shoot;
	}
	public Fighter getTarget() {
		return target;
	}
	public double getDegToAttack() {
		return degToAttack;
	}
	public double getDegToRetreat() {
		return degToRetreat;
	}
	public double getDegToShoot() {
		return degToShoot;
	}
	public space getSpaceToAttack() {
		return spaceToAttack;
	}
	public space getSpaceToRetreat() {
		return spaceToRetreat;
	}
	public boolean isAttacking() {
		return attacking;
	}
	public boolean isRetreating() {
		return retreating;
	}
	public GImage getBlueEnemyImage() {
		return blueEnemyImage;
	}
	
	//setters 
	public void setTarget(Fighter target) {
		this.target = target;
	}
	public void setDegToAttack(double degToAttack) {
		this.degToAttack = degToAttack;
	}
	public void setDegToRetreat(double degToRetreat) {
		this.degToRetreat = degToRetreat;
	}
	public void setDegToShoot(double degToShoot) {
		this.degToShoot = degToShoot;
	}
	public void setSpaceToAttack(space spaceToAttack) {
		this.spaceToAttack = spaceToAttack;
	}
	public void setSpaceToRetreat(space spaceToRetreat) {
		this.spaceToRetreat = spaceToRetreat;
	}
	public void setAttacking(boolean attacking) {
		this.attacking = attacking;
	}
	public void setRetreating(boolean retreating) {
		this.retreating = retreating;
	}
	public void setBlueEnemyImage(GImage blueEnemyImage) {
		this.blueEnemyImage = blueEnemyImage;
	}
}
