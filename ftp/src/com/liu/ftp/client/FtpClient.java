package com.liu.ftp.client;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

public class FtpClient implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private File file;
	public FtpClient(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "FtpClient [name=" + name + "]";
	}
	
	public static void main(String [] args){
		Socket socket = null;
		ObjectOutputStream oos = null;
		try {
			socket = new Socket("localhost",9999);
			FtpClient client = new FtpClient("刘浩宇");
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(client);
			oos.flush();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(oos != null)
				try {
					oos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			if(socket!=null)
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
