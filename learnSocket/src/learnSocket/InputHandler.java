package learnSocket;

import java.io.BufferedReader;
import java.io.IOException;

public class InputHandler extends Thread{
	private BufferedReader reader;
	private ShouldContinue sc;
	public boolean shouldContinue = true;
	public InputHandler(BufferedReader reader,ShouldContinue sc){
		this.reader = reader;
		this.sc = sc;
	}
	public void run(){
		while(shouldContinue){
			try {
				String msg = reader.readLine();
				if("bye".equals(msg)) {
					shouldContinue = false;
					sc.setContinue(false);
				}
				System.out.println("收到消息：" + msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
