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
		String name = Console.askUserInput("������ͻ����֣�");
		if(ClientDAO.isUsernameExists(name)){
			Console.println("�ͻ��Ѵ��ڣ�");
			return;
		}
		String phone = Console.askUserInput("�������ֻ��ţ�");
		long clientTypeId = Console.askUserInputInt("������ͻ�����id:");
		long clientStatusId = Console.askUserInputInt("������ͻ�״̬id:");
		boolean result = ClientDAO.upsertCient(new Client(-1,name,phone,UserDAO.getClientTypeForId(clientTypeId),UserDAO.getClientStatusForId(clientStatusId)));
		if(result)
			Console.println("�ɹ�����û���");
		else
			Console.println("���ʧ�ܣ�");
	}
	
	

}
