package command;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import beans.Client;
import command.client.impl.AddClientCommand;
import command.client.impl.DeleteClientCommand;
import command.client.impl.HelpClientCommand;
import command.client.impl.SearchAllCCommand;
import command.client.impl.SearchCByCodeCommand;
import command.client.impl.SearchCByNameCommand;
import command.client.impl.UpdateClientCommand;
import command.order.impl.AddOrder;
import command.order.impl.DeleteOrder;
import command.order.impl.SearchAllOrder;
import command.order.impl.SearchOrderByClient;
import command.order.impl.SearchOrderByOrderStatus;
import command.order.impl.SearchOrderByProduct;
import command.order.impl.UpdateOrder;
import command.product.impl.DeleteProduct;
import command.product.impl.SearchAllProduct;
import command.product.impl.SearchProductByCatalog;
import command.product.impl.SearchProductByCode;
import command.product.impl.SearchProductByName;

public class ClientCommandFactory extends SystemCommandFactory{
	
	private static Map<CommandCode,Class<? extends ClientCommand>> commandMap = new HashMap<>();
	static{
		commandMap.put(CommandCode.SEARCH_ALL_C, SearchAllCCommand.class);
		commandMap.put(CommandCode.HELPS,HelpClientCommand.class);
		commandMap.put(CommandCode.SEARCH_C_BY_NAME, SearchCByNameCommand.class);
		commandMap.put(CommandCode.SEARCH_C_BY_CODE, SearchCByCodeCommand.class);
		commandMap.put(CommandCode.ADD_C, AddClientCommand.class);
		commandMap.put(CommandCode.UPDATE_C, UpdateClientCommand.class);
		commandMap.put(CommandCode.DELETE_C, DeleteClientCommand.class);
		
		commandMap.put(CommandCode.SEARCH_ALL_P, SearchAllProduct.class);
		commandMap.put(CommandCode.SEARCH_P_BY_CATALOG, SearchProductByCatalog.class);
		commandMap.put(CommandCode.SEARCH_P_BY_NAME, SearchProductByName.class);
		commandMap.put(CommandCode.SEARCH_P_BY_CODE, SearchProductByCode.class);
		commandMap.put(CommandCode.DELETE_P, DeleteProduct.class);
		
		commandMap.put(CommandCode.SEARCH_ALL_O, SearchAllOrder.class);
		commandMap.put(CommandCode.SEARCH_O_BY_CLIENT, SearchOrderByClient.class);
		commandMap.put(CommandCode.SEARCH_O_BY_PRODUCT, SearchOrderByProduct.class);
		commandMap.put(CommandCode.SEARCH_O_BY_ORDER_STATUS, SearchOrderByOrderStatus.class);
		commandMap.put(CommandCode.ADD_O, AddOrder.class);
		commandMap.put(CommandCode.UPDATE_O, UpdateOrder.class);
		commandMap.put(CommandCode.DELETE_O, DeleteOrder.class);
	}
	
	private Client client;
	public ClientCommandFactory(Client client) {
		this.client = client;
	}

	@Override
	public Command buildCommand(CommandCode cmd) {
		Class<? extends Command> cmdClass = commandMap.get(cmd);
		if(cmdClass !=null){
			try {
				return cmdClass.getConstructor(Client.class).newInstance(client);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}
		return super.buildCommand(cmd);
	}
	
	

}
