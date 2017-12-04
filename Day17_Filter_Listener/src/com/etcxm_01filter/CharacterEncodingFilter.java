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

//@WebFilter("/*")
public class CharacterEncodingFilter implements Filter{

	private String encoding;
	private boolean force;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		encoding = filterConfig.getInitParameter("encoding");
		force = Boolean.valueOf(filterConfig.getInitParameter("force"));
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println(encoding);
		System.out.println(force);
		//设置编码格式
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		if(force){
			req.setCharacterEncoding(encoding);
		}else{
			
		}
		
		//放行
		chain.doFilter(req, resp);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
