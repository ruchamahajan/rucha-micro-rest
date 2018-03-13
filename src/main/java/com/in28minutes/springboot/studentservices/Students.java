package com.in28minutes.springboot.studentservices;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Students {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rollNo;
	private String firstName;
	private String lastName;
	private String branchName;
	private String imageUrl;
	private Date dateOfBirth;
	private Date registrationDate;
	private Integer currentSemester;
	private String emailId;

	public Integer getSemester() {
		return currentSemester;
	}

	public void setSemester(Integer semester) {
		this.currentSemester = semester;
	}

	public String getEmail() {
		return emailId;
	}

	public void setEmail(String email) {
		this.emailId = email;
	}

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

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
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

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", rollNo=" + rollNo + ", branchName="
				+ branchName + ", dateOfBirth=" + dateOfBirth + ", registrationDate=" + registrationDate + ", imageUrl="
				+ imageUrl + ", email=" + emailId + ", semester=" + currentSemester + "]";
	}

}
