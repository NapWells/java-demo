package learnSocket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server implements ShouldContinue{
	boolean shouldContinue = true;
	public void start(){
		try {
			//1、启动server
			System.out.println("Server启动中");
			ServerSocket serverSocket = new ServerSocket(7777);
			System.out.println("Server启动成功，等待Client连接");
			//2、侦听连接
			Socket socket = serverSocket.accept();
			System.out.println("Server接受到Client连接");
			
			//3、获得InputStram
			BufferedReader input = new  BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//4、获取OutputStream
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			Scanner sc = new Scanner(System.in);
			String serverMsg;
			InputHandler inputHandler = new InputHandler(input,this);
			inputHandler.start();
		
			while(shouldContinue){
				
				System.out.println("请输入回复：");
				serverMsg = sc.nextLine();
				System.out.println("server:"+serverMsg);
				
				output.write(serverMsg+"\r");
				output.flush();
				
				if("bye".equals(serverMsg))
					shouldContinue = false;
			}
			inputHandler.shouldContinue = false;
			//5关闭资源
			sc.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void setContinue(boolean shouldContinue) {
		this.shouldContinue = shouldContinue;
	}
	public static void main(String [] args){
		Server server = new Server();
		server.start();
	}
}
