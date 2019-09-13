package com.cg.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.bean.Author;

public class MainApp {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager manager = factory.createEntityManager();
		
		//EntityTransaction transaction = manager.getTransaction();
		manager.getTransaction().begin();
		Author author = new Author("sriram", "prasad", "talasila", "7382024589");
		manager.persist(author);
		manager.getTransaction().commit();
	}

}
