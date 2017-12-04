package com.etcxm.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.dao.StudentDao;
import com.etcxm.entity.Student;
import com.etcxm.utils.StringUtils;

//@WebServlet("/student/edit")
public class EditServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("delete");
		//1.获取请求参数
		String id = req.getParameter("id");
		//2.处理业务逻辑
		if(StringUtils.hasLength(id)){
			StudentDao dao = new StudentDao();
			try {
				Student stu = dao.queryStu(Long.valueOf(id));
				
				//把stu 放在作用域中 共享数据
				req.setAttribute("stu", stu);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//3.页面跳转
		req.getRequestDispatcher("/WEB-INF/views/student/edit.jsp").forward(req, resp);
	
	}

}
