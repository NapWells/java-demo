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
		long id = Console.askUserInputInt("������Ҫɾ������Ʒ��ID��");
		Product product = ProductDAO.getProductById(id);
		if(product==null){
			Console.println("��������������Ʒ!");
			return;
		}
		if(ProductDAO.deleteProduct(product))
			Console.println("ɾ���ɹ���");
		else
			Console.println("����Ʒ�Ѿ���ɾ����");
	}

}
