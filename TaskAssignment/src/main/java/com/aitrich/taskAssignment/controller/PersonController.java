package com.aitrich.taskAssignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aitrich.taskAssignment.domain.Person;
import com.aitrich.taskAssignment.service.PersonService;

@RestController
@RequestMapping("Person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	@GetMapping("/")
	public String index()
	{
		return "WELCOME !";
	}
	
	@PostMapping("add")
	public String add(@RequestBody Person person)
	{
		personService.add(person);
		
		return null;
		
	}
	
	@PostMapping("update")
	public String update(@RequestBody Person person)
	{
		personService.update(person);
		
		return null;
		
	}
	
	@GetMapping("findAll")
	public List<Person> find()
	{
		List<Person> person =personService.findAllPerson();
		
		return person;
		
	}
	
	
	
	@DeleteMapping("/{id}")
	public void deletePerson(@PathVariable int id) {

		personService.delete(id);
	}
	
}
