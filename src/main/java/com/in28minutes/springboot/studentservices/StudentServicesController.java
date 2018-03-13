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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentServicesController {

	@Autowired 
	StudentService studentService;

	
    @PutMapping
    @ResponseBody
    public Boolean addStudent(@RequestBody Student student) {
    		return studentService.addStudent(student);
    		 
    }
	
	@GetMapping("/students")
	@ResponseBody
	public List<Student> getStudents() {

		return studentService.getStudents();
	}
	
	@PostMapping("/student/rollNo") 
	@ResponseBody
	public Boolean updateStudent(@RequestBody Student student) {

		return studentService.updateStudent(rollNo);
	}
	
	@DeleteMapping("/student/rollNo")
	public Boolean deleteStudent(@RequestBody Integer rollNo) {
		return studentService.deleteStudent(rollNo);
	}
	
}

