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
		long id = Console.askUserInputInt("������Ҫ�޸ĵĶ�����ID:");
		Order order = OrderDAO.getOrderByID(id);
		String command = Console.askUserInput("��ѡ��Ҫ�޸ĵ����ݣ�����ʱ��/memo/����״̬����");
		if(!"����ʱ��|memo|����״̬".contains(command)){
			Console.println("�������󣬲��ܽ��в�����");
			return;
		}
		
		if("����ʱ��".equals(command)){
			Date create_datetime = Date.valueOf(Console.askUserInput("�������µĴ���ʱ�䣺"));
			order.setCreateDatetime(create_datetime);
		}else if("memo".equalsIgnoreCase(command)){
			String memo = Console.askUserInput("�����붩����memory��");
			order.setMemo(memo);
		}else if("����״̬".equals(command)){
			long statusId = Console.askUserInputInt("�����붩��״̬");
			order.setOrderStatus(OrderDAO.getOrderStatusById(statusId));
		}
		boolean result = OrderDAO.upsertOrder(order);
		if(result)
			Console.println("�������³ɹ���");
		else
			Console.println("����ʧ��");
	}

}
