package com.proyect.springboot.jpa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.springboot.jpa.entity.Person;
import com.proyect.springboot.jpa.repository.PersonRepository;

@RestController
@RequestMapping("/app/person")
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	@GetMapping("/{id}")
	public String getInfo(@PathVariable Long id) {
		return personRepository.getNameById(id);
	}

	@GetMapping("/fullname/{id}")
	public String getFullNameById(@PathVariable Long id) {
		return personRepository.getFullNameById(id);
	}

	@GetMapping("/obtname/{id}")
	public Optional<Object> obtPersonDataById(@PathVariable Long id) {
		return personRepository.obtenerPersonDataById(id);
	}

	@GetMapping("/listobtname")
	public List<Object[]> listaobtPersonDataById() {
		return personRepository.obtenerPersonDataList();
	}

	@GetMapping("/listMixname")
	public List<Object[]> findAllMixPerson() {
		return personRepository.findAllMixPerson();
	}

	@GetMapping("/listPersonalized")
	public List<Person> finPersonPersonalized() {
		return personRepository.findAllObjectPersonPersonalized();
	}

	@GetMapping("/listPersonDto")
	public List<Person> findAllPersonDto() {
		return personRepository.findAllObjectPersonPersonalized();
	}

	@PostMapping("/save")
	public Person savePerson(@RequestBody Person p) {
		return personRepository.save(p);
	}

	@PutMapping("/update/{id}")
	public Person updatePerson(@RequestBody Person p, @PathVariable Long id) {
		
		Person UpdateP = personRepository.findById(id).get();
		UpdateP.setName(p.getName());
		UpdateP.setLastname(p.getLastname());
		UpdateP.setProgramingLanguage(p.getProgramingLanguage());
		
		
		return personRepository.save(UpdateP);
	}
}
