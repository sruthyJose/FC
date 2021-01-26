package com.aitrich.taskAssignment.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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
import com.aitrich.taskAssignment.domain.Task;
import com.aitrich.taskAssignment.domain.TypeStatus;

@ExtendWith(SpringExtension.class)
public class TaskServiceTest {
	
	@InjectMocks
	TaskService taskService;
	
	@InjectMocks
	PersonService personService;

	@Mock
	TaskDao taskDao;
	@Mock
	PersonDao personDao;
	
	
	
	
	
	public TaskServiceTest()
	{
	taskDao=mock(TaskDao.class);
	personDao=mock(PersonDao.class);
	personService=new PersonServiceImpl(personDao);
	taskService=new TaskServiceImplement(taskDao,personDao,personService);
	
	}
	
//	@Test
//	public void taskUpdate() {
//
//	Task task=new Task(1,"Addingg","Adding datas",new Person(1,"aa","aa","aaa"),TypeStatus.ASSIGNED);
//	taskService.update(task);
//	verify(taskDao).save(task);
//	}
//
//
//	@Test
//	  public void testTaskDeleteById() {
//	      int id=42;
//	      taskService.delete(id);
//	      verify(taskDao, times(1)).deleteById(id);;
//	  }



//	@Test
//	public void taskInsertTestWithPersonId() {
//	Person p = new Person(0,"string","string","string");
//	Task task=new Task(1,"Add","Adding datas",new Person(1,"abc","def","ghi"),TypeStatus.ASSIGNED);
//	taskService.add(task);
//	verify(taskDao).save(task);
//	}


//	@Test
//	public void testTaskFindAll() {
//	List task_list = new LinkedList();
//
//	task_list.add(new Task(1,"Task_description","Task_name",new Person(1,"Tom","tom","tom@123"),TypeStatus.DONE));
//	task_list.add(new Task(2,"TaskDetails","Task_name",new Person(2,"Jerry","jerry","jerryn@123"),TypeStatus.DONE));
//	when(taskDao.findAll()).thenReturn(task_list);
//	List result = taskService.findAllTask();
//	verify(taskDao).findAll();
//	}


	@Test
	public void testTaskFindAllPerson() {


	List<Person> person_list=new ArrayList<Person>();
	List<Task> task_list= new ArrayList<Task>();
	task_list.add((new Task(1,"Task_description","Task_name",new Person(1,"vinaya","km","vinaya@123"),TypeStatus.DONE)));

	when(taskDao.taskList()).thenReturn(task_list);  
	List result = taskService.findAvailable();
	verify(taskDao).taskList();

	}





	}



