package com.etcxm.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

public class cursorTest {
	public static void main(String[] args)  {
		
		try {
			//1.加载jar包
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.获取连接对象
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			
			CallableStatement call = conn.prepareCall("{call like_package2.getempbylike(?,?)}");
			call.setString(1, "S");
			//----注册时OracleTypes
			call.registerOutParameter(2, OracleTypes.CURSOR);
			
			call.execute();
			
			ResultSet set = (ResultSet)call.getObject(2);
			
			while(set.next()){
				String empno = set.getString("empno");
				String ename = set.getString("ename");
				System.out.println(empno+"...."+ename);
			}
			
//			5.释放
			set.close();
			call.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
