package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.repository.OneToOneRepository;

@RestController
@RequestMapping("/OneToOneMapping")
public class OneToOneController {
	
	
	 @Autowired 
	 OneToOneRepository onetooneRepository;
	 
	 //=======one to one unidirectional mapping
	 
	/* @PostMapping("/address/save")
	 public Address createAddress(@Valid @RequestBody Address address)
	 {
		 Student student=address.getParent();
		 Address newAddress=new Address();
		 System.out.println(student.toString());
		 newAddress.setAddressId(address.getAddressId());
		 newAddress.setPlace(address.getPlace());
		 newAddress.setParent(student);
		return onetooneRepository.save(newAddress);
		 
	 
	 }
	 @GetMapping("/address/get")
	 public ResponseEntity<Address> getAddress(@RequestParam Long addressid) throws ResourceNotFoundException
	 {
		 
		 
		 Address address = onetooneRepository.findById(addressid)
		          .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id :: " + addressid));
		 Student student=address.getParent();
		 System.out.println(student);
	
		 Address originalAddress=new Address();
		
		 originalAddress.setParent(student);
		 System.out.println(address.getAddressId());
		 System.out.println(address.getPlace());
		 originalAddress.setAddressId(address.getAddressId());
		 originalAddress.setPlace(address.getPlace());
		 
		 
		 return ResponseEntity.ok().body(originalAddress);
		 
	 }*/
	 
	
		
}
