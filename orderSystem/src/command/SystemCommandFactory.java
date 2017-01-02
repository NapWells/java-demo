package command;

import java.util.HashMap;
import java.util.Map;

import command.system.impl.ClientLoginCommand;
import command.system.impl.ExitCommand;
import command.system.impl.HelpSystemCommand;
import command.system.impl.UserLoginCommand;
import command.system.impl.UserSignupCommand;

public class SystemCommandFactory extends CommandFactory{
	private static Map<CommandCode,Class<? extends Command>> commandMap = new HashMap<>();
	static{
		commandMap.put(CommandCode.HELP, HelpSystemCommand.class);
		commandMap.put(CommandCode.EXIT, ExitCommand.class);
		commandMap.put(CommandCode.USER_LOGIN, UserLoginCommand.class);
		commandMap.put(CommandCode.USER_SIGNUP, UserSignupCommand.class);
		commandMap.put(CommandCode.CLIENT_LOGIN, ClientLoginCommand.class);
	}
	@Override
	public Command buildCommand(CommandCode cmd) {
		Class<? extends Command> cmdClass = commandMap.get(cmd);
		if(cmdClass !=null){
			try {
				return cmdClass.newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| SecurityException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
