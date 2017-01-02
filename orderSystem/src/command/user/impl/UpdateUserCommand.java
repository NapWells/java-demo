package command.user.impl;

import beans.User;
import command.UserCommand;
import console.Console;
import orderSystemDAO.UserDAO;
import validateCheck.ValidatePassword;

public class UpdateUserCommand extends UserCommand{

	public UpdateUserCommand(User user) {
		super(user);
	}

	@Override
	public void execute() {
		String content = Console.askUserInput("��������Ҫ���ĵ����ݣ��û���/����/����/�绰����/�ͻ�����");
		if(!"�û���|����|����|�绰����|�ͻ�".contains(content)){
			Console.println("���ܽ��иò�����");
			return;
		}
		
		if("�û���".equals(content)){
			String username = Console.askUserInput("�������µ��û�����");
			while(UserDAO.isUsernameExists(username)){
				username = Console.askUserInput(username + "�ѱ�ռ�ã����������룺");
			}
			user.setUsername(username);
		}else if("����".equals(content)){
			while(true){
				String password = Console.askUserInput("����������:");
				try {
					ValidatePassword.validatePassword(password);
					user.setPassword(password);
					break;
				} catch (Exception e) {
					Console.println("�����ʽ����ȷ, " + e.getMessage());
					continue;
				}
			}
		}else if("����".equals(content)){
			String email = Console.askUserInput("���������䣺");
			user.setEmail(email);
		}else if("�绰".equals(content)){
			String phone = Console.askUserInput("������绰���룺");
			user.setPhone(phone);
		}else if("�ͻ�".equals(content)){
			long clientId = Console.askUserInputInt("������ͻ�ID��");
			user.setClient(UserDAO.getClientForId(clientId));
		}
		UserDAO.updateUser(user);
	}

	
}
