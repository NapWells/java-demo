package command.client.impl;

import beans.Client;
import command.ClientCommand;
import console.Console;
import orderSystemDAO.ClientDAO;
import orderSystemDAO.UserDAO;

public class UpdateClientCommand extends ClientCommand{

	public UpdateClientCommand(Client client) {
		super(client);
	}

	@Override
	public void execute() {
		String content = Console.askUserInput("��������Ҫ���ĵ����ݣ��û���/�绰/����/״̬����");
		if(!"�û���|�绰|����|״̬".contains(content)){
			Console.println("���ܽ��иò�����");
			return;
		}
		
		if("�û���".equals(content)){
			String name = Console.askUserInput("�������µ��û�����");
			while(ClientDAO.isUsernameExists(name)){
				name = Console.askUserInput(name + "�ѱ�ռ�ã����������룺");
			}
			client.setName(name);
		}else if("�绰".equals(content)){
			String phone = Console.askUserInput("������绰���룺");
			client.setPhone(phone);
		}else if("����".equals(content)){
			long clientTypeId = Console.askUserInputInt("����������ID��");
			client.setClientType(UserDAO.getClientTypeForId(clientTypeId));
		}else if("״̬".equals(content)){
			long clientStatusId = Console.askUserInputInt("������״̬ID��");
			client.setClientStatus(UserDAO.getClientStatusForId(clientStatusId));
		}
		ClientDAO.upsertCient(client);
	}

}
