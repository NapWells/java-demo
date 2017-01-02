package command;

import beans.Client;

public abstract class ClientCommand implements Command{
	protected Client client;

	public ClientCommand(Client client) {
		this.client = client;
	}
	
}
