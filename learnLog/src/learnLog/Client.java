package learnLog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		try {
			System.out.println("尝试建立连接");
			Socket socket = new Socket("localhost",6666);
			System.out.println("连接成功");
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			Scanner sc = new Scanner(System.in);
			String clientMsg;
			while(socket.isConnected()){
				System.out.println("请输入聊天消息：");
				clientMsg = sc.nextLine();
				output.write(clientMsg+"\r");
				output.flush();
				if("bye".equals(clientMsg))
					break;
				Thread client = new ClientMsg(socket);
				client.setDaemon(true);
				client.start();
			}
			sc.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
class ClientMsg extends Thread{
	BufferedReader input;
	public Socket socket;
	public ClientMsg(Socket socket){
		this.socket = socket;
		try {
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run(){
		while(socket.isConnected()){
			try {
				String msg = input.readLine();
				System.out.println("收到用户"+socket.getInetAddress()+"的消息"+msg);
				if("bye".equals(msg)){
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
