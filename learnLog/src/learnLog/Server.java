package learnLog;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Server {
	public static int n = 0;
	public static List<Socket> sockets = new ArrayList<Socket>();
	public static void main(String [] args){
		Logger log = LogManager.getLogger(Server.class.getName());
		try {
			//1创建连接请求
			log.info("server启动中");
			ServerSocket serverSocket = new ServerSocket(6666);
			log.info("server启动成功，等待client连接");
			
			//2侦听连接请求
			while(true){
				Socket socket = serverSocket.accept();
				log.info("client"+(n++)+"已连接");
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
