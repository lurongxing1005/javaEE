package com.etcxm.dao;

import java.util.ArrayList;
import java.util.List;

import com.etcxm.entity.Product;
import com.etcxm.entity.ProductQueryObject;

import com.etcxm.utils.JDBCUtils;
import com.etcxm.utils.StringUtils;

public class ProductDao {
	//创建一个JDBC
		private JDBCUtils util = new JDBCUtils();

		public ProductDao() {
			util.getConnection();
		}
		
//		查找  多个人
		public List<Product> queryAllproducts() throws Exception{
			String sql = "SELECT * FROM product";
			List<Product> list = util.findMoreRefResult(sql, null, Product.class);
			util.releaseConn();
			return list;
			
		}
		
		/**
		 * 高级查询方法   只要一个对象参数
		 * @param op
		 * @return
		 * @throws Exception
		 */
		public List<Product> query(ProductQueryObject op) throws Exception{
			
//			op.getQuerySql();  sql语句
//			op.getParames()    sql对应的参数
			
			String sql = "SELECT * FROM product "+op.getQuerySql();
			
			List<Product> list = util.findMoreRefResult(sql, op.getParames(), Product.class);
			util.releaseConn();
			return list;
			
		}
		
		/**
		 * 高级查询方法
		 * @param productName
		 * @param minprice
		 * @param maxprice
		 * @return
		 * @throws Exception
		 */
	/*	public List<Product> query(String productName,Double minprice,Double maxprice) throws Exception{
			//String sql = "SELECT * FROM product";
			StringBuilder sql  = new StringBuilder("SELECT * FROM product");
			//SELECT * FROM product WHERE 1=1 and productName like %M% AND salePrice>=minprice AND salePrice<=maxprice
			
			//存放参数的集合
			List<Object> parames = new ArrayList<Object>();
			
			//存放sql语句的集合
			List<Object> conditions = new ArrayList<Object>();
			
			if(StringUtils.hasLength(productName)){
				conditions.add(" productName LIKE ?");
				//sql.append(" AND productName LIKE ?");
				parames.add("%"+productName+"%");
			}
			if(minprice!=null){
				conditions.add(" salePrice >= ?");
				//sql.append(" AND salePrice >= ?");
				parames.add(minprice);
			}
			if(maxprice!=null){
				conditions.add(" salePrice <= ?");
				//sql.append(" AND salePrice <= ?");
				parames.add(maxprice);
			}
			
			//方法1：
//			for (int i = 0; i < conditions.size(); i++) {
//				if(i==0){ //第一个条件
//					sql.append(" WHERE ");
//				}else{  //非第一个条件
//					sql.append(" AND ");
//				}
//				sql.append(conditions.get(i));
//			}
			
//			方式2：
			if(conditions.size()>0){
				sql.append(" WHERE ");
				sql.append(org.apache.commons.lang3.StringUtils.join(conditions, " AND "));
			}
			//org.apache.commons.lang3.StringUtils.j
			
			System.out.println(sql.toString());
			List<Product> list = util.findMoreRefResult(sql.toString(), parames, Product.class);
			util.releaseConn();
			return list;
			
		}
		
		
		/**
		 * 高级查询方法
		 * @param productName
		 * @param minprice
		 * @param maxprice
		 * @return
		 * @throws Exception
		 */
	/*	public List<Product> query(String productName,Double minprice,Double maxprice) throws Exception{
			//String sql = "SELECT * FROM product";
			StringBuilder sql  = new StringBuilder("SELECT * FROM product WHERE 1=1");
			//SELECT * FROM product WHERE 1=1 and productName like %M% AND salePrice>=minprice AND salePrice<=maxprice
			
			List<Object> parames = new ArrayList<Object>();
			if(StringUtils.hasLength(productName)){
				sql.append(" AND productName LIKE ?");
				parames.add("%"+productName+"%");
			}
			if(minprice!=null){
				sql.append(" AND salePrice >= ?");
				parames.add(minprice);
			}
			if(maxprice!=null){
				sql.append(" AND salePrice <= ?");
				parames.add(maxprice);
			}
			System.out.println(sql.toString());
			List<Product> list = util.findMoreRefResult(sql.toString(), parames, Product.class);
			util.releaseConn();
			return list;
			
		}*/
}
