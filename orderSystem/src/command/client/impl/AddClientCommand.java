package command.client.impl;

import beans.Client; 
import command.ClientCommand;
import console.Console;
import orderSystemDAO.ClientDAO;
import orderSystemDAO.UserDAO;

public class AddClientCommand extends ClientCommand{

	public AddClientCommand(Client client) {
		super(client);
	}

	@Override
	public void execute() {
		String name = Console.askUserInput("请输入客户名字：");
		if(ClientDAO.isUsernameExists(name)){
			Console.println("客户已存在！");
			return;
		}
		String phone = Console.askUserInput("请输入手机号：");
		long clientTypeId = Console.askUserInputInt("请输入客户类型id:");
		long clientStatusId = Console.askUserInputInt("请输入客户状态id:");
		boolean result = ClientDAO.upsertCient(new Client(-1,name,phone,UserDAO.getClientTypeForId(clientTypeId),UserDAO.getClientStatusForId(clientStatusId)));
		if(result)
			Console.println("成功添加用户！");
		else
			Console.println("添加失败！");
	}
	
	

}
