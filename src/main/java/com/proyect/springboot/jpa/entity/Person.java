package com.proyect.springboot.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="persons")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "")
	private String name;
	private String lastname;
	
	@Column(name="programing_language")
	private String programingLanguage;
	
	public Person() {
		super();
	}

	public Person(Long id, String name, String lastname, String programingLanguage) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.programingLanguage = programingLanguage;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLastname() {
		return lastname;
	}

	public String getProgramingLanguage() {
		return programingLanguage;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setProgramingLanguage(String programingLanguage) {
		this.programingLanguage = programingLanguage;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", lastname=" + lastname + ", programingLanguage="
				+ programingLanguage + "]";
	}
	
	
}
