package command.client.impl;

import java.util.List;

import beans.Client;
import command.ClientCommand;
import console.Console;
import orderSystemDAO.ClientDAO;

public class SearchAllCCommand extends ClientCommand{
	
	public SearchAllCCommand(Client client) {
		super(client);
	}

	@Override
	public void execute() {
		List<Client> clients = ClientDAO.searchAllClients();
		for(Client c : clients)
			Console.println(c);
	}

}
