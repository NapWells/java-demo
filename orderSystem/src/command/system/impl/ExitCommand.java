package command.system.impl;

import command.SystemCommand;

public class ExitCommand extends SystemCommand{

	@Override
	public void execute() {
		System.out.println("ты╪Ш!");
		System.exit(0);
	}

}
