package com.etcxm.dao;

import java.util.List;

import com.etcxm.entity.Student;

public class DaoTest {
	public static void main(String[] args) throws Exception {
		StudentDao dao = new StudentDao();
		List<Student> students = dao.students();
		System.out.println(students);
	}

}
