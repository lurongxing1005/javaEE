package com.etcxm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etcxm.entity.Product;
import com.etcxm.entity.ProductQueryObject;
import com.etcxm.entity.User;

import com.etcxm.page.PageResult;
import com.etcxm.utils.JDBCUtils;
import com.etcxm.utils.StringUtils;
import com.sun.org.apache.regexp.internal.recompile;

public class UserDao {
	//创建一个JDBC
		private JDBCUtils util = new JDBCUtils();

		public UserDao() {
			util.getConnection();
		}
		
//		登录
		public User checkLogin(String username,String password) throws Exception{
			String sql = "SELECT * FROM t_user WHERE username = ? AND password = ?";
			List<Object> params = new ArrayList<Object>();
			params.add(username);
			params.add(password);
			User user = util.findSimpleRefResult(sql, params, User.class);
			util.releaseConn();
			return user;
		}
		
	
		
	
}
