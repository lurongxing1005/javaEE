package com.etcxm.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;


//事务
public class prod_transTest {
	public static void main(String[] args) throws Exception  {
		//1.加载jar包
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2.获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		CallableStatement call = conn.prepareCall("{call prod_trans(?,?,?,?)}");
		call.setInt(1, 110);
		call.setInt(2, 200);
		call.setInt(3, 201);
		
		call.registerOutParameter(4, Types.INTEGER);
		
		call.execute();
		
		int result = call.getInt(4);
		if(result==1){
			System.out.println("成功");
		}else{
			System.out.println("失败");
		}
		
		call.close();
		conn.close();
		
		
		
	}

}
