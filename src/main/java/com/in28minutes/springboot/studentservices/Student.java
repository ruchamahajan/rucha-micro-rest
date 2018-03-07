package com.in28minutes.springboot.studentservices;

import java.util.Date;
import java.util.Map;
import java.util.Set;

public class Student {

	private String firstName;
	private String lastName;
	private String rollNo;
	private String branchName;
	private Date dateOfBirth;
	private Date registrationDate;
	private String imageUrl;
	
	private Set<Course> coursesEnrolled;
	
	private Map<Course, Double> coursesAndMarks;


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Set<Course> getCoursesEnrolled() {
		return coursesEnrolled;
	}

	public void setCoursesEnrolled(Set<Course> coursesEnrolled) {
		this.coursesEnrolled = coursesEnrolled;
	}

	public Map<Course, Double> getCoursesAndMarks() {
		return coursesAndMarks;
	}

	public void setCoursesAndMarks(Map<Course, Double> coursesAndMarks) {
		this.coursesAndMarks = coursesAndMarks;
	}

}
