package com.aitrich.taskAssignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aitrich.taskAssignment.dao.PersonDao;
import com.aitrich.taskAssignment.domain.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	
	@Autowired
	private PersonDao dao;
	
	@Autowired
	public PersonServiceImpl(PersonDao personDao) {
	this.dao = personDao;
	}

	@Override
	public void add(Person person) {
		// TODO Auto-generated method stub
		dao.save(person);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public void update(Person person) {
		// TODO Auto-generated method stub
		
		dao.save(person);
		
	}

	@Override
	public List<Person> findAllPerson() {
		// TODO Auto-generated method stub
		System.out.println("person");
		List<Person> person = dao.findAll();
		System.out.println(person);
		return person;
	}
	
	

}
