package com.in28minutes.springboot.studentservices;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class StudentServicesController {

	@Autowired 
	StudentRepository studentRep;


	@PutMapping("/student/")
	@PreAuthorize("hasAuthority('ADMIN')")
	@ResponseBody
	public ResponseEntity<String> addStudent(@RequestBody Students newStudent) {
		Students addedStudents = studentRep.save(newStudent);

		if (addedStudents != null) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/students")
	@ResponseBody
	public ResponseEntity<String> getStudents() {
	    Gson gson = new Gson();
	
		Iterable<Students> studentList = studentRep.findAll();
		ArrayList<Students> returnList = new ArrayList<Students>();
		studentList.forEach(returnList::add);
	    String jsonList = gson.toJson(studentList);
	    return ResponseEntity.status(HttpStatus.OK).body(jsonList);

	}

	@GetMapping("/student/{rollNo}")
	@ResponseBody
	public ResponseEntity<String> getStudent(@PathVariable Integer rollNo) {
	    Gson gson = new Gson();
		Optional<Students> stu = studentRep.findById(rollNo); 
		if(stu.isPresent()) {
			String jsonOut = gson.toJson(stu.get());
		    return ResponseEntity.status(HttpStatus.FOUND).body(jsonOut);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	
	@PostMapping("/student/{rollNo}")
	public ResponseEntity<String> updateStudent(
			@PathVariable Integer rollNo, @RequestBody Students newStudent) {

		Optional<Students> stu = studentRep.findById(rollNo);
		if(stu.isPresent()) {
			studentRep.save(newStudent);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@DeleteMapping("/student/{rollNo}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer rollNo) {
		Optional<Students> stu =studentRep.findById(rollNo);
		if (stu.isPresent()) {
			studentRep.delete(stu.get()); 
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}

