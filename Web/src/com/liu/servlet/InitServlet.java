package com.liu.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class InitServlet implements Servlet,ServletConfig {

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("初始化servlet-----------------");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("获取servlet配置信息-----------------");
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("调用service方法-----------------");
//		res.getWriter().write("hello,everybody");
	}

	@Override
	public String getServletInfo() {
		System.out.println("获取servlet信息-----------------");
		return null;
	}

	@Override
	public void destroy() {
		System.out.println("销毁Servlet----------------");
	}

	@Override
	public String getServletName() {
		return null;
	}

	@Override
	public ServletContext getServletContext() {
		return null;
	}

	@Override
	public String getInitParameter(String name) {
		return null;
	}

	@Override
	public Enumeration<String> getInitParameterNames() {
		return null;
	}

}
