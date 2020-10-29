package starter;

public enum enemyType {
	RED, GREEN, BLUE;
	
	public String toString() {
		switch(this) {
			case RED: return "red";
			case GREEN: return "green";
			case BLUE: return "blue";
		}
		return "n/a";
	}
}
