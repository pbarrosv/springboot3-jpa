package com.proyect.springboot.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyect.springboot.jpa.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

	List<Person> findByProgramingLanguage(String programingLanguage);
	
	@Query("select p from Person p where p.programingLanguage=?1 and p.name=?2")
	List<Person> BuscarByProgramingLanguage(String programingLanguage, String name);
	
	List<Person> findByProgramingLanguageAndName(String programingLanguage, String name);
	
	@Query("select p.name, p.programingLanguage from Person p")
	List<Object[]> obtenerPersonData();
}
