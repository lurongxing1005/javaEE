package com.etcxm.upload;


import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;





@WebServlet("/uploadAnno")
@MultipartConfig
public class UploadServlet_Anno extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		System.out.println(username);
		
		//Part类似 FileItem  表示表单的元素
		Part part = req.getPart("headImg");
		System.out.println(part.getContentType());
		System.out.println(part.getName());
		System.out.println(part.getHeader("Content-Disposition"));
		
		//part.getHeader(name)
		String header = part.getHeader("Content-Disposition");
		
		String filename =  org.apache.commons.lang3.StringUtils.substringBetween(header, "filename=\"", "\"");
		
        System.out.println(filename);
      //使用UUID作为文件名
		String uuidStr = UUID.randomUUID().toString();
		
		
		String extension = FilenameUtils.getExtension(filename);
		
		//把图片保存在服务器的磁盘中
		part.write("D:/"+uuidStr+"."+extension);
	}

}
