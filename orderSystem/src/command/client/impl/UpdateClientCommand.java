package command.client.impl;

import beans.Client;
import command.ClientCommand;
import console.Console;
import orderSystemDAO.ClientDAO;
import orderSystemDAO.UserDAO;

public class UpdateClientCommand extends ClientCommand{

	public UpdateClientCommand(Client client) {
		super(client);
	}

	@Override
	public void execute() {
		String content = Console.askUserInput("请输入你要更改的内容（用户名/电话/类型/状态）：");
		if(!"用户名|电话|类型|状态".contains(content)){
			Console.println("不能进行该操作！");
			return;
		}
		
		if("用户名".equals(content)){
			String name = Console.askUserInput("请输入新的用户名：");
			while(ClientDAO.isUsernameExists(name)){
				name = Console.askUserInput(name + "已被占用，请重新输入：");
			}
			client.setName(name);
		}else if("电话".equals(content)){
			String phone = Console.askUserInput("请输入电话号码：");
			client.setPhone(phone);
		}else if("类型".equals(content)){
			long clientTypeId = Console.askUserInputInt("请输入类型ID：");
			client.setClientType(UserDAO.getClientTypeForId(clientTypeId));
		}else if("状态".equals(content)){
			long clientStatusId = Console.askUserInputInt("请输入状态ID：");
			client.setClientStatus(UserDAO.getClientStatusForId(clientStatusId));
		}
		ClientDAO.upsertCient(client);
	}

}
