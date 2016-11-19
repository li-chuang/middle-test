package com.lichuang.jdbc.bean;

//管理员
public class Manager {

	private String username;
	private String password;
	private String level; //管理员级别(root、高级、一般)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	
	
}
