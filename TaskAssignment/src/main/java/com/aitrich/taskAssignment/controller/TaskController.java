package com.aitrich.taskAssignment.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aitrich.taskAssignment.domain.Person;
import com.aitrich.taskAssignment.domain.Task;

import com.aitrich.taskAssignment.service.TaskService;

@RestController
@RequestMapping("Task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	
	@GetMapping("/")
	public String index() {
		
		
		return "It's a new Beginning";
	}
	

	@GetMapping("availablePerson")
	public List<Person> available() {
		
		
		return taskService.findAvailable();
	}
	
	@PostMapping("add")
	public String add(@RequestBody Task task)
	{
		
		taskService.add(task);
		
		return null;
		
	}
	
	@PostMapping("update")
	public String update(@RequestBody Task task)
	{
		taskService.update(task);
		
		return null;
		
	}
	
	@GetMapping("findAll")
	public String find()
	{
		taskService.findAllTask();
		
		return null;
		
	}
	
	
	
	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable int id) {

		taskService.delete(id);
	}
	
	
	

}
