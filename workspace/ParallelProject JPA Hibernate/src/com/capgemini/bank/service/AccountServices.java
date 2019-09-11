
package com.capgemini.bank.service;

import java.sql.SQLException;
import java.util.List;

import com.capgemini.bank.bean.BankAccount;
import com.capgemini.bank.bean.Transactions;
import com.capgemini.bank.exception.AccountNotFoundException;
import com.capgemini.bank.exception.InsufficientBalanceException;

public interface AccountServices {

	public boolean CreateAccount(BankAccount bankAccount) throws SQLException;

	public boolean deposit(String accountNo, double amount) throws AccountNotFoundException, SQLException;

	public boolean withdraw(String accountNo, double amount)
			throws AccountNotFoundException, InsufficientBalanceException, SQLException;

	public String showBalance(String accountNo) throws AccountNotFoundException, SQLException;

	public boolean fundTransfer(String fromAccount, String toAccount, double Amount)
			throws AccountNotFoundException, InsufficientBalanceException, SQLException;

	public List<Transactions> showTransactions(String accountNo) throws AccountNotFoundException, SQLException;

}
