package courseServlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBconnect;

/**
 * Servlet implementation class courseInfo
 */
@WebServlet("/courseInfo")
public class courseInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public courseInfo() {
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
		String name = request.getParameter("name");
		DBconnect courseInfo = new DBconnect("jdbc:oracle:thin:@localhost:1521:orcl","jsp","000000");
		courseInfo.creatConnection();
		ArrayList course1 = courseInfo.query("select course,author,logo,uploadtime,charge,label,difficult,charge,courseintro from course1 where course='"+name+"'");
		request.setAttribute("course1",course1);
		ArrayList course2 = courseInfo.query("select name,price,chapter,path from COURSE2 where course='"+name+"' order by uploadtime");
		request.setAttribute("course2",course2);
		courseInfo.close();
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("course.jsp");
		requestDispatcher.forward(request, response);
	}

}
