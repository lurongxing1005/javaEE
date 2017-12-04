package com.etcxm._01ClassInstance;

public class CreateClassInstance {
	public static void main(String[] args) throws ClassNotFoundException {
		//需求:获取java.util.Date的字节码对象(Class对象)
		
		//方式1: 使用class属性
		Class<java.util.Date> clz1 =   java.util.Date.class;
		System.out.println(clz1);
		
		//方式2:getClass()方法
		java.util.Date  date = new java.util.Date();
		Class clz2 = date.getClass();
		System.out.println(clz2);
		
		//方式3:forName("包路径")
		 Class clz3 =  Class.forName("java.util.Date");
		 System.out.println(clz3);
		 
		 System.out.println(clz1==clz2);
		 System.out.println(clz1==clz3);
		 System.out.println(clz2==clz3);
		 
		 //在jvm中,同一个类只有一份字节码对象
		
	}

}
