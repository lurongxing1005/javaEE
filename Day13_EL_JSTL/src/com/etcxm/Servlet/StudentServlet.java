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

//合并(list/edit/delete/savaOrUpdate)Servlet

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentDao dao = new StudentDao();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		
		String parameter = req.getParameter("cmd");
		if(parameter.equals("delete")){
			delete(req, resp);
		}else if(parameter.equals("edit")){
			edit(req, resp);
		}else if(parameter.equals("saveOrUpdate")){
			saveOrUpdate(req, resp);
		}else{
			list(req,resp);
		}
		
	}

	protected void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.获取请求参数
		String idStr = req.getParameter("id");
		
		// 2.处理业务逻辑
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
		// 3.页面跳转
		if (flag) { // 成功可以跳转刷新界面
			resp.sendRedirect(req.getContextPath()+"/student?cmd=list");
		} else { // 失败的提示

		}
	}

	protected void edit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.获取请求参数
		String id = req.getParameter("id");
		// 2.处理业务逻辑
		if (StringUtils.hasLength(id)) {
			try {
				Student stu = dao.queryStu(Long.valueOf(id));

				// 把stu 放在作用域中 共享数据
				req.setAttribute("stu", stu);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 3.页面跳转
		req.getRequestDispatcher("/WEB-INF/views/student/edit.jsp").forward(
				req, resp);
	}
	
	protected void list(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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

	protected void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
        
		
		//1.获取请求参数
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String ageStr = req.getParameter("age");
		
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
			resp.sendRedirect(req.getContextPath()+"/student?cmd=list");
		}else{  //失败的提示
			
		}
		
	}

}
