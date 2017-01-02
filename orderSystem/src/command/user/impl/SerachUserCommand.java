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
		String username = Console.askUserInput("请输入要查找的用户名：");
		User user = UserDAO.searchByUsername(username);
		if(user==null){
			Console.println("不存在该用户！");
			return;
		}
		Console.println(user);
	}

}
