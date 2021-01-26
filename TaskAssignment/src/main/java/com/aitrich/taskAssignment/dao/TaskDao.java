package com.aitrich.taskAssignment.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aitrich.taskAssignment.domain.Person;
import com.aitrich.taskAssignment.domain.Task;

@Repository
public interface TaskDao extends JpaRepository<Task,Integer>{

	/*
	 * @Modifying
	 * 
	 * @Query(
	 * value="insert into Task(id,name,description,status.assigned_to_id) values(:name1,:description2,:status3)"
	 * , nativeQuery=true)
	 * 
	 * @Transactional public void insertto(@Param ("id")int id,@Param
	 * ("name1")String name,@Param ("description2")String description, @Param
	 * ("status3")String status,@Param ("assigned")int assigned);
	 */
	
	@Query(value ="select * from Task t where t.status = 'ASSIGNED'",nativeQuery =true)
	public List<Task> taskList();
	/*
	 * @Query(value ="select * from Task t where t.status = 'NEW'",nativeQuery
	 * =true) public List<Task> taskLNew();
	 */
	
	
}
