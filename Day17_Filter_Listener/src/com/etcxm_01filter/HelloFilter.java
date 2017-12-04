package com.etcxm_01filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/helloFilter")
public class HelloFilter implements Filter{
	
	public HelloFilter() {
		System.out.println("构造器");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("初始化");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("hello 过滤了");
		
		//放行
		chain.doFilter(request, response);
		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("销毁");
	}

}
