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

//@WebServlet("/student/list")
public class ListServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1.获取请求参数
		//2.处理业务逻辑
		StudentDao dao = new StudentDao();
		try {
			List<Student> students = dao.students();
			//把数据放到作用域 共享数据
			req.setAttribute("list", students);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3.响应请求转发
		req.getRequestDispatcher("/WEB-INF/views/student/list.jsp").forward(req, resp);
	}

}
