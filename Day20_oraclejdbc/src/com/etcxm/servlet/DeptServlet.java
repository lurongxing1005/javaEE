package com.etcxm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.etcxm.entity.Dept;
import com.etcxm.service.DeptService;
import com.google.gson.Gson;

@WebServlet("/deptServlet")
public class DeptServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("application/json;charset=UTF-8");
		
		DeptService	 service = new DeptService();
		List<Dept> list = service.queryAll();
		
		//1.fastJson  //首字母改为小写
		//list--->json
		String jsonString = JSON.toJSONString(list);
		//System.out.println(jsonString);
		
		//2.gson
		/*Gson g = new Gson();
		String json = g.toJson(list);
		System.out.println(json);*/
		
		PrintWriter out = resp.getWriter();
		out.print(jsonString);//GSON
		
	}

}
