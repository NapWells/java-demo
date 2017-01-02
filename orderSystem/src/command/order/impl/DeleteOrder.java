package command.order.impl;

import beans.Client;
import beans.Order;
import command.ClientCommand;
import console.Console;
import orderSystemDAO.OrderDAO;

public class DeleteOrder extends ClientCommand{

	public DeleteOrder(Client client) {
		super(client);
	}

	@Override
	public void execute() {
		long id = Console.askUserInputInt("������Ҫɾ���Ķ���ID��");
		Order order = OrderDAO.getOrderByID(id);
		order.setDelete(true);
		boolean result = OrderDAO.upsertOrder(order);
		if(result)
			Console.println("����ɾ���ɹ���");
		else
			Console.println("����ɾ��ʧ�ܣ�");
	}

}
