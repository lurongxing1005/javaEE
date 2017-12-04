package com.etcxm.upload;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

//@WebServlet("/upload")
public class UploadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		
//		String username =  req.getParameter("username");
//		String password =  req.getParameter("password");
//		String headImg = req.getParameter("headImg");
//		System.out.println(username);
//		System.out.println(password);
//		System.out.println(headImg);
		
		// Check that we have a file upload request
		//检查请求上传的参数是否合法:method="post" enctype="multipart/form-data"
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if(!isMultipart){
			return;
		}
		
		
		try {
			// Create a factory for disk-based file items
			//创建FileItemFactory对象
			FileItemFactory factory = new DiskFileItemFactory();

			// Create a new file upload handler
			//创建文件上传处理器
			ServletFileUpload upload = new ServletFileUpload(factory);

			// Parse the request
			//解析请求
			List<FileItem> items = upload.parseRequest(req);
			System.out.println(items.size());
			//FileItem表单上的元素
			for (FileItem fileItem : items) {
				
				
				
				if(fileItem.isFormField()){ //普通控件
					System.out.println(fileItem.getFieldName());
					System.out.println(fileItem.getSize());
					
					//中文乱码处理
					System.out.println(fileItem.getString("UTF-8"));
				}else{ //上传控件
					System.out.println(fileItem.getName());
					System.out.println(fileItem.getContentType());
					//获取文件名字
					String filename = fileItem.getName();
					
					//把文件保存到磁盘中
					File file = new File("D:/",filename);
					fileItem.write(file);
				}
				
			}
			
			
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
