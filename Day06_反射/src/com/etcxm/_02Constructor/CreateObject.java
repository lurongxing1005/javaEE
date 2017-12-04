package com.etcxm._02Constructor;

import java.lang.reflect.Constructor;

class Person{
	public Person() {
       System.out.println("无参数的构造器");
	}

	public Person(String name) {
		System.out.println("构造器,"+name);
	}

	private Person(String name, int age) {
		System.out.println("构造器"+name+","+age);
	}
}


public class CreateObject {
	public static void main(String[] args) throws Exception, NoSuchMethodException {
//		  1);找到构造器所在类的字节码对象.
		Class<?> personClz = Person.class;
//		  2):获取构造器对象.
		Constructor<?> c1 = personClz.getConstructor();
//		  3):使用反射,创建对象
		c1.newInstance();
		
		Constructor<?> c2 = personClz.getConstructor(String.class);
		c2.newInstance("张三");
		
		Constructor<?> c3 = personClz.getDeclaredConstructor(String.class,int.class);
        
		//设置访问的权限
		c3.setAccessible(true);
		c3.newInstance("jack",18);
	}

}
