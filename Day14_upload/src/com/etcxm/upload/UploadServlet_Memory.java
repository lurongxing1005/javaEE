package com.etcxm.upload;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
import org.apache.commons.io.FilenameUtils;

//@WebServlet("/upload")
public class UploadServlet_Memory extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		

		
		// Check that we have a file upload request
		//检查请求上传的参数是否合法:method="post" enctype="multipart/form-data"
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if(!isMultipart){
			return;
		}
		
		
		try {
			// Create a factory for disk-based file items
			//创建FileItemFactory对象
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//设置缓存大小
			factory.setSizeThreshold(700*1024);
			//设置缓存目录  (有问题)
			//factory.setRepository(new File("E:/"));

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
					
				}else{ //上传控件
					System.out.println(fileItem.getName());
					System.out.println(fileItem.getContentType());
					
					//使用UUID作为文件名
					String uuidStr = UUID.randomUUID().toString();
					System.out.println(uuidStr);
					
					String extension = FilenameUtils.getExtension(fileItem.getName());
					System.out.println(extension);
					
//					//获取文件名字
//					String filename = fileItem.getName();
					
					
					//tomcat服务器的路径
					String realPath = req.getServletContext().getRealPath("/upload");
					System.out.println(realPath);
					
					
					
					//文件是否在内存中  如果文件>设置缓存大小    false  
					//            如果文件<设置缓存大小   true
					System.out.println(fileItem.isInMemory());
//					
//					//把文件保存到磁盘中
					File file = new File("D:/",uuidStr+"."+extension);
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
