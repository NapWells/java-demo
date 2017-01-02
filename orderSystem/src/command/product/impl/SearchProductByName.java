package command.product.impl;

import java.util.List;

import beans.Client;
import beans.Product;
import command.ClientCommand;
import console.Console;
import orderSystemDAO.ProductDAO;

public class SearchProductByName extends ClientCommand{

	public SearchProductByName(Client client) {
		super(client);
	}

	@Override
	public void execute() {
		String name = Console.askUserInput("��������Ʒ�����֣�");
		Product product = new Product();
		product.setName(name);
		List<Product> products = ProductDAO.searchProductByName(product);
		for(Product p: products){
			Console.println(p);
		}
		
	}
}
