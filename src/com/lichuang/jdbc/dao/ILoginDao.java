package com.lichuang.jdbc.dao;

import java.sql.Connection;

import com.lichuang.jdbc.bean.Manager;
import com.lichuang.jdbc.bean.Student;
import com.lichuang.jdbc.bean.Teacher;

/**
 * 1.学生登录
 * 2.老师登录
 * 3.管理员登录
 * 4.管理员注册
 * 5.学生修改密码
 * 6.老师修改密码
 * 7.管理员修改密码
 *
 */
public interface ILoginDao {
	
	public Student studentLogin(Connection conn, String username,String password);
	
	public Teacher teacherLogin(Connection conn, String username,String password);
	
	public Manager managerLogin(Connection conn, String username,String password);
	
	public int registManager(Connection conn, Manager manager);
	
	public int updateStudentInfo(Connection conn, String username,String password);
	
	public int updateTeacherInfo(Connection conn, String username,String password);
	
	public int updateManagerInfo(Connection conn, String username,String password);

}
