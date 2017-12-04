package com.etcxm.test;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import com.alibaba.fastjson.TypeReference;
import com.etcxm.linkage.Province;

public class JSONTest {
	public static void main(String[] args) {
		//jsonlib();
		fastjson();
	}
	public static void fastjson(){
		
		//java---->json
		List<Province> allProvince = Province.getAllProvince();
		Object jsonObj = com.alibaba.fastjson.JSON.toJSON(allProvince.get(2));
		System.out.println(jsonObj);
		
		
		
		
		
		Object jsonArray = com.alibaba.fastjson.JSON.toJSON(allProvince);
		System.out.println(jsonArray);
		
		String string = com.alibaba.fastjson.JSON.toJSONString(allProvince.get(2));
		System.out.println(string);
		
		//json---->java
      /*  com.alibaba.fastjson.JSONObject java = com.alibaba.fastjson.JSONArray.parseObject(string);
		System.out.println(java);*/
	  String kk = "{\"id\":\"3\",\"name\":\"陕西\"}";
	  List<Province> array = new ArrayList<Province>();
       array = com.alibaba.fastjson.JSONObject.parseArray(jsonArray.toString(), Province.class);
	  System.out.println(array);
	}
	public static void jsonlib(){
		//把javabean对象  -----》 json字符串
		List<Province> allProvince = Province.getAllProvince();
		JSONObject jsonObject = JSONObject.fromObject(allProvince.get(0));
		//System.out.println(jsonObject);
		
		//list对象------》json字符串
		JSONArray jsonArray = JSONArray.fromObject(allProvince);
		//System.out.println(jsonArray);
		
		
		//同时支持对象和集合
		JSON jsonObj = JSONSerializer.toJSON(allProvince.get(1));
		JSON jsonArr = JSONSerializer.toJSON(allProvince);
		System.out.println(jsonObj);
		System.out.println(jsonArr);
		
		//json----->java
		Object java = JSONSerializer.toJava(jsonObj);
		System.out.println(java);
		
	}
	
	

}
