package com.etcxm.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etcxm.entity.Student;
import com.etcxm.utils.JDBCUtils;

public class StudentDao {
	//创建一个JDBC
	private JDBCUtils util = new JDBCUtils();

	public StudentDao() {
		util.getConnection();
	}
	
	
//	查找  多个人
	public List<Student> students() throws Exception{
		String sql = "SELECT * FROM t_student";
		List<Student> list = util.findMoreRefResult(sql, null, Student.class);
		util.releaseConn();
		return list;
		
	}
	//查询 单个人
	public Student queryStu(Long id) throws Exception{
		//Long 引用类型   null
		//long  基本类型  0
		
		String sql = "SELECT * FROM t_student  WHERE id = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		Student result = util.findSimpleRefResult(sql, params, Student.class);
		util.releaseConn();
		return result;
		
	}
	
	//删除
	public boolean deleteStu(Long idStr) throws Exception{
		String sql = "DELETE FROM t_student WHERE id = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(idStr);
		boolean flag =  util.updateByPreparedStatement(sql, params);
		util.releaseConn();
		return flag;
	}
	
	//添加
	public boolean addStu(Student stu) throws Exception{
		String sql = "INSERT INTO t_student VALUES(null,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(stu.getName());
		params.add(stu.getAge());
		boolean flag =  util.updateByPreparedStatement(sql, params);
		util.releaseConn();
		return flag;
	}
	
	
	//修改
	public boolean updateStu(Student stu) throws Exception {
		String sql = "UPDATE t_student SET name=?,age=? WHERE id = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(stu.getName());
		params.add(stu.getAge());
		params.add(stu.getId());
		boolean flag = util.updateByPreparedStatement(sql, params);
		util.releaseConn();
		return flag;
	}
	
}
