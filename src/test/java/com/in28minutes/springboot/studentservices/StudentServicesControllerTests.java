package com.in28minutes.springboot.studentservices;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServicesControllerTests {

	@Autowired
	private StudentServicesController stuController;

	@Test
	public void getStudentResultSet() {
		ResponseEntity<String> students = stuController.getStudents();
		System.out.println(students.getBody().toString());
	}
	
	@Test
	public void addStudentTest() {
		Students student = new Students();
		
		student.setFirstName("Saket");
		student.setLastName("Sadawarte");
		student.setDateOfBirth(new Date(758782800000L));
		student.setRegistrationDate(new Date(System.currentTimeMillis()));
		student.setEmail("s@g.c");
		student.setImageUrl("C:");
		student.setSemester(1);
		student.setBranchName("Computer Science");
		
		ResponseEntity<String> response = stuController.addStudent(student);
		System.out.println(response.toString());
	}
	
	@Test
	public void deleteStudentTest() {
		ResponseEntity<String> response = stuController.deleteStudent(3);
		System.out.println(response.toString());
	}
	
	@Test
	public void getByRollNoTest() {
		ResponseEntity<String> response = stuController.getStudent(4);
		System.out.println(response.toString());
	}
}
