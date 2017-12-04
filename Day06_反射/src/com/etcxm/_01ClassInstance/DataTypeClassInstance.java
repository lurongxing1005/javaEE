package com.etcxm._01ClassInstance;

public class DataTypeClassInstance {
	public static void main(String[] args) {
		//8大基本数据类型 获取Class对象
		Class<?> clz1 = int.class;
		Class<?> clz2 = boolean.class;
		
		System.out.println(Integer.class == int.class);//false
		
		System.out.println(Integer.TYPE == int.class);
		
		System.out.println("-------------------------------------");
		//数组
//		方式1:  数组类型.class;
//		方式2:  数组对象.getClass();
		int[] arr = {1,2,3,5,7};
		Class clz3 = int[].class;
		Class clz4 = arr.getClass();
		System.out.println(clz3==clz4);
		
		float[] arr1 = {3.0f,7.0f,8.0f,9.0f};
		Class clz5 = arr1.getClass(); 
		System.out.println(clz5 == arr.getClass());
		

		
	}
	public void dowork(int age){
		
	}
    public void dowork(Integer age){
		
	}

}
