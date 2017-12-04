package com.etcxm._03registerDemo;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class registerServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置请求参数的编码
		req.setCharacterEncoding("UTF-8");
		System.out.println("register");
		
		//1.获取请求的参数
		String username = req.getParameter("username");
		//方式1:
//		byte[] bytes = username.getBytes("ISO-8859-1");
//		username = new String(bytes,"UTF-8");
		
		String password = req.getParameter("password");
		System.out.println(username+","+password);
		
//		Enumeration<String> names = req.getParameterNames();
//		while(names.hasMoreElements()){
//			String key = names.nextElement();
//			String value = req.getParameter(key);
//			System.out.println(key+","+value);
//		}
		
	}

}
