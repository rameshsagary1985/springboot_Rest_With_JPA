package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@Entity
@Table(name="ADDRESS_BI")
@Data
public class Address implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Address() {
		super();
		
	}


	@Id
	    @Column(name="ADDRESS_ID")
	    @GeneratedValue(generator="gen")
	    @GenericGenerator(name="gen", strategy="foreign",parameters=@Parameter(name="property", value="parent"))
	    private Long id;
	 
	    @Column(name = "STREET")
	    private String street;
	 
	    @Column(name = "CITY")
	    private String city;
	 
	    @Column(name = "COUNTRY")
	    private String country;
	 
	    @JsonIgnoreProperties("child") 
		@OneToOne
	    @PrimaryKeyJoinColumn
	    private Student parent;


		
	
	 
	  
	
}
