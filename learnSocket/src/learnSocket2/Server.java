package learnSocket2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Server {
	public static List<Socket> sockets = new ArrayList<Socket>();
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
				sockets.add(socket);
				SocketHandler socketHandler = new SocketHandler(socket,sockets);
				socketHandler.start();
				if(sockets.size()==0)
					break;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
