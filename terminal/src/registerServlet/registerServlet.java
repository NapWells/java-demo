package registerServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.jasper.tagplugins.jstl.core.Out;

import db.DBconnect;
import oracle.net.ns.SessionAtts;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
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
		DBconnect registerInfo = new DBconnect("jdbc:oracle:thin:@localhost:1521:orcl","jsp","000000");
		registerInfo.creatConnection(); 
		String user = request.getParameter("user");
		String phone =request.getParameter("phone");
		String password = request.getParameter("password1");
		HttpSession session = request.getSession();
		session.setAttribute("user",user);
		session.setAttribute("password",password);
		registerInfo.update("insert into client (name,password,phone) values('"+user+"','"+password+"','"+phone+"')");
		registerInfo.close();
		request.getRequestDispatcher("home.jsp").forward(request,response);
	}

}
