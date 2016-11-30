package com.lichuang.jdbc.dao.impl;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lichuang.jdbc.util.JdbcMySqlUtils;

public class StudentDaoJdbcImplTest {

	@Before
	public void setUp() {
		IDatabaseConnection connection = null;
		try {
			//获得连接
			Connection conn = JdbcMySqlUtils.getConnection();
			connection = new DatabaseConnection(conn);
			
			//将指定数据库中的的数据备份
			QueryDataSet backupDataSet = new QueryDataSet(connection);
			backupDataSet.addTable("t_student");			
			//File file = File.createTempFile("student_bak", ".xml");
			FlatXmlDataSet.write(backupDataSet, new FileOutputStream(new File("student_bak.xml")));
			
//			//将准备好的文件读入
			IDataSet dataSet = new FlatXmlDataSet(new File("student_pre.xml"));
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
		Connection conn = JdbcMySqlUtils.getConnection();
		connection = new DatabaseConnection(conn);
		
		//将数据库中原有的数据导入进去
		IDataSet dataSet = new FlatXmlDataSet(new File("student_bak.xml"));
		DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
		
	}

	@Test
	public void testGetStudent() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertStudent() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateStudent() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteStudent() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertBatch() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteBatch() {
		fail("Not yet implemented");
	}

}

