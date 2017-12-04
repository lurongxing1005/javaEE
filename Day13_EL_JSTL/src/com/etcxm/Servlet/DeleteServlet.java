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

//@WebServlet("/student/delete")
public class DeleteServlet extends HttpServlet{

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
		String idStr = req.getParameter("id");
		//2.处理业务逻辑
		StudentDao dao = new StudentDao();
		boolean flag = false;
		try {
			flag = dao.deleteStu(Long.valueOf(idStr));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3.页面跳转
		if(flag){  //成功可以跳转刷新界面
			resp.sendRedirect("/Day13_EL_JSTL/student/list");
		}else{  //失败的提示
			
		}
	
	}

}
