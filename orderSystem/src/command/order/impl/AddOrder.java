package command.order.impl;

import java.sql.Date;

import beans.Client;
import beans.Order;
import beans.OrderStatus;
import command.ClientCommand;
import console.Console;
import orderSystemDAO.OrderDAO;

public class AddOrder extends ClientCommand{

	public AddOrder(Client client) {
		super(client);
	}

	@Override
	public void execute() {
		Date create_datetime = new Date(0);
		String memo = Console.askUserInput("请输入订单的memory：");
		OrderStatus orderStatus = OrderDAO.getOrderStatusById(1);
		Order order = new Order(-1,create_datetime,memo,orderStatus,client);
		boolean result = OrderDAO.upsertOrder(order);
		if(result)
			Console.println("成功创建订单！");
		else
			Console.println("创建订单失败！");
	}

}
