package com.etcxm.service;

import java.util.List;

import com.etcxm.dao.DeptDao;
import com.etcxm.entity.Dept;

public class DeptService {

	DeptDao dao = new DeptDao();
	
	
	public List<Dept> queryAll(){
		
		try {
			return dao.queryAlldepts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
