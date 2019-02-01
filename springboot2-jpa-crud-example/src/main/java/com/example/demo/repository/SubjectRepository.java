package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Examtype;
import com.example.demo.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

	Subject save(Examtype originalExamType);

}
