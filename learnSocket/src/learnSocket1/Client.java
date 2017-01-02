package learnSocket1;

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
			//1、建立Socket连接
			System.out.println("尝试建立连接");
			Socket socket = new Socket("localhost",6666);
			System.out.println("连接成功");
			//2、获得InputStream
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//3、获取OutputStream
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//4、写数据
			Scanner sc = new Scanner(System.in);
			String clientMsg;
			
			while(true){
				clientMsg = sc.nextLine();
				System.out.println("client:" + clientMsg);
				if("bye".equals(clientMsg))
						break;
				output.write(clientMsg+"\r");
				output.flush();
				String serverMsg = input.readLine();
				System.out.println("setver:"+serverMsg);
				
			}
			sc.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
