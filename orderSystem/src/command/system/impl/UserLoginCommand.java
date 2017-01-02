package command.system.impl;

import application.Application;
import beans.User;
import command.SystemCommand;
import console.Console;
import orderSystemDAO.UserDAO;

public class UserLoginCommand extends SystemCommand{

	@Override
	public void execute() {
		String username = Console.askUserInput("�������û�����");
		if(!UserDAO.isUsernameExists(username)){
			Console.println("�û��������ڣ�");
			return;
		}
		String password = Console.askUserInput("�����������룺");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		user = UserDAO.login(user);
		
		if(user!=null){
			Console.println("��ӭ������" + user.getUsername());
			Application.getInstance().setUserProfile(user);
			Application.getInstance().setClientProfile(null);
		}
		
		else
			Console.println("��½ʧ�ܣ��������");
	}

}
