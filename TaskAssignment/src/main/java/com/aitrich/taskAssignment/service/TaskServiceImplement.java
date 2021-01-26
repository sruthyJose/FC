package com.aitrich.taskAssignment.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aitrich.taskAssignment.dao.PersonDao;
import com.aitrich.taskAssignment.dao.TaskDao;
import com.aitrich.taskAssignment.domain.Person;
import com.aitrich.taskAssignment.domain.Task;
import com.aitrich.taskAssignment.domain.TypeStatus;

@Service
public class TaskServiceImplement implements TaskService{
	
	@Autowired
	private TaskDao dao;
	@Autowired
	private PersonService personService;

	@Autowired
	private PersonDao personDao;

	@Autowired
	public TaskServiceImplement(TaskDao taskDao, PersonDao personDao, PersonService personService) {
		
		this.dao = taskDao;
		this.personDao= personDao;
		this.personService=personService;
		// TODO Auto-generated constructor stub
	}



	@Override
	public void add(Task task) {
		List<Person> available = findAvailable();
		int flag =1;
		
		
		
		for(Person person :available)
		{
			if(task.getAssignedTo().getId() == person.getId())
			{
				
				task.setStatus(TypeStatus.ASSIGNED);
				dao.save(task);
				System.out.println("Status Updated ans saved");
				flag = 0;
				break;
			}
		
				
			
			
		}
		
		if(flag ==1)
		{
			if(!available.isEmpty()) 
			{
				for(Person person :available)
				{
					task.setAssignedTo(person);
					task.setStatus(TypeStatus.ASSIGNED);
					dao.save(task);
				}
				
			}
			else
			{
				task.setAssignedTo(null);
				dao.save(task);
			}
		}
		 
		
		
	}
	
	

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
		
	}

	@Override
	public void update(Task task) {
		// TODO Auto-generated method stub
		dao.save(task);
		
	}

	@Override
	public List<Task> findAllTask() {
		// TODO Auto-generated method stub
		
		List<Task> taskList =dao.findAll() ;
		

		return taskList;
	}



	@Override
	public List<Person> findAvailable() {
		// TODO Auto-generated method stub
		
		List<Task> list = dao.taskList(); 
		List<Person> personList = personService.findAllPerson();
		
		Set<Person> availablePersonSet = new HashSet<Person>(); 
		
		for(Task task :list)
		{
			
			Iterator<Person> iterator=personList.iterator();
			while(iterator.hasNext())
			{
				Person p=iterator.next();
	
				if(p.getId() == task.getAssignedTo().getId())
				{
					iterator.remove();
				}
			}
		}
		
		
		
		
		return personList;
	}



	
}
