package learnLambda;

public class LearnLambda1 {
	public static void main(String [] args){
		for(int i = 0; i<1000; i++)
			new Thread(()->
			System.out.println("I am thread "+Thread.currentThread().getId())).start();
	}
}
