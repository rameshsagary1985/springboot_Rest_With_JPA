package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Student;

//before writting any repository it should be  prefex with model name
public interface StudentRepository extends JpaRepository<Student, Long> {

	
	
	//And while writting any method name suffix with properyname

	List<Student> findByfirstName(String firstName);
	List<Student>  findBylastName(String lastName);

}
