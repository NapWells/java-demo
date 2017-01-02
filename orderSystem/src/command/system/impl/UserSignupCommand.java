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
		String username = Console.askUserInput("�������û���:");
		while(UserDAO.isUsernameExists(username)){
			Console.println("�û����Ѵ��ڣ�");
			username = Console.askUserInput("�������������û���:");
		}
		String password = null;
		while(true){
			password = Console.askUserInput("����������:");
			try {
				ValidatePassword.validatePassword(password);
				break;
			} catch (Exception e) {
				Console.println("�����ʽ����ȷ, " + e.getMessage());
				continue;
			}
		}
		String email = Console.askUserInput("�������������:");
		String phone = Console.askUserInput("��������ĵ绰����:");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhone(phone);
		Application.getInstance().setUserProfile(UserDAO.signup(user));
	}
	
	
	
}
