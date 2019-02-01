package com.example.demo.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Examtype;
import com.example.demo.model.Subject;
import com.example.demo.repository.SubjectRepository;


@RestController
@RequestMapping("/subjects")
public class SubjectsController {
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@PostMapping("/saveSubject")
	public Subject addSubjects(@Valid @RequestBody Examtype examtype)
	{
		System.out.println("i am from save subject controller");
		Examtype originalExamType=new Examtype();
		Set<Subject> subjectsSet=examtype.getSubjects();
		Subject originalSub=new Subject();
		Set<Subject> setSubjects=new HashSet<>();
		for (Subject subject : subjectsSet) {
			originalSub.setSubjectName(subject.getSubjectName());
			setSubjects.add(originalSub);
		}
		originalExamType.setId(examtype.getId());
		originalExamType.setExampType(examtype.getExampType());
		originalExamType.setSubjects(setSubjects);
		return subjectRepository.save(originalExamType);
	}
	
	
	
	
	

}
