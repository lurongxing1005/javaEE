package com.etcxm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.dao.ProductDao;
import com.etcxm.dao.UserDao;
import com.etcxm.entity.User;
import com.etcxm.utils.StringUtils;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDao dao = new UserDao();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		
		
		//验证码校验
		//获取用户填写的验证码
		String randomCode = req.getParameter("randomCode");
		
		//Session的验证码
		String sessionRandomCode = (String)req.getSession().getAttribute("RANDOMCODE_IN_SESSION");
		
		if(!StringUtils.hasLength(randomCode) || !StringUtils.hasLength(sessionRandomCode)){
			req.setAttribute("errorMsg", "亲，验证码不能为空或验证码过时");
			req.getRequestDispatcher("/Login/login.jsp").forward(req, resp);
			return;
		}
		if(!randomCode.equals(sessionRandomCode)){
			req.setAttribute("errorMsg", "亲，验证码错误，请重新输入");
			req.getRequestDispatcher("/Login/login.jsp").forward(req, resp);
			return;
		}
		
		
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		try {
			User user = dao.checkLogin(username, password);
			if(user==null){
				req.setAttribute("errorMsg", "亲，用户名或密码错误");
				req.getRequestDispatcher("/Login/login.jsp").forward(req, resp);
				return;
			}
			req.getSession().setAttribute("USER_IN_SESSION", user);
			resp.sendRedirect("/Day16_page/product");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
