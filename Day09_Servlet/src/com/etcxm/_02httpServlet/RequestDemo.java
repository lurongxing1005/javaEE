package com.etcxm._02httpServlet;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("request");
		//1.String getContextPath()  :获取当前项目的上下文路径
		
        System.out.println(req.getContextPath());
		
//		2.String getHeader(String name) :获取指定名称的请求头信息
        System.out.println(req.getHeader("User-Agent"));
//		3.String getMethod()  :获取请求的方式
        System.out.println(req.getMethod());
        
//       4 String getQueryString() :获取请求参数的字符串
        System.out.println(req.getQueryString());
//       5.String getRequestURI()  :获取请求的资源的路径  上下文路径+资源名称
        System.out.println("uri="+req.getRequestURI());
//       6. String getRequestURL()  :获取请求的资源的全路径  上下文路径+资源名称
        System.out.println("url="+req.getRequestURL());
        
        System.out.println(req.getParameter("name")+","+req.getParameter("age"));
        Map<String, String[]> map = req.getParameterMap();
        String name = (String) map.get("name")[0];
        System.out.println(name);
//        Set<Entry<String,String[]>> set = map.entrySet();
//        for (Entry<String, String[]> entry : set) {
//			System.out.println(entry);
//		}
        
        
        String[] values = req.getParameterValues("name");
        for (String string : values) {
			System.out.println("string="+string);
		}
        
	}

}
