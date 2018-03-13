package com.in28minutes.springboot.studentservices;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {

	@Id
	private Integer courseId;
	private String courseName;
	private Integer courseCredit;
	private Double courseFees;
	private String branchName;

	public String getBranchName() {
		return branchName;
	}
	
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public Integer getCourseNumber() {
		return courseId;
	}
	
	public void setCourseNumber(Integer courseNumber) {
		this.courseId = courseNumber;
	}
	
	public Integer getCourseCredit() {
		return courseCredit;
	}
	
	public void setCourseCredit(Integer courseCredit) {
		this.courseCredit = courseCredit;
	}
	
	public Double getCourseFees() {
		return courseFees;
	}
	
	public void setCourseFees(Double courseFees) {
		this.courseFees = courseFees;
	}

}
