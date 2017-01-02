package command;

import beans.User;

public abstract class UserCommand implements Command{
	protected User user;

	public UserCommand(User user) {
		this.user = user;
	}
	
}
