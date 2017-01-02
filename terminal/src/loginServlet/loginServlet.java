package loginServlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import db.DBconnect;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
		DBconnect login = new DBconnect("jdbc:oracle:thin:@localhost:1521:orcl","jsp","000000");
		login.creatConnection(); 
		String username = request.getParameter("username");
		String password =request.getParameter("password");
		String radio = request.getParameter("radio");
		ArrayList list1 = login.query("select name,password from client where name='"+username+"' and password ='"+password+"'");
		ArrayList list2 = login.query("select phone,password from client where phone='"+username+"' and password ='"+password+"'");
		login.close();
		if(list1.size()==0&&list2.size()==0){
			response.getWriter().write("false");
		}
		else{
			HttpSession session = request.getSession();
			session.setAttribute("user",username);
			Cookie cookies[]=request.getCookies();
			for(int i=0;i<cookies.length;i++){
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
			}
			if(radio!=null){
				Cookie username_cookie=new Cookie("username",username);
				response.addCookie(username_cookie);
				Cookie password_cookie=new Cookie("password",password);
				response.addCookie(password_cookie);
			}
			response.getWriter().write("true");
		}
	}

}
