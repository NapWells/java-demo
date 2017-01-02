package command.client.impl;

import beans.Client;
import command.ClientCommand;
import console.Console;
import orderSystemDAO.ClientDAO;
import orderSystemDAO.UserDAO;

public class DeleteClientCommand extends ClientCommand{

	public DeleteClientCommand(Client client) {
		super(client);
	}

	@Override
	public void execute() {
		long clientId = Console.askUserInputInt("请输入你要删除的客户ID：");
		Client client = UserDAO.getClientForId(clientId);
		if(client==null){
			Console.println("不存在这样的客户,删除失败！");
			return ;
		}
		client.setDelete(true);
		if(ClientDAO.upsertCient(client)){
			Console.println("删除成功！");
		}else{
			Console.println("删除失败！");
		}
			
	}

}
