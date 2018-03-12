package com.in28minutes.springboot.studentservices;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServicesControllerTests {

	@Autowired
	private StudentServicesController stuController;
    private Connection conn = null;
	
	
	@Test
	public void testConnection() {
		
		conn = stuController.getConnection();
		
		if (conn != null) {
			System.out.println("Connection OK");
		} else {
			System.out.println("Connection Failed");
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getStudentResultSet() {
		List<Student> students = null;
		conn = stuController.getConnection();
		if (conn != null) {
			students = stuController.getStudents();
		}
		
		if(students != null && students.size() > 0) {
			System.out.println("Found " + students.size() + " records");
		} else {
			System.out.println("Failed to get students");
		}
	}
 
}
