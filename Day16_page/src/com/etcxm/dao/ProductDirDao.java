package com.etcxm.dao;

import java.util.ArrayList;
import java.util.List;

import com.etcxm.entity.Product;
import com.etcxm.entity.ProductDir;
import com.etcxm.entity.ProductQueryObject;

import com.etcxm.utils.JDBCUtils;
import com.etcxm.utils.StringUtils;

public class ProductDirDao {
	//创建一个JDBC
	private JDBCUtils util = new JDBCUtils();

	public ProductDirDao() {
		util.getConnection();
	}

	// 查找 所有的商品分类
	public List<ProductDir> queryAllproductDirs() throws Exception {
		String sql = "SELECT * FROM productdir";
		List<ProductDir> list = util.findMoreRefResult(sql, null, ProductDir.class);
		util.releaseConn();
		return list;

	}
		
	
}
