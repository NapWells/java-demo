package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Clazz;
import pojo.Merchant;
import service.QueryMarchentService;
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QueryMarchentService qms = new QueryMarchentService();
		List<Clazz> listClazz = qms.getAllMerchantsCLass();
		request.setAttribute("listClazz", listClazz);
		List<Merchant> listMerchant = qms.getAllMerchant();
		request.setAttribute("listMerchant", listMerchant);
		request.getRequestDispatcher("/front/index.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
