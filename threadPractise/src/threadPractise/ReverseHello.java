package threadPractise;

public class ReverseHello extends Thread{
	public static int n = 51;
	String name;
	public ReverseHello(){
		n--;
	}
	public String toString(){
		return n+"";
	}
	@Override
	public void run() {	
		System.out.println("Hello from Thread "+this+"   "+Thread.currentThread());	
		ReverseHello thread = new ReverseHello();
		thread.start();
		if(this.n==0)
			thread.stop();
		
	}
	
	public static void main(String [] args){
		Thread thread1 = new ReverseHello();
		thread1.start();
	}
	
	
}
