package com.etcxm._02Constructor;

import java.lang.reflect.Constructor;

class User{
	public User() {

	}

	public User(String name) {

	}

	private User(String name, int age) {

	}
}

public class ConstructorDemo {
	//1.获取所有的构造器
	public static void getAll(){
		//1.获取字节码对象
		Class<User> clz = User.class;
		//2.从该字节码对象中去找需要获取的构造器
		Constructor<?>[] cs = clz.getConstructors();
		System.out.println(cs.length);
		
		//遍历
		for (Constructor<?> c : cs) {
			System.out.println(c);
		}
		
		System.out.println("------------------------------");
		Constructor<?>[] dcs = clz.getDeclaredConstructors();
		System.out.println(dcs.length);
		for (Constructor<?> c : dcs) {
			System.out.println(c);
		}
	}
	
	
	//2.获取指定的构造器
	public static void getOne() throws SecurityException, NoSuchMethodException{
		// 1.获取字节码对象
		Class<User> clz = User.class;
		// 2.从该字节码对象中去找需要获取的构造器
		
		//需求A.获取public User() 
		Constructor<User> c1 = clz.getConstructor();
		System.out.println(c1);
		
		//需求B.获取public User(String name) 
		Constructor<User> c2 = clz.getDeclaredConstructor(String.class);
		System.out.println(c2);
		
		//需求C.获取public User(String name,int age) 
		Constructor<User> c3 = clz.getDeclaredConstructor(String.class,int.class);
		System.out.println(c3);
	}
	
	public static void main(String[] args) throws Exception, NoSuchMethodException {
		//getAll();
		getOne();
	}

}
