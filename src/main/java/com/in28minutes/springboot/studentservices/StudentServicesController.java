package com.in28minutes.springboot.studentservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentServicesController {

	@GetMapping("/students")
	@ResponseBody
	public List<Student> getStudents() {

		Connection conn = getConnection();
		
		// TODO spring hibernate
		
		List<Student> students = new ArrayList<Student>();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			Boolean status = stmt.execute("select * from students");
			if(status) {
				ResultSet result = stmt.getResultSet(); 
				Student stud = new Student();
				while(result.next()) {
					stud.setRollNo(result.getInt(0));
					stud.setFirstName(result.getString(1));
					stud.setLastName(result.getString(2));
					stud.setBranchName(result.getString(3));
					stud.setImageUrl(result.getString(4));
					stud.setDateOfBirth(result.getDate(5));
					stud.setRegistrationDate(result.getDate(6));
					stud.setSemester(result.getInt(7));
					stud.setEmail(result.getString(8));
					students.add(stud);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		String server = "localhost";
		String port = "3306";
		String database = "sudentschema";
		String user = "root";
		String pwd = "root123";
		try {
			conn = DriverManager.getConnection("jdbc:mysql://" 
												+ server 
												+ "" 
												+ port 
												+ "/" 
												+ database 
												+ "?profileSQL=true\r\n",
												user, pwd);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return conn;
	}
}
