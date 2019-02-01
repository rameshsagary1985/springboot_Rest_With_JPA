package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Address;
import com.example.demo.model.Student;
import com.example.demo.repository.OneToOneRepository;
import com.example.demo.repository.StudentRepository;
@RestController
@RequestMapping("/bidirectionalonetoonemapping")
public class OneToOneBiDirectionalController {
	
	@Autowired 
	 OneToOneRepository onetooneRepository;
	
	@Autowired
	
	StudentRepository studentRepository;
	
	 //==========one to one bidirectional mapping
	 
		// Reference link:http://websystique.com/hibernate/hibernate-one-to-one-bidirectional-with-shared-primary-key-annotation-example/
		 //1. first create the student and address tables with primary and foreign key
		 //2. create the two model classes
		 //3. Now create the Student as a property and address as a property in both models.which means both are in bidirection.
		 //4.Student is the owner of this relationship 
		 
	
	@PostMapping
	 public Address createAddress(@Valid @RequestBody Address address)
	 {
		 Student newstudent=new Student();
		 Address newAddress=new Address();
		 newstudent=address.getParent();
	
		// System.out.println(student.toString());
		 newAddress.setCity(address.getCity());
		 newAddress.setCountry(address.getCountry());
		 newAddress.setStreet(address.getStreet());
		 newAddress.setParent(newstudent);
	System.out.println(newAddress);
	return onetooneRepository.save(newAddress);
	
	
		 
	 }
	 @GetMapping
	 public ResponseEntity<Address> getAddress(@RequestParam Long addressid) throws ResourceNotFoundException
	 {
		 Address address=	onetooneRepository.findById(addressid)
				 .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id :: " + addressid));
				 
				Address originalAddress=new Address();
				Student originalStudent=address.getParent();
				originalAddress.setId(address.getId());
				originalAddress.setCity(address.getCity());
				originalAddress.setCountry(address.getCountry());
				originalAddress.setStreet(address.getStreet());
				originalAddress.setParent(originalStudent);
		 System.out.println(originalAddress);
		 return ResponseEntity.ok().body(originalAddress);
		 
	 }
	 @GetMapping("getStudentByName")
	 public ResponseEntity<List<Student>> getStudent(@RequestParam String firstName)
	 {
		List<Student> student= studentRepository.findByfirstName(firstName);
		List<Student> studentList= new ArrayList<Student>(); 
	for (Student studentObj : student)
	{
		studentList.add(studentObj);
	}
	
		 System.out.println(studentList);
		return ResponseEntity.ok().body(studentList);
		 
	 }
	 
	 @GetMapping("getStudentBySecondName")
	 public ResponseEntity<List<Student>> getStudentbylastName(@RequestParam String lastName)
	 {
		List<Student> lastnameStudents= studentRepository.findBylastName(lastName);
		List<Student> studentList= new ArrayList<Student>(); 
	for (Student studentObj : lastnameStudents)
	{
		studentList.add(studentObj);
	}
	
		 System.out.println(studentList);
		return ResponseEntity.ok().body(studentList);
		 
	 }
	 
	 
	
	
	

}
