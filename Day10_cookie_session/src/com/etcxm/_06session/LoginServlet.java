package com.etcxm._06session;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session_login")
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
		System.out.println("session");
		//处理业务逻辑
		
		
		//设置和创建Session
		HttpSession session = req.getSession();
		session.setAttribute("USERNAME_IN_SESSION", username);
		//session.setAttribute("username", "lily");
		//session.removeAttribute("username");  //根据指定名删除
		//session.invalidate();//删除所有
		session.setMaxInactiveInterval(15);

		//响应
		PrintWriter out = resp.getWriter();
		out.print("欢迎"+username+"登录<br/>");
		out.print("<a href='/Day10_cookie_session/session_content'>邮件1</a><br/>");
		out.print("<a href='/Day10_cookie_session/session_content'>邮件2</a><br/>");
		out.print("<a href='/Day10_cookie_session/session_content'>邮件3</a><br/>");
		
		
	}

}
