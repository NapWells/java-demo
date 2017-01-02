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
		Console.println("search_all_c: �鿴���пͻ���");
		Console.println("search_c_by_name: ͨ�����������ͻ���");
		Console.println("search_c_by_code:ͨ���ͻ����������ͻ���");
		Console.println("add_c:���һ���µĿͻ���");
		Console.println("update_c:����һ���ͻ���");
		Console.println("delete_c:ɾ���ͻ���");
		
		Console.println("search_all_p:�鿴������Ʒ��Ϣ��");
		Console.println("search_p_by_catalog:������鿴��Ʒ��Ϣ��");
		Console.println("search_p_by_name:����Ʒ�����ֲ鿴��Ʒ��Ϣ��");
		Console.println("search_p_by_code:����Ʒ�Ĵ��Ų鿴��Ʒ��Ϣ��");
		Console.println("delete_p:ɾ����Ʒ��");
		
		Console.println("search_all_o:�鿴���ж�����");
		Console.println("search_o_by_client:�鿴ĳ���ͻ��Ķ�����");
		Console.println("search_o_by_product:�鿴����ĳ����Ʒ�Ķ�����");
		Console.println("search_o_by_order_status:������Ʒ״̬�鿴������");
		Console.println("add_o:�½�һ������!");
		Console.println("update_o:����һ������!");
		Console.println("delete_o:ɾ��һ������!");
	}
	
}
