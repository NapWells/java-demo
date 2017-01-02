package command.order.impl;

import java.util.List;

import beans.Client;
import beans.Order;
import beans.OrderStatus;
import command.ClientCommand;
import console.Console;
import orderSystemDAO.OrderDAO;

public class SearchOrderByOrderStatus extends ClientCommand{

	public SearchOrderByOrderStatus(Client client) {
		super(client);
	}

	@Override
	public void execute() {
		long orderStatusId = Console.askUserInputInt("«Î ‰»Î∂©µ•◊¥Ã¨ID£∫");
		OrderStatus orderStatus = OrderDAO.getOrderStatusById(orderStatusId);
		List<Order> orders = OrderDAO.getOrdersByStatus(orderStatus);
		for(Order order:orders){
			Console.println(order);
		}
	}

}
