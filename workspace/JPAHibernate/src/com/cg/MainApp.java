
package com.cg;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainApp {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		// Inserting the employee
		/*
		 * Employee employee = new Employee(1005, "shankar", "male", 22, 19068f);
		 * em.getTransaction().begin(); em.persist(employee);
		 * em.getTransaction().commit(); System.out.println("Data saved");
		 */
		// Finding the employee
		//Employee emp = em.find(Employee.class, 1002);
		//System.out.println(emp);
		//Update data
		/*
		 * em.getTransaction().begin(); Employee emp = em.find(Employee.class,1002);
		 * System.out.println(emp); emp.setAge(23); emp.setSalary(40000f);
		 * em.getTransaction().commit(); System.out.println("After commit");
		 * System.out.println(emp);
		 */
		
		//delete
		/*
		 * em.getTransaction().begin(); Employee emp = em.find(Employee.class,1002);
		 * System.out.println(emp); em.remove(emp); em.getTransaction().commit();
		 * System.out.println("After commit"); System.out.println(emp);
		 */
		
		
		//Generated auto increament Key
		
		Employee emp = new Employee("Ram Prasad", "Male", 22, 13898f);
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
		System.out.println(emp);
		
	}

}
