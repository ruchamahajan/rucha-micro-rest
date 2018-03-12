package com.in28minutes.springboot.studentservices;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

	
	List<Student> getStudents() {
		List<Student> students = new ArrayList<Student>();
		
		return students; 
	}
	
	Student getStudent(Integer rollNo) {
		Student stu = new Student();
		
		return stu;
	}
	
	Boolean updateStudent(Integer rollNo) {
		
		return true;
	}
	
	Boolean addStudent(Student student) {
		
		return true;
	}
	
	Boolean deleteStudent(Integer rollNo) {
		
		return true;
	}
}
