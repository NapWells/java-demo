package threadPractise;

public class SharedCounter implements Runnable{
	private static long counter = 0;
	@Override
	public void run() {
		for(int i = 0; i<10; i++){
			counter++;
		}
	}
	public static long getCounter(){
		return counter;
	}

}
