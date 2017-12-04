package com.etcxm._03param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/param_login")
public class LoginServlet  extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置乱码问题
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		//获取请求参数
		String username = req.getParameter("username");
		
		//处理业务逻辑
		
		//响应
		PrintWriter out = resp.getWriter();
		out.print("欢迎"+username+"登录<br/>");
		out.print("<a href='/Day10_cookie_session/param_content?username="+username+"'>邮件1</a><br/>");
		out.print("<a href='/Day10_cookie_session/param_content'>邮件2</a><br/>");
		out.print("<a href='/Day10_cookie_session/param_content'>邮件3</a><br/>");
		
		
	}

}
