package fuShanEscape;

public class Human extends Actor{
	private int speed;
	public Human(String name) {
		super(name);
		this.speed = 2;
	}
	@Override
	public int go(City city) {
		Vehicle v = AbstractVehicle.getVehicle();
		return (int) (city.getDistance()/(speed+v.speedUp()));
	}


}
