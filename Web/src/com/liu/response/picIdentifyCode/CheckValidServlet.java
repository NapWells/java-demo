package com.liu.response.picIdentifyCode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckValidServlet
 */
@WebServlet("/CheckValidServlet")
public class CheckValidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String serverCheckcode = (String) request.getSession().getAttribute("checkcode");
		String[] clientCheckcode = request.getParameterValues("validateCode");
		System.out.println("serverCheckcode = " + serverCheckcode);
		System.out.println("clientCheckcode = " + clientCheckcode[0]);
		response.setContentType("text/html;charset=utf-8");
		if(serverCheckcode.equalsIgnoreCase(clientCheckcode[0])){
			response.getWriter().print("验证通过！");
		}
		else{
			response.getWriter().print("验证失败！");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
