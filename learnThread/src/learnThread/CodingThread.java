package learnThread;

public class CodingThread {
	public static void main(String[] args){
		Thread print = new Print();
		print.start();
		Thread download = new Thread(new DownLoad());
//		System.out.println("当前线程名字："+Thread.currentThread().getName());
		download.setDaemon(true);
		
		download.start();
		try {
			download.join(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		coding();
		System.out.println("sssssssssssssssssssssssssssss");
		
	}
	public static void coding(){
		for(int i=0; i<100;i++){
			System.out.println("小明正在写"+ i +"行代码");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Print extends Thread{
	public void run(){
		long startTime = System.currentTimeMillis();
		for(int i=0;i<200;i++){
			System.out.println("printing第"+ i +"张纸");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("总共用了"+(endTime-startTime)+"毫秒");
	}
}

class DownLoad implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println("DownLoda第"+ i +"集");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
