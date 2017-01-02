package learnSocket2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketHandler extends Thread{
	Socket socket;
	List<Socket> clientSockets;
	BufferedReader input;
	public SocketHandler(Socket socket, List<Socket> clientSocket) {
		this.socket = socket;
		this.clientSockets = clientSocket;
		try {
			input = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		while(socket.isConnected()){
			try {
				
				String msg = input.readLine();
				if(msg!=null){
					for(int i = 0;i<clientSockets.size();i++){
						if(!clientSockets.get(i).isConnected()){
							clientSockets.remove(i);
						}
						else {
							BufferedWriter output = new BufferedWriter(new OutputStreamWriter(clientSockets.get(i).getOutputStream()));
							output.write(clientSockets.get(i).getInetAddress()+":"+msg+"\r");
							output.flush();
						}
					}
					System.out.println("客户端收到来自"+socket.getInetAddress()+"的消息: "+msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("----------------------------");
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.stop();
	}
}
