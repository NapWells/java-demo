package com.liu.ftpserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.liu.ftp.client.FtpClient;

public class HandlerClient implements Runnable{
	private Socket socket;
    public HandlerClient(Socket socket){
        this.socket=socket;
    }
    public void run(){
    	ObjectInputStream ois = null;
        try{
            System.out.println("新连接:"+socket.getInetAddress()+":"+socket.getPort());
//            ois = new ObjectInputStream(socket.getInputStream());
//            FtpClient client = (FtpClient) ois.readObject();
//            System.out.println(client);
            Thread.sleep(1000000);
        }catch(Exception e){
        	e.printStackTrace();
        }finally{
            try{
                System.out.println("关闭连接:"+socket.getInetAddress()+":"+socket.getPort());
                if(socket!=null)socket.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
