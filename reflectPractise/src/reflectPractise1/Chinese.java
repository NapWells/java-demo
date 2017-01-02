package reflectPractise1;

public class Chinese extends Person implements Fightable{
	public Chinese(){}
	
	public Chinese(String name, int age) {
		super(name,age);
	}
	public void pingpang(){
		System.out.println("中国人会打乒乓球");
	}
	@Override
	public void fight() {
		System.out.println("中国人会打架");
	}
	
}
