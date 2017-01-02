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
		String content = Console.askUserInput("请输入你要更改的内容（用户名/密码/邮箱/电话号码/客户）：");
		if(!"用户名|密码|邮箱|电话号码|客户".contains(content)){
			Console.println("不能进行该操作！");
			return;
		}
		
		if("用户名".equals(content)){
			String username = Console.askUserInput("请输入新的用户名：");
			while(UserDAO.isUsernameExists(username)){
				username = Console.askUserInput(username + "已被占用，请重新输入：");
			}
			user.setUsername(username);
		}else if("密码".equals(content)){
			while(true){
				String password = Console.askUserInput("请输入密码:");
				try {
					ValidatePassword.validatePassword(password);
					user.setPassword(password);
					break;
				} catch (Exception e) {
					Console.println("密码格式不正确, " + e.getMessage());
					continue;
				}
			}
		}else if("邮箱".equals(content)){
			String email = Console.askUserInput("请输入邮箱：");
			user.setEmail(email);
		}else if("电话".equals(content)){
			String phone = Console.askUserInput("请输入电话号码：");
			user.setPhone(phone);
		}else if("客户".equals(content)){
			long clientId = Console.askUserInputInt("请输入客户ID：");
			user.setClient(UserDAO.getClientForId(clientId));
		}
		UserDAO.updateUser(user);
	}

	
}
