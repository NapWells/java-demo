package command.system.impl;

import command.SystemCommand;
import console.Console;

public class HelpSystemCommand extends SystemCommand{

	@Override
	public void execute() {
		Console.println("help: �鿴��ǰ�������п������");
		Console.println("exit: �˳�����");
		Console.println("user_login: ���û�����ݵ�½��");
		Console.println("user_singup: �����û�ע�ᣡ");
		Console.println("client_login: �Կͻ�����ݵ�½��");
	}

}
