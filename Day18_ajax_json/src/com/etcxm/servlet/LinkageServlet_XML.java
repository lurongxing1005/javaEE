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

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.etcxm.linkage.City;
import com.etcxm.linkage.Province;
import com.etcxm.utils.StringUtils;

//@WebServlet("/linkage")
public class LinkageServlet_XML extends HttpServlet{

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
		resp.setContentType("text/xml;charset=UTF-8");
		
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
		 * <datas>
		 *    <data id="1">
		 *      四川
		 *    </data>
		 *    
		 * <data id="2">
		 *      四川
		 *    </data>
		 *    
		 * <data id="3">
		 *      四川
		 *    </data>
		 * 
		 * </datas>
		 *
		 * */
		
		try {
			Document doc =  DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		    doc.setXmlVersion("1.0");
		    
		    //创建根元素
		    Element root = doc.createElement("datas");
		    
		    //将根元素放到doc文档中
		    doc.appendChild(root);
		    
		    List<Province> allProvince = Province.getAllProvince();
		    for (Province province : allProvince) {
		    	//创建data对象
				Element ele = doc.createElement("data");
				ele.setAttribute("id", province.getId().toString());
				ele.setTextContent(province.getName());
				
				//将data对象放到root上
				root.appendChild(ele);
				
			}
		    
		    
		    //将XML数据---》浏览器
		    Transformer tf = TransformerFactory.newInstance().newTransformer();
		    tf.transform(new DOMSource(doc), new StreamResult(resp.getOutputStream()));
		    
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//out.print(strhtml);
		
		
	
	}
	
	protected void citys(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.println("city");
		
		String pId = req.getParameter("provinceId");
		List<City> list = City.getCityByProvinceId(Long.valueOf(pId));
		
		
		try {
			Document doc =  DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		    doc.setXmlVersion("1.0");
		    
		    //创建根元素
		    Element root = doc.createElement("datas");
		    
		    //将根元素放到doc文档中
		    doc.appendChild(root);
		    
		    
		    for (City city : list) {
		    	//创建data对象
				Element ele = doc.createElement("data");
				ele.setAttribute("id", city.getId().toString());
				ele.setTextContent(city.getName());
				
				//将data对象放到root上
				root.appendChild(ele);
				
			}
		    
		    
		    //将XML数据---》浏览器
		    Transformer tf = TransformerFactory.newInstance().newTransformer();
		    tf.transform(new DOMSource(doc), new StreamResult(resp.getOutputStream()));
		    
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
