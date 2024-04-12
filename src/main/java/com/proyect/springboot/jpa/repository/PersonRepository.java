package com.proyect.springboot.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.proyect.springboot.jpa.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
