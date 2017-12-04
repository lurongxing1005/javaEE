package com.etcxm._servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.utils.FilterUtil;

@WebServlet("/content")
public class ContentServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html; charset=UTF-8");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		//String filter = FilterUtil.filter(title);
		
		PrintWriter out = resp.getWriter();
		out.print("title="+title);
		out.print("<br/>");
		out.print("content="+content);
	}

}
