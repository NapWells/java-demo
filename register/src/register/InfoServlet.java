package register;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/infoServlet")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("passwd");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String degree = request.getParameter("degree");
		String hobby[]=request.getParameterValues("hobby");
		Info info = new Info();
		info.setUsername(username);
		info.setPassword(password);
		info.setSex(sex);
		info.setAge(age);
		info.setDegree(degree);
		info.setHobby(hobby);
		HttpSession session = request.getSession(); 
		session.setAttribute("registerInfo", info);
		response.sendRedirect("servletGetInfo.jsp");
	}

}
