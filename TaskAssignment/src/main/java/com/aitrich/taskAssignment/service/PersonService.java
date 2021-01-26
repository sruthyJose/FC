package com.aitrich.taskAssignment.service;

import java.util.List;

import com.aitrich.taskAssignment.domain.Person;



public interface PersonService {
	
	public void add(Person person);
	public void delete(int id);
	public void update(Person person);
	public List<Person> findAllPerson();

}
