package command.system.impl;

import command.SystemCommand;

public class ExitCommand extends SystemCommand{

	@Override
	public void execute() {
		System.out.println("�ټ�!");
		System.exit(0);
	}

}
