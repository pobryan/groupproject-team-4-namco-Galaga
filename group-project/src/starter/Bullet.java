package starter;

import acm.program.GraphicsProgram;

public class Bullet extends GraphicsProgram{
	public static final int SPEED = 2;
	
	private space start;
	
	public space getStart() {
		return start;
	}
	public void setStart(space s) {
		start = s;
	}
}
