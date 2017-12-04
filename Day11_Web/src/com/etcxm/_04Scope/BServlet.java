package com.etcxm._04Scope;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/scopeBservlet")
public class BServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		//1.获取request共享数据
		Object reqNum = req.getAttribute("NUM_IN_REQUEST");
		out.print("请求中的共享数据是"+reqNum+"<br>");
		
		//2.获取Session共享数据
		Object sessionNum = req.getSession().getAttribute("NUM_IN_SESSION");
		out.print("会话中的共享数据是"+sessionNum+"<br>");
		
		
		//3.获取application共享数据
		Object appNum = req.getSession().getServletContext().getAttribute("NUM_IN_APP");
		out.print("应用中的共享数据是" + appNum + "<br>");
		
		
	}

}
