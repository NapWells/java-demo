package command.order.impl;

import java.sql.Date;

import beans.Client;
import beans.Order;
import command.ClientCommand;
import console.Console;
import orderSystemDAO.OrderDAO;

public class UpdateOrder extends ClientCommand{

	public UpdateOrder(Client client) {
		super(client);
	}

	@Override
	public void execute() {
		long id = Console.askUserInputInt("请输入要修改的订单的ID:");
		Order order = OrderDAO.getOrderByID(id);
		String command = Console.askUserInput("请选择要修改的内容（创建时间/memo/订单状态）：");
		if(!"创建时间|memo|订单状态".contains(command)){
			Console.println("输入有误，不能进行操作！");
			return;
		}
		
		if("创建时间".equals(command)){
			Date create_datetime = Date.valueOf(Console.askUserInput("请输入新的创建时间："));
			order.setCreateDatetime(create_datetime);
		}else if("memo".equalsIgnoreCase(command)){
			String memo = Console.askUserInput("请输入订单的memory：");
			order.setMemo(memo);
		}else if("订单状态".equals(command)){
			long statusId = Console.askUserInputInt("请输入订单状态");
			order.setOrderStatus(OrderDAO.getOrderStatusById(statusId));
		}
		boolean result = OrderDAO.upsertOrder(order);
		if(result)
			Console.println("订单跟新成功！");
		else
			Console.println("更新失败");
	}

}
