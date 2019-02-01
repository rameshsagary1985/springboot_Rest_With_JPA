package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Examtype;
import com.example.demo.model.Result;
@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

	Examtype save(Examtype originalExamtype);

}
