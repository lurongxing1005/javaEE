package com.etcxm.m1.User;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name="will";
    private int age = 16;
    private String[] fav={"java","php","ios"};
    private List<String> list = Arrays.asList(new String[]{"rose","lily"});
    private Map<String,String> map = new HashMap<String,String>(){
    	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
    		this.put("name","tom");
    		this.put("com.etcxm.user", "中软");
    	}
    	
    };
    
    
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", fav="
				+ Arrays.toString(fav) + ", list=" + list + ", map=" + map
				+ "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, int age, String[] fav, List<String> list,
			Map<String, String> map) {
		super();
		this.name = name;
		this.age = age;
		this.fav = fav;
		this.list = list;
		this.map = map;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String[] getFav() {
		return fav;
	}
	public void setFav(String[] fav) {
		this.fav = fav;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
    
    
}
