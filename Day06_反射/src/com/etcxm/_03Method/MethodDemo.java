package com.etcxm._03Method;

import java.lang.reflect.Method;

class  User{
	public void doWork(){
		
	}
    public void doWork1(String name){
		
	}
    private String doWork2(String name,int age){
		return name+","+age;
	}
	
}

public class MethodDemo {
	public static void main(String[] args) throws SecurityException, NoSuchMethodException {
		//通过反射获取方法
		
		//getAll();
		getOne();
		
	}
	
	//获取指定的方法
	public static void getOne() throws SecurityException, NoSuchMethodException{
		Class clz = User.class;
		Method m1 =  clz.getMethod("doWork");
		System.out.println(m1);
		
	    Method m2 =	clz.getMethod("doWork1", String.class);
	    System.out.println(m2);
	    
	    Method m3 = clz.getDeclaredMethod("doWork2", String.class,int.class);
		System.out.println(m3);
		
		
	}
	
	//获取所有的方法
	public static void getAll(){
		Class clz = User.class;
		Method[] methods = clz.getMethods();//获取自身和父类的public方法
//		System.out.println(methods.length);
//		
//		for (Method m : methods) {
//			System.out.println(m);
//		}
		
		Method[] dms = clz.getDeclaredMethods();//获取自身的所有方法
		System.out.println(dms.length);
		
		for (Method method : dms) {
			System.out.println(method);
		}
		
		
	}


}
