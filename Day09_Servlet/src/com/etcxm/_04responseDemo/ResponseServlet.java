package com.etcxm._04responseDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Response");
		
		//1.获取请求参数
		
		//2.处理业务逻辑
		
		//3.响应信息(动态输出界面)
		//响应信息乱码问题:MIME
		
		//方式1:
//		resp.setContentType("text/html");
//		resp.setCharacterEncoding("UTF-8");
		
//		方式2:  推荐
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.println("百度一下");
		out.print("<input>");  //text/html  这要写才能生成html格式
		
//		ServletOutputStream outputStream = resp.getOutputStream();
		
		
		//
		
		
		
	}

}
