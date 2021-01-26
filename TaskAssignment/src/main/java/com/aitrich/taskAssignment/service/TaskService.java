package com.aitrich.taskAssignment.service;

import java.util.List;
import java.util.Set;

import com.aitrich.taskAssignment.domain.Person;
import com.aitrich.taskAssignment.domain.Task;

public interface TaskService {
	
	public void add(Task task);
	public void delete(int id);
	public void update(Task task);
	public List<Task> findAllTask();
	public List<Person> findAvailable();
}
