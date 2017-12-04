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

import com.etcxm.linkage.City;
import com.etcxm.linkage.Province;
import com.etcxm.utils.StringUtils;

//@WebServlet("/linkage")
public class LinkageServlet_html extends HttpServlet{

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
		resp.setContentType("text/html;charset=UTF-8");
		
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
		PrintWriter out = resp.getWriter();
		
		List<Province> allProvince = Province.getAllProvince();
		
		/*<option value="1">四川 </option>
		 * <option value="1">四川 </option>
		 * <option value="1">四川 </option>*/
		
		StringBuilder strhtml = new StringBuilder();
		for (Province province : allProvince) {
			strhtml.append("<option value=").append(province.getId()).
			append(">").append(province.getName()).append("</option>");
		}
		
		out.print(strhtml);
		
		
	
	}
	
	protected void citys(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.println("city");
		PrintWriter out = resp.getWriter();
		String pId = req.getParameter("provinceId");
		List<City> list = City.getCityByProvinceId(Long.valueOf(pId));
		
		StringBuilder strhtml = new StringBuilder();
		for (City city : list) {
			strhtml.append("<option value=").append(city.getId()).
			append(">").append(city.getName()).append("</option>");
		}
		out.print(strhtml);
	
	}

}
