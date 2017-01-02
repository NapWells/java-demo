package command.product.impl;

import java.util.List;

import beans.Client;
import beans.Product;
import command.ClientCommand;
import console.Console;
import orderSystemDAO.ProductDAO;

public class SearchProductByCode extends ClientCommand{

	public SearchProductByCode(Client client) {
		super(client);
	}

	@Override
	public void execute() {

		String code = Console.askUserInput("请输入商品的代号：");
		Product product = new Product();
		product.setCode(code);
		List<Product> products = ProductDAO.searchProductByCode(product);
		for(Product p: products){
			Console.println(p);
		}
		
	}

}
