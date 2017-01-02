package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*@WebFilter(filterName="Authority",
			urlPatterns="/*",
			initParams={
		   			@WebInitParam(name="encoding",value="UTF-8"),
					@WebInitParam(name="loginPage",value="/loginPage.jsp"),
					@WebInitParam(name="proLogin",value="/proLogin.jsp")
		   			})*/
public class AuthorityFilter implements Filter{
	private FilterConfig config;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		this.config = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String encoding = config.getInitParameter("encoding");
		String loginPage = config.getInitParameter("loginPage");
		String proLogin = config.getInitParameter("proLogin");
		request.setCharacterEncoding(encoding);
		HttpServletRequest requ = (HttpServletRequest) request;
		HttpSession session = requ.getSession(true);
		String requestPath = requ.getServletPath();
		if(session.getAttribute("user")==null
				&&!requestPath.endsWith(loginPage)
				&&!requestPath.endsWith(proLogin)){
			request.setAttribute("tip", "您还没有登陆");
			request.getRequestDispatcher(loginPage).forward(request, response);
		}
		else{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
	}

}
