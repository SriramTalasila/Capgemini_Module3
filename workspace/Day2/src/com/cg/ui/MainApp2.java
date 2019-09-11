package com.cg.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.bean.Faculty;
import com.cg.bean.Technology;

public class MainApp2 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		
		  Faculty faculty = new Faculty("Rahul");
		  
		  Technology technology = new Technology("Java");
		  Technology technology2 = new Technology("BDD");
		  
		  technology.setFaculty(faculty);
		  technology2.setFaculty(faculty);

		  faculty.getTechnologies().add(technology);
		  faculty.getTechnologies().add(technology2);
		  
		  
		  // faculty.setTechnology(technology); // technology.setFaculty(faculty); //
		  //entityManager.persist(technology);
		  entityManager.persist(faculty);
		 
		
		/*
		 * Faculty faculty2 = entityManager.find(Faculty.class,1);
		 * System.out.println(faculty2); System.out.println(faculty2.getTechnologies());
		 * entityManager.getTransaction().commit();
		 */
		  entityManager.getTransaction().commit();

		/*
		 * Faculty fac = entityManager.find(Faculty.class, 1); System.out.println(fac);
		 */
	}

}
