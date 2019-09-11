package com.cg.bean;

import javax.persistence.Entity;

@Entity
public class PermanentEmployee extends Employee2 {

	private float salary;

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

}
