package fuShanEscape;

import java.util.Random;

public class Plane implements Vehicle{
	private Random rand = new Random();
	@Override
	public double speedUp() {
		return 12+rand.nextDouble()*2.7;
	}

}
