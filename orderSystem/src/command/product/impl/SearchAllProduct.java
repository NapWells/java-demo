package command.product.impl;

import java.util.List;

import beans.Client;
import beans.Product;
import command.ClientCommand;
import console.Console;
import orderSystemDAO.ProductDAO;

public class SearchAllProduct extends ClientCommand{

	public SearchAllProduct(Client client) {
		super(client);
	}

	@Override
	public void execute() {
		List<Product> products = ProductDAO.searchAllProduct();
		for(Product p: products){
			Console.println(p);
		}
	}

}
