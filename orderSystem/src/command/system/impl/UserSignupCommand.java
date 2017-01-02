package command.system.impl;

import application.Application;
import beans.User;
import command.SystemCommand;
import console.Console;
import orderSystemDAO.UserDAO;
import validateCheck.ValidatePassword;

public class UserSignupCommand extends SystemCommand{

	@Override
	public void execute() {
		String username = Console.askUserInput("请输入用户名:");
		while(UserDAO.isUsernameExists(username)){
			Console.println("用户名已存在！");
			username = Console.askUserInput("请重新输入用用户名:");
		}
		String password = null;
		while(true){
			password = Console.askUserInput("请输入密码:");
			try {
				ValidatePassword.validatePassword(password);
				break;
			} catch (Exception e) {
				Console.println("密码格式不正确, " + e.getMessage());
				continue;
			}
		}
		String email = Console.askUserInput("请输入你的邮箱:");
		String phone = Console.askUserInput("请输入你的电话号码:");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhone(phone);
		Application.getInstance().setUserProfile(UserDAO.signup(user));
	}
	
	
	
}
