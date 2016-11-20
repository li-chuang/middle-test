package com.lichuang.jdbc.bean;

public class Student {

	private String id;//学号
	private String name;
	private String password;
	private String sex;
	private String age;
	private String department;//院系
	private String major;//专业
	private String classes;//年级
	
	public Student(){
		
	}
	
	public Student(String id, String name, String password, String sex,
			String age, String department, String major, String classes) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.department = department;
		this.major = major;
		this.classes = classes;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}


}
