package com.lichuang.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lichuang.jdbc.bean.Manager;
import com.lichuang.jdbc.bean.Student;
import com.lichuang.jdbc.bean.Teacher;
import com.lichuang.jdbc.dao.ILoginDao;

public class LoginDaoJdbcImpl implements ILoginDao {

	@Override
	public Student studentLogin(Connection conn, String username,
			String password) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student student = null;
		String sql = "select * from t_student where name =? and password =? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			while(rs.next()){
				student = new Student();
				student.setId(rs.getString("id"));
				student.setName(rs.getString("name"));
				student.setPassword(rs.getString("password"));
				student.setSex(rs.getString("sex"));
				student.setBirthday(rs.getString("birthday"));
				student.setSchool(rs.getString("school"));
				student.setDepartment(rs.getString("department"));
				student.setMajor(rs.getString("magor"));
				student.setClasses(rs.getString("classes"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return student;
	}

	@Override
	public Teacher teacherLogin(Connection conn, String username,
			String password) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="";
		Teacher teacher = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()){
				teacher = new Teacher();
				teacher.setId(rs.getString("id"));
				teacher.setName(rs.getString("name"));
				teacher.setPassword(rs.getString("password"));
				teacher.setSex(rs.getString("sex"));
				teacher.setBirthday("birthday");
				teacher.setCourse(rs.getString("course"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return teacher;
	}

	@Override
	public Manager managerLogin(Connection conn, String username,
			String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registManager(Manager manager) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStudentInfo(Connection conn, String username,
			String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTeacherInfo(Connection conn, String username,
			String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateManagerInfo(Connection conn, String username,
			String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}

