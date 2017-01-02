package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.User;
import service.QueryUserService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		QueryUserService qs = new QueryUserService();
		User user = qs.login(username, password);
		if(user!=null){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.getRequestDispatcher("/index.html").forward(request, response);
		}else{
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print("登录失败！");
		}
	}

}
