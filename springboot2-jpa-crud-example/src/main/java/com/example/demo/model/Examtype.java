package com.example.demo.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name="ExamType")
@Data
public class Examtype implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	
	 @Column(name = "EXAM_ID")
	private Long id;
	@Column(name="EXAM_TYPE")
	private String exampType;
	
	
	@OneToMany(fetch= FetchType.LAZY,targetEntity=Result.class,cascade=CascadeType.ALL)
	@JoinColumn(name="EExamid",referencedColumnName="EXAM_ID")
	 //@JsonIgnore
	private Set<Result> children;
	
	@OneToMany(fetch=FetchType.LAZY,targetEntity=Subject.class,cascade=CascadeType.ALL)
	@JoinColumn(name="Examid_Subjid",referencedColumnName="EXAM_ID")
	private Set<Subject> subjects;
	

}
