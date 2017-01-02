package command.system.impl;

import application.Application;
import beans.User;
import command.SystemCommand;
import console.Console;
import orderSystemDAO.UserDAO;

public class UserLoginCommand extends SystemCommand{

	@Override
	public void execute() {
		String username = Console.askUserInput("请输入用户名：");
		if(!UserDAO.isUsernameExists(username)){
			Console.println("用户名不存在！");
			return;
		}
		String password = Console.askUserInput("请输入用密码：");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		user = UserDAO.login(user);
		
		if(user!=null){
			Console.println("欢迎回来，" + user.getUsername());
			Application.getInstance().setUserProfile(user);
			Application.getInstance().setClientProfile(null);
		}
		
		else
			Console.println("登陆失败！密码错误！");
	}

}
