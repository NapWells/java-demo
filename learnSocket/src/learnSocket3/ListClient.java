package learnSocket3;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ListClient {
	private	static List<Socket> sockets = new ArrayList<Socket>();
	private static ListClient listClient;
	private ListClient(){}
	public static ListClient getInstance(){
		if(listClient!=null)
			return listClient;
		return new ListClient();
	}
	public void addClient(Socket  socket){
		sockets.add(socket);
	}
	public List<Socket> getClientList(){
		return sockets;
	}

}
