package com.capgemini.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.bank.bean.BankAccount;
import com.capgemini.bank.bean.Transactions;

public class DaoImpl implements DaoInterface {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager entityManager = factory.createEntityManager();

	@Override
	public String addAccount(BankAccount account) {
		entityManager.getTransaction().begin();
		entityManager.persist(account);
		entityManager.getTransaction().commit();
		return account.getAccountNo();

	}

	@Override
	public boolean updateBalance(String accountNo, Double balance) throws SQLException {
		return false;

	}

	@Override
	public boolean addTransaction(Transactions transactions,String AccNo) throws SQLException {
		
			
		return false;
		// System.out.println("In Transaction");

	}

	@Override
	public List<Transactions> getTransactions(String accountNumber) throws SQLException {
		return null;

	}

	@Override
	public Double getBalance(String accountNo) throws SQLException {
		return null;
	}

}
