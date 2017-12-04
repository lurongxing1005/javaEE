package com.etcxm.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class prodgetEmpCountTest {
	public static void main(String[] args)  {
		
		try {
			//1.加载jar包
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.获取连接对象
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			
			//3.获取语句对象
			CallableStatement call = conn.prepareCall("{call getempcount(?,?)}");
			call.setInt(1, 30);
			
			//设置输入的类型OutParameter
			call.registerOutParameter(2, Types.INTEGER);
			
			call.execute();
			
			//获取返回的参数
			int count = call.getInt(2);
			System.out.println("个数:"+count);
			
			
			
			
//			5.释放
		
			conn.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
