package com.in28minutes.springboot.studentservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentServicesController {

	Connection conn = null;
	
	@Autowired 
	StudentService studentService;

	
    @PostMapping(value = "/{rollno}")
    @ResponseBody
    public Student updateStudent(@PathVariable("rollno") Integer rollNo, @RequestBody Student student) {

    	conn = getConnection();

		Statement statement;
		try {

		      String query = " insert into users (rollNo, firstName, lastName, "
		      				 + "branchName, imageurl, dateofbirth,"
		      				 + "registrationDate, currentSemester, emailId)"
		      				 + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		    	      // create the mysql insert preparedstatement
		    	      PreparedStatement preparedStmt = conn.prepareStatement(query);
		    	      preparedStmt.setInt(1, rollNo);
		    	      preparedStmt.setString(2, "Rubble");
		    	      preparedStmt.setString(3, startDate);
		    	      preparedStmt.setString(4, false);
		    	      preparedStmt.setString(5, 5000);
		    	      preparedStmt.setDate(6, x);
		    	      preparedStmt.setDate(7, );
		    	      preparedStmt.setInt(8, x);
		    	      preparedStmt.setString(9, x);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	return new Student();
    }
	
	
	@GetMapping("/students")
	@ResponseBody
	public List<Student> getStudents() {

		conn = getConnection();
		
		// TODO spring hibernate
		// TODO create connectionpool
		
		List<Student> students = new ArrayList<Student>();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			Boolean status = stmt.execute("select * from students");
			if(status) {
				ResultSet result = stmt.getResultSet(); 
				while(result.next()) {
					Student stud = new Student();
					stud.setRollNo(result.getInt(1));
					stud.setFirstName(result.getString(2));
					stud.setLastName(result.getString(3));
					stud.setBranchName(result.getString(4));
					stud.setImageUrl(result.getString(5));
					stud.setDateOfBirth(result.getDate(6));
					stud.setRegistrationDate(result.getDate(7));
					stud.setSemester(result.getInt(8));
					stud.setEmail(result.getString(9));
					students.add(stud);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return students;
	}
	
	
	
	
	public Connection getConnection() {
		Connection connect = null;
		String server = "localhost";
		String port = "3306";
		String database = "sudentschema";
		String user = "root";
		String pwd = "root123";
		String url = "jdbc:mysql://" + server + ":"  + port + "/" + database ; // + "?profileSQL=true\r\n"
		try {
			connect = DriverManager.getConnection( url,user, pwd);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return connect;
	}
	
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// TODO write testcase to test jdbc connection
