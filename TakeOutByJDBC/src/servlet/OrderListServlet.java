package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Goods;
import pojo.Merchant;
import pojo.Order;
import pojo.User;
import service.GoodsQueryService;
import service.OrderManagerService;
import service.QueryMarchentService;
@WebServlet("/OrderListServlet")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  dishList = request.getParameter("dishList");
		String totalPrice = request.getParameter("totalPrice");
		String merchantId = request.getParameter("merchantId");
		User user = (User) request.getSession().getAttribute("user");
		OrderManagerService oms = new OrderManagerService();
		if(dishList!=null)
			oms.createOrder(dishList, totalPrice, merchantId, user);
		List<Order> listOrder = oms.getOrder(0, 0,user.getUserId(), 0, 0);
		GoodsQueryService gqs = new GoodsQueryService();
		List<Map<Goods,Integer>> listMapGoods = new ArrayList<>();
		List<Merchant> listMerchant = new ArrayList<>();
		QueryMarchentService mqs= new QueryMarchentService();
		for(Order o : listOrder){
			listMerchant.add(mqs.getMerchantById(o.getMerchantId()));
			listMapGoods.add(gqs.getMapGoodsByOrderId(o.getId()));
		}
		request.setAttribute("listMapGoods", listMapGoods);
		request.setAttribute("listOrder",listOrder );
		request.setAttribute("listMerchant", listMerchant);
		request.getRequestDispatcher("/front/order_list.jsp").forward(request, response);
	
	}

}
