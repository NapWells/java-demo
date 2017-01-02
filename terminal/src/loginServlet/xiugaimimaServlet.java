package loginServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBconnect;

/**
 * Servlet implementation class xiugaimimaServlet
 */
@WebServlet("/xiugaimimaServlet")
public class xiugaimimaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xiugaimimaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		DBconnect xiugaimima = new DBconnect("jdbc:oracle:thin:@localhost:1521:orcl","jsp","000000");
		xiugaimima.creatConnection(); 
		String password = request.getParameter("password");
		String password1=request.getParameter("password1");
		HttpSession session = request.getSession();
		String user= (String)session.getAttribute("user");
		String truePassword=(String)session.getAttribute("password");
		if(password!=truePassword){
			response.getWriter().write("false");
		}
		if(password==truePassword){
			session.removeAttribute("password");
			session.setAttribute("password", password1);
			xiugaimima.update("update client set password= '"+password1+"' where name ='"+user+"'");
			xiugaimima.close();
			response.getWriter().write("true");
		}
		
	}

}
