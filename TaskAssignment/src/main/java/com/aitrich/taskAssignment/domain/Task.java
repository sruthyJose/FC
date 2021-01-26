package com.aitrich.taskAssignment.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Task")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
	@GenericGenerator(name="native", strategy="native")
	private int id;
	
	private String name;
	private String description;
	
	@ManyToOne
	private Person assignedTo;
	@Enumerated(EnumType.STRING)
	private TypeStatus status;
	
	
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Task(int id, String name, String description, Person assignedTo, TypeStatus status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.assignedTo = assignedTo;
		this.status = status;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Person getAssignedTo() {
		return assignedTo;
	}


	public void setAssignedTo(Person assignedTo) {
		this.assignedTo = assignedTo;
	}


	public TypeStatus getStatus() {
		return status;
	}


	public void setStatus(TypeStatus status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description + ", assignedTo=" + assignedTo
				+ ", status=" + status + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	

}
