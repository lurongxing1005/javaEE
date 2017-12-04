package com.etcxm.utils;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.etcxm.execption.UploadExecption;

//文件上传处理工具
public class UploadUtil {
	
	private UploadUtil(){
		
	}
	public static void upload(HttpServletRequest req){
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if(!isMultipart){
			return;
		}
		try {
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//设置缓存的临时目录
			factory.setRepository(new File("E:/"));
			ServletFileUpload upload = new ServletFileUpload(factory);
			//1.设置单个文件上传的最大值
			//upload.setFileSizeMax(500*1024);
			//如果超过 会出现以下的异常：
			//$FileSizeLimitExceededException
			
			//2.设置整个请求（多张图片）的最大值
			upload.setSizeMax(150*1024);
			//如果超过 会出现以下的异常：
			//SizeLimitExceededException
			
			
			List<FileItem> items = upload.parseRequest(req);
			System.out.println(items.size());
			for (FileItem fileItem : items) {
				if(fileItem.isFormField()){ //普通控件
					
				}else{ //上传控件
					System.out.println(fileItem.getContentType());
					
					String contentType = fileItem.getContentType();
					
					//上传文件不是图片类型
					if(!contentType.startsWith("image/")){
						//System.out.println("这不是图片类型");
						throw new UploadExecption("亲，上传的类型不对，应该是图片类型");
					}
					
					//使用UUID作为文件名
					String uuidStr = UUID.randomUUID().toString();
					
					
					String extension = FilenameUtils.getExtension(fileItem.getName());
					
					
					String realPath = req.getServletContext().getRealPath("/upload");
					
//					File file = new File("D:/",uuidStr+"."+extension);
//					fileItem.write(file);
				}
				
			}
			
			
			
		}
		catch(SizeLimitExceededException e){
			throw new UploadExecption("亲，完整请求文件总和不能超过150KB", e);
		}
		catch(FileSizeLimitExceededException e){
			throw new UploadExecption("亲，单个文件不能超过500KB", e);
		}
		catch(UploadExecption e){
			throw e;
		}
		catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
