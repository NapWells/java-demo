package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.User;
import service.MaintainService;

@WebServlet("/UpdateUserInfo")
public class UpdateUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String telphone = request.getParameter("telphone");
		String email = request.getParameter("eamil");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (username != null)
			user.setUsername(username);
		if (telphone != null)
			user.setTelphone(telphone);
		if (email != null)
			user.setEmail(email);
		if (name != null)
			user.setName(name);
		if (address != null)
			user.setAddress(address);
		if (password != null)
			user.setPassword(password);
		MaintainService ms = new MaintainService();
		boolean result = ms.updateUser(user);
		if (result) {
			session.setAttribute("user", user);
			request.getRequestDispatcher("/front/user_info.jsp").forward(request, response);
		} else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print("更新失败！");
		}
	}

}
