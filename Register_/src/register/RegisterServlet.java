package register;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String driverClass = "oracle.jdbc.driver.OracleDriver";
		String DB_name="registerinfo";
		String DB_pwd="000000";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		try {
				Class.forName(driverClass);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
		
		try {
			Connection conn = DriverManager.getConnection(url,DB_name,DB_pwd);
			PreparedStatement pStmt = conn.prepareStatement("insert into register(username,password,sex,age,degree,hobby) values(?,?,?,?,?,?)");
			String username = request.getParameter("username");
			String password = request.getParameter("passwd");
			String sex = request.getParameter("sex");
			String age = request.getParameter("age");
			String degree = request.getParameter("degree");
			String []hobby =request.getParameterValues("hobby");
			String str = "";
			for(int i =0;i<hobby.length;i++){
				str+=hobby[i]+" ";
			}
			pStmt.setString(1,username);
			pStmt.setString(2,password);
			pStmt.setString(3,sex);
			pStmt.setString(4,age);
			pStmt.setString(5,degree);
			pStmt.setString(6,str);
			pStmt.executeUpdate();
			conn.close();
			pStmt.close();
			request.getRequestDispatcher("listInfo.jsp").forward(request,response);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
	}

}
