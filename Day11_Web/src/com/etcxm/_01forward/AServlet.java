package com.etcxm._01forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Aservlet")
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
		
//		PrintWriter out = resp.getWriter();
//		out.print("AServlet before");
//		System.out.println("AServlet before");
//		
//		String parameter = req.getParameter("name");
//		System.out.println("A,,"+parameter);
		
		//forward
		//req.getRequestDispatcher("/Bservlet").forward(req, resp);
		//req.getRequestDispatcher("/https://www.baidu.com").forward(req, resp);
		req.getRequestDispatcher("/WEB-INF/hello.html").forward(req, resp);
//		out.print("AServlet after");
//		System.out.println("AServlet after");
	}

}
