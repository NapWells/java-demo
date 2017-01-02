package com.liu.ftpserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.liu.ftp.client.FtpClient;

public class FTPServer {
	public static ArrayList<Socket> socketList = new ArrayList<Socket>();
	

	public static void main(String [] args){
		System.out.println("service启动中...");
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(9999);
//			Thread.sleep(2000);
			System.out.println("service启动成功");
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
		
		while(true){
	        try{
	        	Socket socket=serverSocket.accept();   
	            System.out.println("client链接");
	            socketList.add(socket);
	            Thread workThread=new Thread(new HandlerClient(socket));
	            workThread.start();
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
	    }
	}
}
