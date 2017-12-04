package com.etcxm.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {
	public static void main(String[] args)  {
		
		try {
			//1.加载jar包
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.获取连接对象
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			
			//3.获取语句对象
			PreparedStatement statement = conn.prepareStatement("select * from emp");
			
			//4,执行查询语句
			ResultSet set = statement.executeQuery();
			while(set.next()){
				String empno = set.getString("empno");
				String ename = set.getString("ename");
				System.out.println(empno+"...."+ename);
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
