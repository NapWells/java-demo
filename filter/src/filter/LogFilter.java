package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//@WebFilter(filterName="log",urlPatterns={"/*"})
public class LogFilter implements Filter{
	private FilterConfig  config;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		this.config = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		ServletContext context = this.config.getServletContext();
		long before = System.currentTimeMillis();
		System.out.println("开始过滤-----");
		HttpServletRequest hrequest = (HttpServletRequest)request;
		System.out.println("Filter已经截获到用户的请求地址："+hrequest.getServletPath());
		chain.doFilter(request, response);
		long after = System.currentTimeMillis();
		System.out.println("过滤结束-----");
		System.out.println("请求被定为到"+hrequest.getRequestURI()+" 所花的时间为： "+(after-before));
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
	}

}
