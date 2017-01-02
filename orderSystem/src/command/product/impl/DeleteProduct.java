package command.product.impl;

import beans.Client;
import beans.Product;
import command.ClientCommand;
import console.Console;
import orderSystemDAO.ProductDAO;

public class DeleteProduct extends ClientCommand{

	public DeleteProduct(Client client) {
		super(client);
	}

	@Override
	public void execute() {
		long id = Console.askUserInputInt("请输入要删除的商品的ID：");
		Product product = ProductDAO.getProductById(id);
		if(product==null){
			Console.println("不存在这样的商品!");
			return;
		}
		if(ProductDAO.deleteProduct(product))
			Console.println("删除成功！");
		else
			Console.println("该商品已经被删除！");
	}

}
