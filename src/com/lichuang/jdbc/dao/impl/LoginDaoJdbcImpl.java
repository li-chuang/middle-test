package com.lichuang.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lichuang.jdbc.bean.Manager;
import com.lichuang.jdbc.bean.Student;
import com.lichuang.jdbc.bean.Teacher;
import com.lichuang.jdbc.dao.ILoginDao;
import com.lichuang.jdbc.util.JdbcMySqlUtils;

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
		} finally{
			JdbcMySqlUtils.free(rs, ps);
		}				
		return student;
	}

	@Override
	public Teacher teacherLogin(Connection conn, String username,
			String password) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="select * from t_teacher where name =? and password = ? ";
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
		} finally{
			JdbcMySqlUtils.free(rs, ps);
		}			
		return teacher;
	}

	@Override
	public Manager managerLogin(Connection conn, String username,
			String password) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="select * from t_manager where name =? and password = ?";
		Manager manager = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()){
				manager = new Manager();
				manager.setUsername(rs.getString("username"));
				manager.setPassword(rs.getString("password"));
				manager.setLevel(rs.getString("level"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcMySqlUtils.free(rs, ps);
		}
		return manager;
	}

	/**
	 * 管理员身份可开通，也可以先注册后开通
	 */
	@Override
	public int registManager(Connection conn, Manager manager) {
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "insert into t_manager(username,password,level) values (?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, manager.getUsername());
			ps.setString(2, manager.getPassword());
			ps.setString(3, manager.getLevel());
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcMySqlUtils.free(ps);
		}
		return rs;
	}

	//修改密码
	@Override
	public int updateStudentInfo(Connection conn, String username,
			String password) {
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "update t_student set password = ? where username =? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, username);
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcMySqlUtils.free(ps);
		}	
		return rs;
	}
	
	//修改密码
	@Override
	public int updateTeacherInfo(Connection conn, String username,
			String password) {
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "update t_teacher set password =? where username = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, username);
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcMySqlUtils.free(ps);
		}		
		return rs;
	}

	//修改密码
	@Override
	public int updateManagerInfo(Connection conn, String username,
			String password) {
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "update t_manager set password = ? where username = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, username);
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcMySqlUtils.free(ps);
		}
		return rs ;
	}

	

}
