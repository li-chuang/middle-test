package com.lichuang.jdbc.bean;

public class Grade {
	
	private String id;
	private String studentId;
	private String courseId;
	
	public Grade(){
		
	}
	public Grade(String id, String studentId, String courseId) {
		this.id = id;
		this.studentId = studentId;
		this.courseId = courseId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	

}
