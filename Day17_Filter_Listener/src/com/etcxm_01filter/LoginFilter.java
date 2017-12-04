package com.etcxm_01filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/system/*")
public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		System.out.println(req.getRequestURI());
		//在过滤器中设置登录校验
		Object object = req.getSession().getAttribute("USER_IN_SESSION");
		if(object == null){
			resp.sendRedirect("/Day17_Filter_Listener/login.jsp");
		}
		
		chain.doFilter(req, resp);
		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
