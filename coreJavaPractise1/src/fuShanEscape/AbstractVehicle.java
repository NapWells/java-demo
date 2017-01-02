package fuShanEscape;

import java.util.Random;

public abstract class AbstractVehicle {
	public static Vehicle getVehicle(){
		Random rand = new Random();
		int num =1+rand.nextInt(11);
		if(num==9||num==10)
			return new Plane();
		else if(num>5&&num<8)
			return new Train();
		else
			return new Tuola();
	}
}
