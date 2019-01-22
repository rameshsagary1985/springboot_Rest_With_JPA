package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	//Student findByFirstName(String firstName);

	List<Student> findByfirstName(String firstName);
	List<Student>  findBylastName(String lastName);

}
