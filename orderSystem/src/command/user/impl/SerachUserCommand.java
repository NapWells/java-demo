package command.user.impl;

import beans.User;
import command.UserCommand;
import console.Console;
import orderSystemDAO.UserDAO;

public class SerachUserCommand  extends UserCommand{

	public SerachUserCommand(User user) {
		super(user);
	}

	@Override
	public void execute() {
		String username = Console.askUserInput("������Ҫ���ҵ��û�����");
		User user = UserDAO.searchByUsername(username);
		if(user==null){
			Console.println("�����ڸ��û���");
			return;
		}
		Console.println(user);
	}

}
