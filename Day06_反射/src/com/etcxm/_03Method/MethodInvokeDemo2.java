package com.etcxm._03Method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

class Employee{
	public static void doWork1(int...arr){
		System.out.println("dowork1被调用"+Arrays.toString(arr));
	}
	public static void doWork2(String...arr){
		System.out.println("dowork2被调用"+Arrays.toString(arr));
	}
	
}

public class MethodInvokeDemo2 {
  public static void main(String[] args) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
	 //1.基本类型的数组参数
	 Class clz = Employee.class;
	 Method m1 = clz.getMethod("doWork1", int[].class);
	// Object obj = m1.invoke(null, new int[]{2,3,4,5});
	 Object obj = m1.invoke(null, new Object[]{new int[]{2,3,4,5}});
	 System.out.println(obj);
	 
	 //2.引用类型的数组参数
	 Method m2 = clz.getMethod("doWork2", String[].class);
	 obj = m2.invoke(null, new Object[]{new String[]{"jack","rose","lily"}});
	 System.out.println(obj);
	  
  }
}
