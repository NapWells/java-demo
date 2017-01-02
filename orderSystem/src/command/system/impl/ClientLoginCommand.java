package command.system.impl;

import application.Application;
import beans.Client;
import beans.IdentifierClient;
import command.SystemCommand;
import console.Console;
import orderSystemDAO.ClientDAO;

public class ClientLoginCommand extends SystemCommand{

	@Override
	public void execute() {
		String username = Console.askUserInput("请输入客户账号名：");
		if(!ClientDAO.isUsernameExists(username)){
			Console.println("用户名不存在！");
			return;
		}
		
		String password = Console.askUserInput("请输入用密码：");
		IdentifierClient id = new IdentifierClient(username,password);
		Client client = ClientDAO.login(id);
		
		if(client!=null){
			Console.println("欢迎回来，" + client.getName());
			Application.getInstance().setClientProfile(client);
			Application.getInstance().setUserProfile(null);
		}
		
		else
			Console.println("登陆失败！密码错误！");
	}

}
