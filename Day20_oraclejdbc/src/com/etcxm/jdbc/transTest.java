package com.etcxm.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//事务
public class transTest {
	public static void main(String[] args) throws Exception  {
		//1.加载jar包
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2.获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		conn.setAutoCommit(false);
		try {
			
			
			PreparedStatement statement;
			
			//老王 ----》rose   699
			//a.老王 钱-699
			String sql = "update tab_account set balance=balance-699 where account_id=110 ";
			statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			statement.close();
			//b.rose 钱+699
		    sql = "update tab_account set balance=balance+699 where account_id=111 ";
			statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			statement.close();
			//c.插入记录
			 sql = "insert into tab_tranrecord values(?,?,?,?,?) ";
		     statement = conn.prepareStatement(sql);
		     statement.setInt(1, 1103);
		     statement.setInt(2, 110);
		     statement.setInt(3, 111);
		     statement.setInt(4, 699);
		     Date date = new Date(System.currentTimeMillis());
		     statement.setDate(5, date);
		     statement.executeUpdate();
			
			
			
			
//			5.释放
		    conn.commit();
			statement.close();
			conn.close();
			System.out.println("成功");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
				System.out.println("失败");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
