package command.client.impl;

import java.util.List;

import beans.Client;
import command.ClientCommand;
import console.Console;
import orderSystemDAO.ClientDAO;

public class SearchCByCodeCommand extends ClientCommand{

	public SearchCByCodeCommand(Client client) {
		super(client);
	}

	@Override
	public void execute() {
		String code = Console.askUserInput("请输入客户的代码：");
		List<Client> clients = ClientDAO.searchClientByCode(code);
		if(clients.size()==0){
			Console.println("不存在这样的客户！");
			return;
		}
		for(Client client : clients)
			Console.println(client);
	}

}
