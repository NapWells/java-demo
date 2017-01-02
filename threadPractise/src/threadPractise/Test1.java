package threadPractise;

public class Test1 {
	public static void main(String [] args){
		Thread thread1 = new ReverseHello();
		thread1.start();
	}
}
