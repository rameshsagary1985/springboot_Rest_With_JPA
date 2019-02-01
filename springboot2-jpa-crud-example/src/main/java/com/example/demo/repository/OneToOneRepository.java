package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Address;

@Repository
//before writting any repository it should be  prefex with model name
public interface OneToOneRepository extends JpaRepository<Address, Long> {

	




	

	

}
