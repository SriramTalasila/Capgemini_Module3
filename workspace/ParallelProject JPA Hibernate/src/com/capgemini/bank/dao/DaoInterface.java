package com.capgemini.bank.dao;

import java.sql.SQLException;
import java.util.List;

import com.capgemini.bank.bean.BankAccount;
import com.capgemini.bank.bean.Transactions;

public interface DaoInterface {

	public String addAccount(BankAccount account) throws SQLException;

	public boolean updateBalance(String accountNo,Double balance) throws SQLException;

	//public BankAccount getBankAccount(String accountNo);
	
	public Double getBalance(String accountNo) throws SQLException;

	public boolean addTransaction(Transactions transactions,String AccNo) throws SQLException;

	public List<Transactions> getTransactions(String accountNumber) throws SQLException;
}
