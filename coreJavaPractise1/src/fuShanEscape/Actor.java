package fuShanEscape;

public abstract class Actor {
	private String name;
	private int speed;
	
	public Actor(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSpace() {
		return speed;
	}
	public void setSpace(int speed) {
		this.speed = speed;
	}

	public abstract int go(City city);
	
	
	
}
