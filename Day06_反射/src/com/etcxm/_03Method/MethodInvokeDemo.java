package com.etcxm._03Method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Person{
	public void sayHi(){
		System.out.println("无参数的方法");
	}
	public void sayHi(String name){
		System.out.println("有参数的方法,"+name);
	}
	private String sayHi(String name,int age){
		System.out.println("有参数的方法"+name+","+age);
		return name+","+age;
	}
	
	public static void sayHello(String name,int age){
		System.out.println("有参数的方法"+name+","+age);
		
	}
}

public class MethodInvokeDemo {
	//通过反射调用方法
	 public static void main(String[] args) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException {
		Class clz = Person.class;
		
		//需求1:调用public void sayHi()这个方法
		Method m1 = clz.getMethod("sayHi");
		Object obj = m1.invoke(clz.newInstance());
		System.out.println(obj);
		
		//需求2:调用public void sayHi(String name)这个方法
		Method m2 = clz.getMethod("sayHi", String.class);
		obj = m2.invoke(clz.newInstance(), "张三");
		System.out.println(obj);
		
		//需求3:private String sayHi(String name,int age)
		Method m3 = clz.getDeclaredMethod("sayHi", String.class,int.class);
		m3.setAccessible(true);
		obj = m3.invoke(clz.newInstance(), "Lily",18);
		System.out.println(obj);
		
		
		//需求4:	public static void sayHello(String name,int age)
		Method m5 =  clz.getMethod("sayHello", String.class,int.class);
		obj = m5.invoke(null, "will",17);
		System.out.println(obj);
		
		
	/*	Object obj1 = new java.util.Date();
		Class clz2 = obj1.getClass();
		Method m4 =  clz2.getMethod("toLocaleString");
		obj =  m4.invoke(obj1);
		System.out.println(obj);*/
		
	 }

}
