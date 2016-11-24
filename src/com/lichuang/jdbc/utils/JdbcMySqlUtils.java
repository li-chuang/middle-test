package com.lichuang.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcMySqlUtils {

	public static String url="jdbc:mysql://localhost:3306/jdbc";
	public static String user="root";
	public static String password = "";
	
	private JdbcMySqlUtils(){
		
	}
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception{
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void free(ResultSet rs, Statement st, Connection conn){
		try {
			if(rs != null){
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(st != null){
					st.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			} finally{
				try {
					if(conn !=null){
						conn.close();
					}
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		}
	}
	
	public static void free(ResultSet rs, PreparedStatement ps){
		try {
			if(ps != null){
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs !=null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws Throwable {
		System.out.println(JdbcMySqlUtils.getConnection());
	}
}
