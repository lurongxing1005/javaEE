package com.etcxm._05ServletContext;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contextAservlet")
public class AServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		
		//-------------获取ServletContext
		
//		1.在Servlet类中
//		可以直接调用ServletConfig中的getServletContext();
		System.out.println(getServletContext());
		
//		2.不在Servlet类中
//		古老: request对象.getSession().getServletContext();
		System.out.println(req.getSession().getServletContext());
//		     Servlet3.0:request对象.getServletContext();
		System.out.println(req.getServletContext());

		//-----------------常用方法
		String realPath = req.getServletContext().getRealPath("/WEB-INF/hello.html");
		System.out.println(realPath);
		
		
		String parameter = req.getServletContext().getInitParameter("encoding");
		System.out.println(parameter);

		
		
	}
		
		
		
		

}
