package com.lichuang.jdbc.dao.impl;


import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.lichuang.jdbc.bean.Student;
import com.lichuang.jdbc.util.JdbcMySqlUtils;

public class StudentDaoJdbcImplTest {
	
	StudentDaoJdbcImpl dao = new StudentDaoJdbcImpl();
	//Connection connect = null;

	@Before
	public void setUp() {
		IDatabaseConnection connection = null;
		try {
			//获得连接
			//Connection conn = JdbcMySqlUtils.getConnection();
			Connection connect = JdbcMySqlUtils.getConnection();
			connection = new DatabaseConnection(connect);
			
			//将指定数据库中的的数据备份
			QueryDataSet backupDataSet = new QueryDataSet(connection);
			backupDataSet.addTable("t_student");			
			//File file = File.createTempFile("student_bak", ".xml");
			FlatXmlDataSet.write(backupDataSet, new FileOutputStream(new File("student_bak.xml")));
			
//			//将准备好的文件读入
			//IDataSet dataSet = new FlatXmlDataSet(new File("student_pre.xml"));
			IDataSet dataSet = new FlatXmlDataSetBuilder().build(new File("student_pre.xml"));
			DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);//先清除后插入
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@After
	public void tearDown() throws Exception {
		//连接数据库
		IDatabaseConnection connection = null;
		//Connection conn = JdbcMySqlUtils.getConnection();
		Connection connect = JdbcMySqlUtils.getConnection();
		connection = new DatabaseConnection(connect);
		
		//将数据库中原有的数据导入进去
		//IDataSet dataSet = new FlatXmlDataSet(new File("student_bak.xml"));
		IDataSet dataSet = new FlatXmlDataSetBuilder().build(new File("student_bak.xml"));
		DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
		
		if(connect !=null){
			connect.close();
		}
	}

	@Test
	public void testGetStudent() {
		try {
			Connection connect = JdbcMySqlUtils.getConnection();
			Map<String,String> map = new HashMap<String,String>();
			map.put("id", "2016301001");
			Student student = dao.getStudent(connect, map);
			Assert.assertEquals("Mike", student.getName());
			Assert.assertEquals("123456", student.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@Test
	public void testInsertStudent() {
		Student student = new Student("2016301003", "Lee", "123456", "Man", "1991-07-15", "math", "computer", "3班", "HBGYDX");
		IDatabaseConnection connection=null;
		try {
			Connection connect = JdbcMySqlUtils.getConnection();
			int result = dao.insertStudent(connect, student);
			Assert.assertNotNull(result);
			
			// 预想结果和实际结果的比较
			// 预期结果取得
			//IDataSet expectedDataSet  = new FlatXmlDataSet(new File("student_exp.xml"));
			IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("student_exp.xml"));
			ITable expectedTable = expectedDataSet.getTable("t_student");
			// 实际取得结果
			connection = new DatabaseConnection(JdbcMySqlUtils.getConnection());
			IDataSet databaseDataSet = connection.createDataSet();
			ITable actualTable = databaseDataSet.getTable("t_student");
			// 比较
			Assert.assertEquals(expectedTable, actualTable);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(connection !=null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void testUpdateStudent() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDeleteStudent() {
		//fail("Not yet implemented");
	}

	@Test
	public void testInsertBatch() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDeleteBatch() {
		//fail("Not yet implemented");
	}

}
