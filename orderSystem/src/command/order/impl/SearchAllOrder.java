package command.order.impl;

import java.util.List;

import beans.Client;
import beans.Order;
import command.ClientCommand;
import console.Console;
import orderSystemDAO.OrderDAO;

public class SearchAllOrder extends ClientCommand{

	public SearchAllOrder(Client client) {
		super(client);
	}

	@Override
	public void execute() {
		List<Order> orders = OrderDAO.searchAllOrder();
		for(Order order: orders){
			Console.println(order);
		}
	} 

}
