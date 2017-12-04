package com.etcxm.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pageTest {
	public static void main(String[] args)  {
		
		try {
			//1.加载jar包
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.获取连接对象
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			
			//3.获取语句对象
			PreparedStatement statement = conn.prepareStatement("select * from (select rownum r,t1.* from emp t1 " +
					"where rownum <= ?) t2  where t2.r > ?");
			
			//模拟分页  第4页     1页3条数据
			int pagenum = 1;
			int pagesize = 3;
			statement.setInt(1, pagenum*pagesize);
			statement.setInt(2, (pagenum-1)*pagesize);
			
			//4,执行查询语句
			ResultSet set = statement.executeQuery();
			while(set.next()){
				String r = set.getString("r");
				String empno = set.getString("empno");
				String ename = set.getString("ename");
				System.out.println(r+"....."+empno+"...."+ename);
			}
			
//			5.释放
			set.close();
			statement.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
