package command.product.impl;

import java.util.List;

import beans.Catalog;
import beans.Client;
import beans.Product;
import command.ClientCommand;
import console.Console;
import orderSystemDAO.ProductDAO;

public class SearchProductByCatalog extends ClientCommand{

	public SearchProductByCatalog(Client client) {
		super(client);
	}

	@Override
	public void execute() {
		long catalogId = Console.askUserInputInt("����������ID��");
		Catalog catalog = ProductDAO.getCatalogById(catalogId);
		if(catalog == null){
			Console.println("��������������Ʒ��");
			return;
		}
		List<Product> products = ProductDAO.searchProductByCatalog(catalog);
		for(Product p: products){
			Console.println(p);
		}
	}

}
