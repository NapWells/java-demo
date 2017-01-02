package fuShanEscape;

import java.util.Random;

public class DeadWalker extends Actor{
	private Random  rand = new Random();
	private int speed;
	public DeadWalker(String name) {
		super(name);
		this.speed = (int) (3+rand.nextDouble()*5.5);
	}
	@Override
	public int go(City city) {
		return (int) (city.getDistance()/speed);
	}

}
