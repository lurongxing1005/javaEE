package com.etcxm._04Loader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoaderDemo {
	public static void main(String[] args) throws IOException {
//		方式1:使用绝对路径的方式加载.该方式不可行.
		
//		Properties p = new Properties();
//		//E:/javaAll/02javaee/Coding/Day06_反射/
//		InputStream inStream = new FileInputStream("resource/db.properties"); 
//		p.load(inStream);
//		System.out.println(p);
		
//		方式2:使用相对路径-相对于classpath的根路径(字节码输出目录).
//		Properties p = new Properties();
//		
//		//ClassLoader loader = LoaderDemo.class.getClassLoader();
//		ClassLoader loader = Thread.currentThread().getContextClassLoader();
//		InputStream inStream = loader.getResourceAsStream("db.properties");
//		p.load(inStream);
//		System.out.println(p);
		
//		方式3:使用相对路径-相对于当前加载资源文件的字节码路径
		Properties p = new Properties();
		InputStream inStream = LoaderDemo.class.getResourceAsStream("db.properties");
		p.load(inStream);
		System.out.println(p);

	}

}
