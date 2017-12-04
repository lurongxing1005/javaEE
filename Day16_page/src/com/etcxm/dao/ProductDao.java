package com.etcxm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etcxm.entity.Product;
import com.etcxm.entity.ProductQueryObject;

import com.etcxm.page.PageResult;
import com.etcxm.utils.JDBCUtils;
import com.etcxm.utils.StringUtils;
import com.sun.org.apache.regexp.internal.recompile;

public class ProductDao {
	//创建一个JDBC
		private JDBCUtils util = new JDBCUtils();

		public ProductDao() {
			util.getConnection();
		}
		
//		查找  多个商品
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
		 * 分页和高级查询
		 * @param op
		 * @return
		 * @throws Exception
		 */
		public PageResult queryPageResult(ProductQueryObject op) throws Exception{
			//查询 结果集
			String sql = "SELECT * FROM product"+op.getQuerySql()+" LIMIT ?,?";
			List<Object> params  = new ArrayList<Object>();
			if(op.getParames().size()!=0){
				params.addAll(op.getParames());
				
			}
			params.add((op.getCurrentPage()-1)*op.getPageSize());
			params.add(op.getPageSize());

			List<Product> list = util.findMoreRefResult(sql, params, Product.class);
			
			//查询总条数
			Integer totalCount = (int)totalCount(op);
			
			PageResult pr = new PageResult(list,totalCount,op.getCurrentPage(),op.getPageSize());
			return pr;
		}
		
//		public List<Product> queryPage(Integer currentPage,Integer pageSize) throws Exception{
//			String sql = "SELECT * FROM product LIMIT ?,?";
//			List<Object> params  = new ArrayList<Object>();
//			params.add((currentPage-1)*pageSize);
//			params.add(pageSize);
//			List<Product> list = util.findMoreRefResult(sql, params, Product.class);
//			return list;
//		}
		
		/**
		 * 得到总条数
		 * @return
		 */
		public long totalCount(ProductQueryObject op) {
			String sql = "SELECT COUNT(*) FROM product"+op.getQuerySql();
			//list集合-----》array数组
			//list.toArray();
			
			System.out.println(sql);
			ResultSet resultSet = util.query(sql, op.getParames().toArray());
			long result = 0;
			try {
				if(resultSet.next()){
					result = resultSet.getLong(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
		
	
}
