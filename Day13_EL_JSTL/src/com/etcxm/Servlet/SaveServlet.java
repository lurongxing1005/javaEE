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

//@WebServlet("/student/save")
public class SaveServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("delete");
		req.setCharacterEncoding("UTF-8");
		
		//1.获取请求参数
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String ageStr = req.getParameter("age");
		
		StudentDao dao = new StudentDao();
		boolean flag = false;
		//2.处理业务逻辑
		if(StringUtils.hasLength(id)){  //id有数据  修改
			Student stu = new Student(Long.valueOf(id), name, Integer.valueOf(ageStr));
			try {
				flag = dao.updateStu(stu);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{  //id没有数据 新增
			Student stu = new Student(null, name, Integer.valueOf(ageStr));
			try {
				flag =  dao.addStu(stu);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//3.页面跳转
		if(flag){  //成功可以跳转刷新界面
			resp.sendRedirect("/Day13_EL_JSTL/student/list");
		}else{  //失败的提示
			
		}
	
	}

}
