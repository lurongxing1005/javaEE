package com.etcxm.dao;


import java.util.List;

import com.etcxm.entity.Dept;
import com.etcxm.entity.Emp;


import com.etcxm.utils.BaseDao;
import com.etcxm.utils.JDBCUtils;


public class DeptDao {
	//创建一个JDBC
		private JDBCUtils util = new JDBCUtils();

		public DeptDao() {
			util.getConnection();
		}
		
//		查找  多个部门
		public List<Dept> queryAlldepts() throws Exception {
			String sql = "SELECT * FROM DEPT";
			List<Dept> list = util.findMoreRefResult(sql, null, Dept.class);
			util.releaseConn();
			return list;
			
		}
		
		//是BaseDao这个工具
		public List<Dept> querybaseDepts(){
			String sql = "SELECT * FROM DEPT";
			List<Dept> list =(List<Dept>)BaseDao.select(sql, Dept.class, null);
			return list;
		}
		
		public List<Emp> querybaseEmps(){
			String sql = "SELECT * FROM EMP";
			List<Emp> list =(List<Emp>)BaseDao.select(sql, Emp.class, null);
			return list;
		}
		
		
		
		
		
		
		
	
}
