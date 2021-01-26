package com.aitrich.taskAssignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aitrich.taskAssignment.domain.Person;

public interface PersonDao extends JpaRepository<Person,Integer>{

}
