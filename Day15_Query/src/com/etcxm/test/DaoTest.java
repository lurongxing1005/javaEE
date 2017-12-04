package com.etcxm.test;

import java.util.List;

import com.etcxm.dao.ProductDao;
import com.etcxm.dao.ProductDirDao;
import com.etcxm.entity.Product;
import com.etcxm.entity.ProductDir;
import com.etcxm.entity.ProductQueryObject;

public class DaoTest {
	public static void main(String[] args) throws Exception {
		ProductDao	 dao = new ProductDao();
//		List<Product> list = dao.queryAllproducts();
//		System.out.println(list);
//		ProductQueryObject op = new ProductQueryObject(null, 100.0, 200.0);
//		List<Product> query = dao.query(op);
//		System.out.println(query);
//		System.out.println(query.size());
		
		
		ProductDirDao dirDao = new ProductDirDao();
		List<ProductDir> dirs = dirDao.queryAllproductDirs();
		System.out.println(dirs);
	}

}
