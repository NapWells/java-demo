package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Goods;
import pojo.Merchant;
import service.GoodsQueryService;
import service.QueryMarchentService;

@WebServlet("/DishListServlet")
public class DishListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int merchantId = Integer.parseInt(request.getParameter("id"));
		GoodsQueryService gqs = new GoodsQueryService();
		QueryMarchentService qms = new QueryMarchentService();
		Merchant merchant = qms.getMerchantById(merchantId);
		List<Goods> listGoods = gqs.getListGoodsByMerchantId(merchantId);
		request.setAttribute("merchant", merchant);
		request.setAttribute("listGoods", listGoods);
		request.getRequestDispatcher("/front/dish_list.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
