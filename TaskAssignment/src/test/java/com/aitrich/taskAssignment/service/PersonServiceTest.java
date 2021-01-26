package com.aitrich.taskAssignment.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.aitrich.taskAssignment.dao.PersonDao;
import com.aitrich.taskAssignment.dao.TaskDao;
import com.aitrich.taskAssignment.domain.Person;

@ExtendWith(SpringExtension.class)
public class PersonServiceTest {
	
	@InjectMocks
	PersonService personService;

	@Mock
	PersonDao personDao;

	public PersonServiceTest()
	{
	personDao=mock(PersonDao.class);
	personService=new PersonServiceImpl(personDao);
	}
	
	@Test
	public void testInertPersonDetails() {
	Person person=new Person(1,"clinton","steephen","clinton12345");
	personService.add(person);
	verify(personDao).save(person);
	}

	@Test
	public void testPersonUpdate() {
	Person person=new Person(1,"mickey","m","12457");
	personService.add(person);
	verify(personDao).save(person);
	}

	@Test
	public void testPersonFindAll() {
	List person_list = new LinkedList();
	person_list.add(new Person(1,"cat","Do","cat@123"));
	person_list.add(new Person(2,"mouse","mouse","username@1457"));
	when(personDao.findAll()).thenReturn(person_list);
	List result = personService.findAllPerson();
	verify(personDao).findAll();
	}

	@Test
	  public void testPersonDeleteById() {
	      int id=42;
	      personService.delete(id);
	      verify(personDao, times(1)).deleteById(id);;
	  }
	}

	
	
	


