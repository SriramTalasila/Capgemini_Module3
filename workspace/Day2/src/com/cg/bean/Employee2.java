package com.cg.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class Employee2 {
	@Id
	@GeneratedValue
	private int id;
	private String name;

	public Employee2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee2(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "Employee2 [id=" + id + ", name=" + name + "]";
	}

}
