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
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import net.sf.json.JSONSerializer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.etcxm.linkage.City;
import com.etcxm.linkage.Province;
import com.etcxm.utils.StringUtils;

@WebServlet("/linkage")
public class LinkageServlet extends HttpServlet{

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
		
		//MIME类型  html----》xml
		resp.setContentType("text/json;charset=UTF-8");
		
		String parameter = req.getParameter("cmd");
		if(StringUtils.hasLength(parameter)){
			if("province".equals(parameter)){
				 provinces(req, resp);
			}else if("city".equals(parameter)){
				citys(req, resp);
			}
		}
		
		
		
	}
	
	protected void provinces(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * [
            {id:1,name:"四川"},
            {id:2,name:"广东"},
            {id:3,name:"陕西"}
      ]
		 *
		 * */
		PrintWriter out = resp.getWriter();
		
		List<Province> list = Province.getAllProvince();
		String sb = com.alibaba.fastjson.JSON.toJSONString(list);
//		StringBuilder sb = new StringBuilder();
//		sb.append("[");
//		for (Province p : list) {
//			sb.append("{id:"+p.getId()+",name:'"+p.getName()+"'}").append(",");
//		}
//		sb.deleteCharAt(sb.length()-1);
//		sb.append("]");
//		
//		System.out.println(sb);
		
		out.print(sb);
		
		
		
		
		
	
	}
	
	protected void citys(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.println("city");
		
		String pId = req.getParameter("provinceId");
		List<City> list = City.getCityByProvinceId(Long.valueOf(pId));
	     PrintWriter out = resp.getWriter();
		
	     String sb = com.alibaba.fastjson.JSON.toJSONString(list);
		
//		StringBuilder sb = new StringBuilder();
//		sb.append("[");
//		for (City c : list) {
//			sb.append("{id:"+c.getId()+",name:'"+c.getName()+"'}").append(",");
//		}
//		sb.deleteCharAt(sb.length()-1);
//		sb.append("]");
		
		//System.out.println(sb);
		
		out.print(sb);
		
		
	
	}

}
