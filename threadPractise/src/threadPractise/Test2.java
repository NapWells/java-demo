package threadPractise;

public class Test2 {
	public static void main(String [] args){
		SharedCounter sc = new SharedCounter();
		for(int i=0;i<10;i++){
			try {
				Thread t = new Thread(sc);
				t.start();
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
				}
		}
		System.out.println(SharedCounter.getCounter());
	}
}
