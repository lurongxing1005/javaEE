package com.etcxm.jdbc;

import java.util.List;

import com.etcxm.dao.DeptDao;
import com.etcxm.entity.Dept;
import com.etcxm.entity.Emp;
import com.etcxm.service.DeptService;

public class daotest {
	public static void main(String[] args) {
		DeptService service = new DeptService();
		List<Dept> all = service.queryAll();
		//System.out.println(all);
		
		DeptDao dao = new DeptDao();
		/*List<Dept> list = dao.querybaseDepts();
		System.out.println(list);*/
		
		List<Emp> list = dao.querybaseEmps();
		System.out.println(list);
	}

}
