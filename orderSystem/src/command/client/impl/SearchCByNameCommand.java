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
		String name = Console.askUserInput("请输入客户的名字：");
		Client client = ClientDAO.searchClientByName(name);
		if(client==null){
			Console.println("不存在这样的客户！");
			return;
		}
		Console.println(client);
	}
	

}
