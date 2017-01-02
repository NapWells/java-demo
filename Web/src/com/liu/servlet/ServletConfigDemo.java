package com.liu.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigDemo extends HttpServlet{
	private static final long serialVersionUID = 1L;

//	private ServletConfig config;
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		this.config = config;
//	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		ServletConfig config = this.getServletConfig();
		String paramName = config.getInitParameter("name");
		resp.getWriter().println(paramName);
		resp.getWriter().print("<hr/>");

		Enumeration<String> e = config.getInitParameterNames();
		while(e.hasMoreElements()){
			String name = e.nextElement();
			String value = config.getInitParameter(name);
			resp.getWriter().println(name + "=" + value+"<br>");
		}
	}
	

}
