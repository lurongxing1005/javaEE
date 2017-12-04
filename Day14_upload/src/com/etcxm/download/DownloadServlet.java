package com.etcxm.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filename = req.getParameter("filename");
		System.out.println(filename);
		
		//设置下载的文件名称
		resp.setHeader("Content-Disposition", "attachment; filename="+filename);
		
		//设置下载中文乱码的问题
		resp.setHeader("Content-Disposition","attachment;filename="+new String(filename.getBytes("UTF-8"),"ISO8859-1"));
		
		String realPath = req.getServletContext().getRealPath("/WEB-INF/download");
		File file = new File(realPath, filename);
		System.out.println(file.getAbsolutePath());
		
		//将文件响应给浏览器
		//java7的功能
		//Files.copy  复制文件
		
		//输入
		FileInputStream fis = new FileInputStream(file.getAbsolutePath());
		
		//输出
		ServletOutputStream fos = resp.getOutputStream();
		//以字节流形式传输的
		byte[] b = new byte[1024];
		while(fis.read(b) != -1){  //读
			fos.write(b); //写
			fos.flush();//刷新
		}
		fis.close();
		resp.getOutputStream().close();
		System.out.println("结束了");
		
	}

}
