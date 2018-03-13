package com.in28minutes.springboot.studentservices;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
}
