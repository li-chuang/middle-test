package com.lichuang.jdbc.bean;

//课程
public class Course {
	
	private String id;
	private String name;
	private String score;//学分
	private String costHour;//课时
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
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getCostHour() {
		return costHour;
	}
	public void setCostHour(String costHour) {
		this.costHour = costHour;
	}
	

	

}
