package command.system.impl;

import command.SystemCommand;
import console.Console;

public class HelpSystemCommand extends SystemCommand{

	@Override
	public void execute() {
		Console.println("help: 查看当前环境所有可用命令！");
		Console.println("exit: 退出程序！");
		Console.println("user_login: 以用户的身份登陆！");
		Console.println("user_singup: 进行用户注册！");
		Console.println("client_login: 以客户的身份登陆！");
	}

}
