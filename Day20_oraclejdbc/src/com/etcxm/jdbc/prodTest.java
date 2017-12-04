package com.etcxm.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class prodTest {
	public static void main(String[] args)  {
		
		try {
			//1.加载jar包
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.获取连接对象
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			
			CallableStatement call = conn.prepareCall("{call prod_adddept(?,?,?)}");
			call.setInt(1, 60);
			call.setString(2, "研发部");
			call.setString(3, "北京");
			
			
			call.executeUpdate();
//			5.释放
			call.close();
			conn.close();
			System.out.println("插入成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
