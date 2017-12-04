package com.etcxm._04Scope;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/scopeAservlet")
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
		
		//1.设置request共享数据
		Object requestNum = req.getAttribute("NUM_IN_REQUEST");
		if(requestNum!=null){
			//object--->字符串--->integer
			Integer num = Integer.valueOf(requestNum.toString());
			req.setAttribute("NUM_IN_REQUEST",num+1);
		}else{
			req.setAttribute("NUM_IN_REQUEST", 1);
		}
		
		
//		2.设置session共享数据
		Object sessionNum = req.getSession().getAttribute("NUM_IN_SESSION");
		if(sessionNum!=null){
			//object--->字符串--->integer
			Integer num = Integer.valueOf(sessionNum.toString());
			req.getSession().setAttribute("NUM_IN_SESSION",num+1);
		}else{
			req.getSession().setAttribute("NUM_IN_SESSION", 1);
		}
		
		
//		2.设置application共享数据
		Object appNum = req.getSession().getServletContext().getAttribute("NUM_IN_APP");
		if(appNum!=null){
			//object--->字符串--->integer
			Integer num = Integer.valueOf(appNum.toString());
			req.getSession().getServletContext().setAttribute("NUM_IN_APP",num+1);
		}else{
			req.getSession().getServletContext().setAttribute("NUM_IN_APP", 1);
		}
		
		
		
		//请求转发
	   req.getRequestDispatcher("/scopeBservlet").forward(req, resp);

		
		
	}
		
		
		
		

}
