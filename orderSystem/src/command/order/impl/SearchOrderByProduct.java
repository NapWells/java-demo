package command.order.impl;

import java.util.ArrayList;
import java.util.List;

import beans.Client;
import beans.Order;
import beans.OrderItem;
import beans.Product;
import command.ClientCommand;
import console.Console;
import orderSystemDAO.OrderDAO;
import orderSystemDAO.ProductDAO;

public class SearchOrderByProduct extends ClientCommand{

	public SearchOrderByProduct(Client client) {
		super(client);
	}

	@Override
	public void execute() {
		long productId = Console.askUserInputInt("请输入产品的ID：");
		Product product = ProductDAO.getProductById(productId);
		if(product==null){
			Console.println("不存在这样的商品");
			return;
		}
		List<Order> orders = new ArrayList<>();
		for(OrderItem oi : OrderDAO.getOrderItemByProduct(productId))
			orders.add(oi.getOrder());
		
		for(Order order:orders)
			Console.println(order);
	}

}
