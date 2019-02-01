package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Examtype;
import com.example.demo.model.Result;
import com.example.demo.repository.ResultRepository;

@RestController
@RequestMapping("/results")
public class ResultController {
	
	
	@Autowired
	ResultRepository resultRepository;
	
	//adding the results only once
	@PostMapping("/addresult")
	public Examtype addResult(@Valid @RequestBody Examtype examtype)
	{
		System.out.println("traceing");
		Examtype originalExamtype=new Examtype();
		Set<Result> setofResults=examtype.getChildren();
		Result result=new Result();
		
				
		Set<Result> setResult=new HashSet();	
	
	for (Result tempResult : setofResults) {
			result.setStudentRank(tempResult.getStudentRank());
		
		setResult.add(tempResult);
		}
	
		originalExamtype.setChildren(setResult);
		originalExamtype.setId(examtype.getId());
		originalExamtype.setExampType(examtype.getExampType());
		return resultRepository.save(originalExamtype);
		
	}
		
}
