package com.cg.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "employee_details")
@NamedQueries({ @NamedQuery(name = "getAllEmployees", query = "from Employee"),
		@NamedQuery(name = "getEmployeesByGender", query = "from Employee where gender=:gen") })
public class Employee {
	@Id
	@SequenceGenerator(name = "myseq", sequenceName = "emp_seq", allocationSize = 1)
	@GeneratedValue(generator = "myseq", strategy = GenerationType.SEQUENCE)
	@Column(name = "empId")
	private int id;
	@Column(name = "empName")
	private String name;
	private String gender;
	private int age;
	@Column(name = "annualSalary")
	private float salary;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, String gender, int age, float salary) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.salary = salary;
	}

	public Employee(String name, String gender, int age, float salary) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.salary = salary;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", salary=" + salary
				+ "]";
	}

}
