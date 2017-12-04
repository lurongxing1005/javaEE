package com.etcxm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.utils.StringUtils;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("注册");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String username = req.getParameter("username");
		
		List<String> names = Arrays.asList(new String[]{"jack","lily","rose"});
		//判断用户名是否存在
		PrintWriter out = resp.getWriter();
		if(StringUtils.hasLength(username)){
			if(names.contains(username)){
				//System.out.println("亲，用户名已经存在");
				out.print("亲，用户名已经存在");
			}else{
				//System.out.println("恭喜你，用户名可以使用");
				out.print("恭喜你，用户名可以使用");
			}
		}else{
			out.print("亲，用户名不能为空");
		}
		
	}

}
