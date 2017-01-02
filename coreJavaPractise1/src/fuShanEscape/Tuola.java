package fuShanEscape;

import java.util.Random;

public class Tuola implements Vehicle{
	private Random rand = new Random();
	@Override
	public double speedUp() {
		return 3+rand.nextDouble()*5.5;
	}

}
