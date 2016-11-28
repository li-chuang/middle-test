package com.lichuang.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lichuang.jdbc.bean.Student;
import com.lichuang.jdbc.dao.IStudentDao;
import com.lichuang.jdbc.util.JdbcMySqlUtils;

/**
 * 增删改查以及批量插入，批量删除
 *
 */
public class StudentDaoJdbcImpl implements IStudentDao {

	@Override
	public Student getStudent(Connection conn, Map<String, String> map) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student student = null;
		StringBuffer sql = new StringBuffer("select * from t_student where 1=1 ");
		Set<String> keys = map.keySet();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()){
			String key = iter.next();
			sql.append(" and " + key + " = " + map.get(key));
		}
		
		try {
			ps = conn.prepareStatement(sql.toString());
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
				student.setMajor(rs.getString("major"));
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
	public int insertStudent(Connection conn, Student student) {
		PreparedStatement ps = null;
		int result = 0;
		StringBuffer sql = new StringBuffer("insert t_student(id,name,password,sex,birthday,school,department,major,classes) values ");
		StringBuffer valueSql = new StringBuffer();
		if(student != null){
			valueSql.append("(");
			valueSql.append(student.getId()+",");
			valueSql.append(student.getName()+",");
			valueSql.append(student.getPassword()+",");
			valueSql.append(student.getSex()+",");
			valueSql.append(student.getBirthday()+",");
			valueSql.append(student.getSchool()+",");
			valueSql.append(student.getDepartment()+",");
			valueSql.append(student.getMajor()+",");
			valueSql.append(student.getClasses());
			valueSql.append(")");
		}
		sql.append(valueSql.toString());
		try {
			ps = conn.prepareStatement(sql.toString());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcMySqlUtils.free(ps);
		}	
		return result;
	}

	@Override
	public int updateStudent(Connection conn, Map<String, String> map) {
		PreparedStatement ps = null;
		int rs = 0;
		StringBuffer valueSql = new StringBuffer();
		StringBuffer sql = new StringBuffer("update t_student set ");
		Set<String> set = map.keySet();
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()){
			String key = iter.next();
			valueSql.append(" " + key + "= "+map.get(key));
		}
		sql.append(valueSql.toString()).append("where id = "+map.get("id"));
		try {
			ps = conn.prepareStatement(sql.toString());
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcMySqlUtils.free( ps);
		}	
		return rs;
	}

	@Override
	public int deleteStudent(Connection conn, Map<String, String> map) {
		PreparedStatement ps = null;
		int rs = 0;
		StringBuffer valueSql = new StringBuffer();
		StringBuffer sql = new StringBuffer("delete t_student where ");
		Set<String> set = map.keySet();
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()){
			String key = iter.next();
			valueSql.append(" " + key + "= "+map.get(key));
		}
		sql.append(valueSql.toString());
		try {
			ps = conn.prepareStatement(sql.toString());
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcMySqlUtils.free( ps);
		}	
		return rs;
	}

	@Override
	public int insertBatch(Connection conn, List<Student> list) {
		return 0;
	}

	@Override
	public int deleteBatch(Connection conn, List<String> list) {
		return 0;
	}

}
