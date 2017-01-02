package fuShanEscape;

import java.util.Random;

public class Train implements Vehicle{
	private Random rand = new Random();
	@Override
	public double speedUp() {
		return 8+rand.nextDouble()*4.3;
	}

}
