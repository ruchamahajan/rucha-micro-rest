package com.in28minutes.springboot.studentservices;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Students, Integer> {

}
