package com.lichuang.jdbc.bean;

public class TeacherCourse {
	private String teacherId;
	private String courseId;

	public TeacherCourse() {

	}

	public TeacherCourse(String teacherId, String courseId) {
		this.teacherId = teacherId;
		this.courseId = courseId;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

}
