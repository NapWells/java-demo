package learnSocket4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	public static void main(String [] args){
		try {
			//1创建连接请求
			System.out.println("server启动中");
			ServerSocket serverSocket = new ServerSocket(6666);
			System.out.println("server启动成功，等待client连接");
			
			//2侦听连接请求
			while(true){
				Socket socket = serverSocket.accept();
				System.out.println("client已连接");
				SocketHandler socketHandler = new SocketHandler(socket);
				socketHandler.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
