package learnThread;

public class CommunicationThread {
	public static void main(String [] args){
		Box box = new Box();
		Thread productor = new Productor(box);
		Thread consume = new Consume(box);
		productor.start();
		consume.start();
	}
}
class Box{
	public int value = 0;
}
class Productor extends Thread{
	private Box box;
	public Productor(Box box){
		this.box = box;
	}
	public void run(){
		for(int i=1;i<6;i++){
			synchronized(box){
				while(box.value!=0){
					try {
						System.out.println("Produtor:box已满，进入等待队列");
						box.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				box.value = i;
				System.out.println("Productor:box放入"+i+"并通知其他等待者");
				box.notify();
			}
			
		}
	}
}
class Consume extends Thread{
	private Box box;
	public Consume(Box box){
		this.box = box;
	}
	public void run(){
		for(int i=1;i<6;i++){
			synchronized(box){
				while(box.value==0){
					try {
						System.out.println("Consume:box为空，进入等待队列");
						box.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				box.value = 0;
				System.out.println("Consume:box取出了"+i+"，并通知其他等待着");
				box.notify();
			}
		}
	}
}
