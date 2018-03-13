package com.in28minutes.springboot.studentservices;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


	@PutMapping("/student/")
	@ResponseBody
	public ResponseEntity<String> addStudent(@RequestBody Student newStudent) {
		Boolean status = studentService.addStudent(newStudent);

		if (status) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/students")
	@ResponseBody
	public List<Student> getStudents() {

		return studentService.getStudents();
	}

	@PostMapping("/student/{rollNo}")
	public ResponseEntity<String> updateStudent(
			@PathVariable Integer rollNo, @RequestBody Student newStudent) {

		Boolean status = studentService.updateStudent(rollNo, newStudent);
		if (status) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/student/{rollNo}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer rollNo) {
		Boolean status = studentService.deleteStudent(rollNo);

		if (status) {
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

}

