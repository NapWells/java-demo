package command.order.impl;

import java.util.List;

import beans.Client;
import beans.Order;
import command.ClientCommand;
import console.Console;
import orderSystemDAO.ClientDAO;
import orderSystemDAO.OrderDAO;

public class SearchOrderByClient extends ClientCommand{

	public SearchOrderByClient(Client client) {
		super(client);
	}

	@Override
	public void execute() {
		long clientId = Console.askUserInputInt("请输入要搜索的用户ID:");
		Client client = ClientDAO.getClientById(clientId);
		if(client==null){
			Console.println("要查找的用户不存在！");
			return;
		}
		List<Order> orders = OrderDAO.searchOrderByClient(client);
		for(Order order:orders){
			Console.println(order);
		}
	}
	

}
