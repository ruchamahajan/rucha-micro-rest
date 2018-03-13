package com.in28minutes.springboot.studentservices;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class StudentService {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	List<Student> getStudents() {
		List<Student> students = null;
		Query query = entityManager.createNamedQuery(
				"query_find_all_users", Student.class);
		students = query.getResultList();
		return students;
	}

	Student getStudent(Integer rollNo) {
		Student stu = entityManager.find(Student.class, rollNo);
		return stu;
	}

	Boolean updateStudent(Integer rollNo, Student newStudent) {
		entityManager.persist(newStudent);
		return true;
	}

	Boolean addStudent(Student newStudent) {

		entityManager.persist(newStudent);

		return true;
	}

	Boolean deleteStudent(Integer rollNo) {
		Student stu = entityManager.find(Student.class, rollNo);
		entityManager.remove(stu);
		return true;
	}
}
