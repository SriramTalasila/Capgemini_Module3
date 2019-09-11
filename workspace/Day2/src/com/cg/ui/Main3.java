package com.cg.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.bean.Employee2;
import com.cg.bean.PermanentEmployee;
import com.cg.bean.Temporary;

public class Main3 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();

		Employee2 emp = new Employee2();
		emp.setName("Sriram");

		Temporary temporaryEmp = new Temporary();
		temporaryEmp.setName("ram");
		temporaryEmp.setDailyWage(500f);

		PermanentEmployee employee = new PermanentEmployee();
		employee.setName("prasad");
		employee.setSalary(50000f);

		entityManager.persist(emp);
		entityManager.persist(temporaryEmp);
		entityManager.persist(employee);

		entityManager.getTransaction().commit();

	}
}
