package command.client.impl;

import beans.Client;
import command.ClientCommand;
import console.Console;
import orderSystemDAO.ClientDAO;

public class SearchCByNameCommand extends ClientCommand{

	public SearchCByNameCommand(Client client) {
		super(client);
	}

	@Override
	public void execute() {
		String name = Console.askUserInput("������ͻ������֣�");
		Client client = ClientDAO.searchClientByName(name);
		if(client==null){
			Console.println("�����������Ŀͻ���");
			return;
		}
		Console.println(client);
	}
	

}
