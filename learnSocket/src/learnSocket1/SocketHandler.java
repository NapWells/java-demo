package learnSocket1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Random;

public class SocketHandler extends Thread{
	Socket socket;
	BufferedReader input;
	BufferedWriter output;
	public SocketHandler(Socket socket){
		this.socket = socket;
		try {
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run(){
		while(true){
			try {
				String msg = input.readLine();
				System.out.println("client: " + msg);
				if("bye".equals(msg))
					break;
				Random rand = new Random();
				int numLuck = rand.nextInt(100);
				System.out.println("luck number is: " + numLuck);
				output.write(numLuck + "\r");
				output.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
