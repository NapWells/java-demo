package learnMemeory;

public class MakeMoney {
	public static void main(String [] args){
		double rate = 30;
		double money = 0.0;
		Person zhangsan = new Person("张三",50);
		money = task1(rate);
		money = money+task2(zhangsan);
		System.out.println("张三一共赚了" + money +"元");
	}
	public static double task1(double rate){
		int hour = 5;
		return rate*hour;
	}
	public static double task2(Person person){
		int hour = 6;
		return hour*person.rate;
	}
}
class Person{
	private String name;
	public  double rate;
	public Person(String name,double rate){
		this.name = name;
		this.rate = rate;
	}
}
