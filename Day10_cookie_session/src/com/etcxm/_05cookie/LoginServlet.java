package com.etcxm._05cookie;

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

@WebServlet("/cookie_login")
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
		System.out.println("cookie");
		//处理业务逻辑
		
		
		//设置和创建Cookie
//		创建     办卡
		
		username = URLEncoder.encode(username, "UTF-8");
		Cookie cookie = new Cookie("username", username);
	
		//设置cookie 的生命周期
	    cookie.setMaxAge(60*60*24*30);
		System.out.println("encode"+username);
		//把卡给客户(浏览器)
		resp.addCookie(cookie);
		username = URLDecoder.decode(username, "UTF-8");
		System.out.println("decode"+username);
		
		//响应
		PrintWriter out = resp.getWriter();
		out.print("欢迎"+username+"登录<br/>");
		out.print("<a href='/Day10_cookie_session/cookie_content'>邮件1</a><br/>");
		out.print("<a href='/Day10_cookie_session/cookie_content'>邮件2</a><br/>");
		out.print("<a href='/Day10_cookie_session/cookie_content'>邮件3</a><br/>");
		
		
	}

}
