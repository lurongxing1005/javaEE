package com.etcxm.test;

import java.util.List;

import com.etcxm.dao.ProductDao;
import com.etcxm.dao.ProductDirDao;
import com.etcxm.entity.Product;
import com.etcxm.entity.ProductDir;
import com.etcxm.entity.ProductQueryObject;
import com.etcxm.page.PageResult;

public class DaoTest {
	public static void main(String[] args) throws Exception {
		ProductDao	 dao = new ProductDao();
		
		//分页
		ProductQueryObject op = new ProductQueryObject("M", null, null);
	    PageResult result = dao.queryPageResult(op);
		System.out.println(result);
		
		//总条数
//		long totalCount = dao.totalCount();
//		System.out.println(totalCount);
		
		//商品总数据
//		List<Product> list = dao.queryAllproducts();
//		System.out.println(list);
//		ProductQueryObject op = new ProductQueryObject(null, 100.0, 200.0);
//		List<Product> query = dao.query(op);
//		System.out.println(query);
//		System.out.println(query.size());
		
		//商品分类总数据
//		ProductDirDao dirDao = new ProductDirDao();
//		List<ProductDir> dirs = dirDao.queryAllproductDirs();
//		System.out.println(dirs);
	}

}
