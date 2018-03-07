package com.in28minutes.springboot.studentservices;

public class Course {

	private String courseName;
	private String courseNumber;
	private Integer courseCredit;
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}
	public Integer getCourseCredit() {
		return courseCredit;
	}
	public void setCourseCredit(Integer courseCredit) {
		this.courseCredit = courseCredit;
	}
	
}
