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
		long catalogId = Console.askUserInputInt("请输入分类的ID：");
		Catalog catalog = ProductDAO.getCatalogById(catalogId);
		if(catalog == null){
			Console.println("不存在这样的商品！");
			return;
		}
		List<Product> products = ProductDAO.searchProductByCatalog(catalog);
		for(Product p: products){
			Console.println(p);
		}
	}

}
