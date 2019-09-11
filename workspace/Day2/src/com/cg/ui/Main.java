package com.cg.ui;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.bean.Employee;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = factory.createEntityManager();
		// TypedQuery<Employee> query = entityManager.createQuery("from Employee",
		// Employee.class);
		// System.out.println("Enter Gender");
		// String gender = sc.nextLine();
		// TypedQuery<Employee> query = entityManager.createQuery("from Employee as emp
		// where emp.gender=?",
		// Employee.class);
		/*
		 * TypedQuery<Employee> query =
		 * entityManager.createQuery("from Employee as emp", Employee.class); //
		 * query.setParameter(1, gender); List<Employee> employees =
		 * query.getResultList(); System.out.println(employees);
		 */

		// Delete using query
		/*
		 * System.out.println("Enter id to delete"); int id =
		 * Integer.parseInt(sc.nextLine()); entityManager.getTransaction().begin();
		 * Query query2 =
		 * entityManager.createQuery("delete from Employee where id=:id");
		 * query2.setParameter("id", id); int rowsDeleted = query2.executeUpdate();
		 * entityManager.getTransaction().commit(); System.out.println(rowsDeleted +
		 * "row deleted");
		 */

		/*
		 * System.out.println("Enter id to find"); int id =
		 * Integer.parseInt(sc.nextLine());
		 * 
		 * TypedQuery<Employee> query3 =
		 * entityManager.createQuery("from Employee where id=:eno", Employee.class);
		 * query3.setParameter("eno", id); Employee emp = query3.getSingleResult();
		 * System.out.println(emp);
		 */

		/*
		 * entityManager.getTransaction().begin(); System.out.println("Enter age"); int
		 * age = Integer.parseInt(sc.nextLine()); System.out.println("Enter Gender");
		 * String gender2 = sc.nextLine(); System.out.println("Enter salary increment");
		 * float salary = Float.parseFloat(sc.nextLine()); Query query4 = entityManager.
		 * createQuery("update Employee set salary=salary+?,age=age+? where gender=?");
		 * query4.setParameter(1, salary); query4.setParameter(2, age);
		 * query4.setParameter(3, gender2); int rowsUpdated = query4.executeUpdate();
		 * System.out.println(rowsUpdated + "row deleted");
		 * entityManager.getTransaction().commit();
		 */

		TypedQuery<Employee> query5 = entityManager.createNamedQuery("getAllEmployees", Employee.class);
		List<Employee> employees = query5.getResultList();
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		System.out.println("-----------------------");
		TypedQuery<Employee> query6 = entityManager.createNamedQuery("getEmployeesByGender", Employee.class);
		query6.setParameter("gen", "FeMale");
		List<Employee> employees2 = query6.getResultList();
		for (Employee employee : employees2) {
			System.out.println(employee);
		}

	}

}
