package com.lichuang.jdbc.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.lichuang.jdbc.bean.Student;

/**
 * 
 *
 */
public interface IStudentDao {
	
	public Student getStudent(Connection conn, Map<String,String> map);
	
	public int insertStudent(Connection conn, Student student);
	
	public int updateStudent(Connection conn, Map<String,String> map);
	
	public int deleteStudent(Connection conn, Map<String,String> map);
	
	public int insertBatch(Connection conn, List<Student> list);
	
	public int deleteBatch(Connection conn , List<String> list);

}
