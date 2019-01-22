package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name="Student_BI")
@Data
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;




	public Student()
	{
		
	}
	public Student(long id, String firstName, String lastName, String section) {
	//	super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.section = section;
	}

	
	

	@Id
	    @GeneratedValue
	    @Column(name = "STUDENT_ID")
	    private Long id;
	 
	    @Column(name = "FIRST_NAME")
	    private String firstName;
	 
	    @Column(name = "LAST_NAME")
	    private String lastName;
	 
	    @Column(name = "SECTION")
	    private String section;
	    
	    
	   
	    @JsonIgnoreProperties("parent") 
		@OneToOne(mappedBy="parent" ,cascade=CascadeType.ALL ,fetch=FetchType.LAZY)
	    private Address child;




		@Override
		public String toString() {
			return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", section=" + section
					+ "]";
		}
		public Student(Long id, String firstName, String lastName, String section, Address address) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.section = section;
			this.child = child;
		}
}
