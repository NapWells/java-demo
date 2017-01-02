package command.user.impl;

import beans.User;
import command.UserCommand;
import command.system.impl.HelpSystemCommand;
import console.Console;

public class HelpUserCommand extends UserCommand{

	public HelpUserCommand(User user) {
		super(user);
	}

	@Override
	public void execute() {
		new HelpSystemCommand().execute();
		Console.println("update_u: 更新当前用户信息！");
		Console.println("search_u:查找用户！");
	}

}
