package com.etcxm._01servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements Servlet {
	
	 public HelloServlet(){
		System.out.println("我是构造器");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	   System.out.println("init");
	   System.out.println(config.getServletName());
	   System.out.println(config.getInitParameter("name"));
	   System.out.println(config.getInitParameter("encoding"));
	   System.out.println("-------------------------------");
	   Enumeration<String> names = config.getInitParameterNames();
	   while(names.hasMoreElements()){
		   System.out.println(names.nextElement());
	   }
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello  World");
		
		String encoding = "UTF-8";
		if(encoding.equals("UTF-8")){
			System.out.println("操作A");
		}else{
			System.out.println("操作B");
		}
		
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy");
		
	}
	
	

	

}
