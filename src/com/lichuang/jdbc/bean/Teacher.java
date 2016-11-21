package com.lichuang.jdbc.bean;

public class Teacher {
	
	private String id;//工号
	private String name;
	private String password;
	private String sex;
	private String birthday;
	private String course;//课程方向
	
	public Teacher(){
		
	}
	
	public Teacher(String id, String name, String password, String sex,
			String birthday, String course) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.course = course;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
