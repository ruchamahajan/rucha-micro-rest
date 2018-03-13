package com.in28minutes.springboot.studentservices;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class StudentService {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	List<Students> getStudents() {
		List<Students> students = null;
		Query query = entityManager.createNamedQuery(
				"query_find_all_users", Students.class);
		students = query.getResultList();
		return students;
	}

	Students getStudent(Integer rollNo) {
		Students stu = entityManager.find(Students.class, rollNo);
		return stu;
	}

	Boolean updateStudent(Integer rollNo, Students newStudent) {
		entityManager.persist(newStudent);
		return true;
	}

	Boolean addStudent(Students newStudent) {

		entityManager.persist(newStudent);

		return true;
	}

	Boolean deleteStudent(Integer rollNo) {
		Students stu = entityManager.find(Students.class, rollNo);
		entityManager.remove(stu);
		return true;
	}
}
