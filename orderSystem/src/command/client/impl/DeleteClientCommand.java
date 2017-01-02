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
		long clientId = Console.askUserInputInt("��������Ҫɾ���Ŀͻ�ID��");
		Client client = UserDAO.getClientForId(clientId);
		if(client==null){
			Console.println("�����������Ŀͻ�,ɾ��ʧ�ܣ�");
			return ;
		}
		client.setDelete(true);
		if(ClientDAO.upsertCient(client)){
			Console.println("ɾ���ɹ���");
		}else{
			Console.println("ɾ��ʧ�ܣ�");
		}
			
	}

}
