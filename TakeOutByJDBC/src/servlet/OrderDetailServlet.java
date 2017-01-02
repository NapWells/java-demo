package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Address;
import pojo.User;
import service.AddressService;


@WebServlet("/OrderDetailServlet")
public class OrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String totalPrice = request.getParameter("totalPrice");
		String totalPiece = request.getParameter("totalPiece");
		String dishList = request.getParameter("dishList");
		request.setAttribute("dishList", dishList);
		String merchantId = request.getParameter("merchantId");
		String foodname = request.getParameter("foodname");
		List dishLists = new ArrayList<>();
		for(Object o : dishList.split(" ")){
			dishLists.add(o);
		}
		List foodnames = new ArrayList<>();
		for(Object o: foodname.split(" ")){
			foodnames.add(o);
		}
		User user = (User) request.getSession().getAttribute("user");
		AddressService  as = new AddressService();
		List<Address> listAddress = as.getAddressByUser(user);
		request.setAttribute("listAddress", listAddress);
		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("totalPiece", totalPiece);
		request.setAttribute("merchantId", merchantId);
		request.setAttribute("dishLists", dishLists);
		request.setAttribute("foodnames", foodnames);
		if(request.getAttribute("deal")==null)
			request.getRequestDispatcher("/front/order_detail.jsp").forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
