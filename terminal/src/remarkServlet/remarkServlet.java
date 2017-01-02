package remarkServlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBconnect;

/**
 * Servlet implementation class remarkServlet
 */
@WebServlet("/remarkServlet")
public class remarkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public remarkServlet() {
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
		DBconnect remark = new DBconnect("jdbc:oracle:thin:@localhost:1521:orcl","jsp","000000");
		remark.creatConnection();
		String coursename = request.getParameter("B");
		String chapter = request.getParameter("C");
		String content = request.getParameter("A");
		String radio = request.getParameter("D");
		HttpSession session=request.getSession();
		String user = (String) session.getAttribute("user");
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
		String date = df.format(new Date());
		System.out.println("insert into remark(coursename,chapter,pinglunren,content,time,noname) values ('"+coursename+"',"
				+ "'"+chapter+"','"+user+"','"+content+"','"+date+"',"+radio+")");
		remark.update("insert into remark(coursename,chapter,pinglunren,content,time,noname) values ('"+coursename+"',"
				+ "'"+chapter+"','"+user+"','"+content+"','"+date+"',"+radio+")");
		remark.close();
		response.setContentType("text/html;charset=UTF-8"); 
		response.getWriter().write("<li>");
		response.getWriter().write("<div class='row'>");
		response.getWriter().write("<div class='col-md-2'><img src='image/touxiang.png'></div>");
		response.getWriter().write("<div class='col-md-10'>");
		response.getWriter().write("<p><span id='user'>"+user+"</span><span id='time'>发表于："+date+"</span></p>");
		response.getWriter().write("<p id='content'>"+content+"</p>");
		response.getWriter().write("</div>");
		response.getWriter().write("</div>");
		response.getWriter().write("</li>");
		response.getWriter().write("<li><hr></li>");
		
	}

}
