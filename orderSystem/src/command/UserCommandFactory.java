package command;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import beans.User;
import command.user.impl.HelpUserCommand;
import command.user.impl.SerachUserCommand;
import command.user.impl.UpdateUserCommand;

public class UserCommandFactory extends SystemCommandFactory{
	private static Map<CommandCode,Class<? extends Command>> commandMap = new HashMap<>();
	static{
		commandMap.put(CommandCode.UPDATE_U, UpdateUserCommand.class);
		commandMap.put(CommandCode.HELP, HelpUserCommand.class);
		commandMap.put(CommandCode.SEARCH_U, SerachUserCommand.class);
	}
	protected User user;
	public UserCommandFactory(User user) {
		this.user = user;
	}
	
	@Override
	public Command buildCommand(CommandCode cmd) {
		Class<? extends Command> cmdClass = commandMap.get(cmd);
		if(cmdClass!=null){
			try {
				return cmdClass.getConstructor(User.class).newInstance(user);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}
		return super.buildCommand(cmd);
	}


	
}
