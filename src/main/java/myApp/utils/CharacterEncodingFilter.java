package myApp.utils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
	private FilterConfig fc;

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		request.setCharacterEncoding("UTF8");
		response.setCharacterEncoding("UTF8");
		chain.doFilter(request, response);
		request.setCharacterEncoding("UTF8");
		response.setCharacterEncoding("UTF8");
	}

	public void destroy() {

	}
}