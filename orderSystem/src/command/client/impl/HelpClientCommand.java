package command.client.impl;

import beans.Client;
import command.ClientCommand;
import command.system.impl.HelpSystemCommand;
import console.Console;

public class HelpClientCommand extends ClientCommand{

	public HelpClientCommand(Client client) {
		super(client);
	}

	@Override
	public void execute() {
		new HelpSystemCommand().execute();
		Console.println("search_all_c: 查看所有客户！");
		Console.println("search_c_by_name: 通过名字搜索客户！");
		Console.println("search_c_by_code:通过客户代码搜索客户！");
		Console.println("add_c:添加一个新的客户！");
		Console.println("update_c:更新一个客户！");
		Console.println("delete_c:删除客户！");
		
		Console.println("search_all_p:查看所有商品信息！");
		Console.println("search_p_by_catalog:按分类查看商品信息！");
		Console.println("search_p_by_name:按商品的名字查看商品信息！");
		Console.println("search_p_by_code:按商品的代号查看商品信息！");
		Console.println("delete_p:删除商品！");
		
		Console.println("search_all_o:查看所有订单！");
		Console.println("search_o_by_client:查看某个客户的订单！");
		Console.println("search_o_by_product:查看包含某个商品的订单！");
		Console.println("search_o_by_order_status:更具商品状态查看订单！");
		Console.println("add_o:新建一个订单!");
		Console.println("update_o:更新一个订单!");
		Console.println("delete_o:删除一个订单!");
	}
	
}
