package com.etcxm._05cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie_content")
public class ContentServlet  extends HttpServlet {

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

		// 获取请求参数
		String username = null;
		
		
		//获取Cookie的数据
		Cookie[] cookies = req.getCookies();
		System.out.println(cookies.length);
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName());
			System.out.println(cookie.getValue());
			username = cookie.getValue();
			username = URLDecoder.decode(username, "UTF-8");
		}
		
		
		// 处理业务逻辑

		// 响应
		PrintWriter out = resp.getWriter();
		out.print("欢迎" + username + "登录<br/>");
		out.print("明天要加班");
		
	}

}
