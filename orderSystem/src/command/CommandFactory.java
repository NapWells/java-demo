package command;

import beans.Client;
import beans.User;

public abstract class CommandFactory {
	
	public static enum CommandCode{
		
		//system
		HELP,
		EXIT,
		USER_LOGIN,
		USER_SIGNUP,
		CLIENT_LOGIN,
		
		//user
		UPDATE_U,
		SEARCH_U,
		
		//client
		HELPS,
		SEARCH_ALL_C,
		SEARCH_C_BY_NAME,
		SEARCH_C_BY_CODE,
		ADD_C,
		UPDATE_C,
		DELETE_C,
		
		//product
		SEARCH_ALL_P,
		SEARCH_P_BY_CATALOG,
		SEARCH_P_BY_NAME,
		SEARCH_P_BY_CODE,
		DELETE_P,
		
		//order
		SEARCH_ALL_O,
		SEARCH_O_BY_CLIENT,
		SEARCH_O_BY_PRODUCT,
		SEARCH_O_BY_ORDER_STATUS,
		ADD_O,
		UPDATE_O,
		DELETE_O
	}
	
	public static CommandFactory getFactory(User user){
		if(user != null)
			return new UserCommandFactory(user);
		return new SystemCommandFactory();
	}
	public static CommandFactory getFactory(Client client){
		if(client != null)
			return new ClientCommandFactory(client);
		return new SystemCommandFactory();
	}
	public abstract Command buildCommand(CommandCode cmd);
}
