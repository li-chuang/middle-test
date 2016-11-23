package com.lichuang.jdbc.dao;

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
	
	public Student studentLogin();
	
	public Teacher teacherLogin();
	
	public Manager managerLogin();
	
	public int registManager(Manager manager);
	
	public int updateStudentInfo();
	
	public int updateTeacherInfo();
	
	public int updateManagerInfo();

}
