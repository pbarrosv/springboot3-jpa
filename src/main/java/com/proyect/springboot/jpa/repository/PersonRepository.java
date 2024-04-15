package com.proyect.springboot.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyect.springboot.jpa.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

	/**JPQL instanciación dinámica de clase entity personalizada**/
	@Query("select new Person(p.name, p.lastname) from Person p")
	List<Person> findAllObjectPersonPersonalized();
	
	/******JPQL campos personalizados***********/
	@Query("select p.name from Person p where p.id=?1")
	String getNameById(Long id);
	
	@Query("select concat(p.name, ' ', p.lastname) as fullname from Person p where p.id=?1")
	String getFullNameById(Long id);
	
	/*******************************************/
	@Query("select p from Person p where p.id=?1")
	Optional<Person> findOne(Long id);
	
	@Query("select p from Person p where p.name=?1")
	Optional<Person> findOneName(String name);
	
	@Query("select p from Person p where p.name like %?1%")
	Optional<Person> findOneLikeName(String name);
	
	Optional<Person> findByName(String name);
	//Containin hace un Like
	Optional<Person> findByNameContaining(String name);
	
	List<Person> findByProgramingLanguage(String programingLanguage);
	
	@Query("select p from Person p where p.programingLanguage=?1 and p.name=?2")
	List<Person> BuscarByProgramingLanguage(String programingLanguage, String name);
	
	List<Person> findByProgramingLanguageAndName(String programingLanguage, String name);
	
	@Query("select p.name, p.programingLanguage from Person p")
	List<Object[]> obtenerPersonData();
	
	@Query("select p.id, p.name, p.lastname, p.programingLanguage from Person p")
	List<Object[]> obtenerPersonDataList(); 
	
	/*No Optional de Object[]*/
	@Query("select p.id, p.name, p.lastname, p.programingLanguage from Person p where p.id=?1")
	Optional<Object> obtenerPersonDataById(Long id);
	
	/**/
	@Query("select p.programingLanguage, p from Person p")
	List<Object[]> findAllMixPerson();
}
