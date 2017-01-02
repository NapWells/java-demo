package learnSocket3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;


public class SocketHandler extends Thread{
	public static int i = 1;
	List<Socket> sockets;
	public SocketHandler(Socket socket){
		ListClient listClient = ListClient.getInstance();
		listClient.addClient(socket);
		sockets = listClient.getClientList();
		for(Socket socketq:sockets)
			System.out.println(socketq);
		System.out.println("启动了第"+(i++)+"个线程");
	}
	public void run(){
		try {
			if(sockets!=null){
//				while(true){
					for(int i = 0;i<sockets.size();i++){
						BufferedReader input = new BufferedReader(new InputStreamReader(sockets.get(i).getInputStream()));
						String msg = input.readLine();
						if(msg!=null){
							for(int j = 0;j<sockets.size();j++){
								BufferedWriter output = new BufferedWriter(new OutputStreamWriter(sockets.get(i).getOutputStream()));
								output.write(msg+"\r");
								output.flush();
							}
						}
						System.out.println("client: " + msg);
					}
				}
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
