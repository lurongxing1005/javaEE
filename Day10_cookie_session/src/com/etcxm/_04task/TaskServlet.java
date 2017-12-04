package com.etcxm._04task;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/task")
public class TaskServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		//获取请求参数
		String data1 = req.getParameter("data1");
		String data2 = req.getParameter("data2");
		String holder = req.getParameter("holder");
		
		int result = 0;
		System.out.println(data1+","+data2+","+holder);
		if(StringUtils.hasLength(data1) && StringUtils.hasLength(data2)){
			Integer intdata1 = Integer.valueOf(data1);
			Integer intdata2 = Integer.valueOf(data2);
			if("+".equals(holder)){
				result = intdata1+intdata2;
			}else if("-".equals(holder)){
				result = intdata1-intdata2;
			}else if("*".equals(holder)){
				result = intdata1*intdata2;
			}else if("/".equals(holder)){
				result = intdata1/intdata2;
			}
			
		}
		System.out.println(result);
		
		
		System.out.println("task");
		
		//输出计算器的界面
		PrintWriter out = resp.getWriter();
		out.print("<form action='/Day10_cookie_session/task' method='post'>");
		out.print("<input type='number' name='data1'value="+data1+">");
		out.print("<select name='holder'>");
		out.print("<option>+</option>");
		if("-".equals(holder)){
			out.print("<option selected='selected'>-</option>");
		}else{
			out.print("<option>-</option>");
		}
		
		out.print("<option>*</option>");
		out.print("<option>/</option>");
		out.print("</select>");
		out.print("<input type='number' name='data2' value="+data2+">");
		out.print("<input type='submit' name='cal' value='='>");
		out.print("<input type='number' name='result' value="+result+">");
		out.print("</form>");
	}

}
