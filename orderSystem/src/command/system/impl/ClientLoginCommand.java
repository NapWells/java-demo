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
		String username = Console.askUserInput("������ͻ��˺�����");
		if(!ClientDAO.isUsernameExists(username)){
			Console.println("�û��������ڣ�");
			return;
		}
		
		String password = Console.askUserInput("�����������룺");
		IdentifierClient id = new IdentifierClient(username,password);
		Client client = ClientDAO.login(id);
		
		if(client!=null){
			Console.println("��ӭ������" + client.getName());
			Application.getInstance().setClientProfile(client);
			Application.getInstance().setUserProfile(null);
		}
		
		else
			Console.println("��½ʧ�ܣ��������");
	}

}
