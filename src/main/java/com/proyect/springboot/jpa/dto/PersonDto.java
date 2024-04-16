package com.proyect.springboot.jpa.dto;

public class PersonDto {
	private String name;
	private String lastname;
	
	public PersonDto() {
	}

	public PersonDto(String name, String lastname) {
		this.name = name;
		this.lastname = lastname;
	}

	public String getName() {
		return name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
}
