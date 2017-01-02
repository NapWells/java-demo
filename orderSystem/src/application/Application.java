package application;

import beans.Client;
import beans.User;
import command.Command;
import command.CommandFactory;
import command.CommandFactory.CommandCode;
import console.Console;

public class Application {

	private User userProfile;
	private Client clientProfile;
	private static Application instance = null;
	public static synchronized Application getInstance(){
		if(instance ==null){
			instance = new Application();
		}
		return instance;
	}
	
	public User getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(User userProfile) {
		this.userProfile = userProfile;
	}
	public Client getClientProfile() {
		return clientProfile;
	}
	public void setClientProfile(Client clientProfile) {
		this.clientProfile = clientProfile;
	}

	public static void main(String [] args){
		Console.println("welecome! you can use 'help' check out all command!");
		while(true){
			String cmd = Console.askUserInput("cmd>");
			CommandCode cmdCode = null;
			try{
				cmdCode = CommandCode.valueOf(cmd.toUpperCase());
				CommandFactory factory = CommandFactory.getFactory((Application.getInstance().getUserProfile()));
				Command command  = factory.buildCommand(cmdCode);
				if(command ==null){
					 factory = CommandFactory.getFactory((Application.getInstance().getClientProfile()));
					 command  = factory.buildCommand(cmdCode);
				}
				command.execute();
			}catch(Exception e){
				Console.println("can't identify your command, pleaseinput 'help' check out all command!");
			}
			
		}
	}

}
