package learnLambda;

@FunctionalInterface
interface Studey{
	void studing();
}
public class LearnLambda4 {
	public static void doSomething(Studey study){
		study.studing();
	}
	public static void main(String [] args){
		doSomething(()->System.out.println("我正在学习lambda"));
	}
}
