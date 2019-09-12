package com.capgemini.bank.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import com.capgemini.bank.bean.BankAccount;
import com.capgemini.bank.bean.Transactions;
import com.capgemini.bank.dao.DaoImpl;
import com.capgemini.bank.dao.DaoInterface;
import com.capgemini.bank.exception.AccountNotFoundException;
import com.capgemini.bank.exception.InsufficientBalanceException;

public class ServiceImpl implements AccountServices {

	DaoInterface accountDao = new DaoImpl();

	@Override
	public boolean CreateAccount(BankAccount bankAccount) throws SQLException {
		String accNo = null;
		accNo = accountDao.addAccount(bankAccount);
		if (accNo != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deposit(String accountNo, double amount) throws AccountNotFoundException, SQLException {
		Double balance = accountDao.getBalance(accountNo);
		if (balance != null) {
			System.out.println("In Deposit");
			balance = balance + amount;
			//boolean v = accountDao.addTransaction(new Transactions(accountNo, "Deposit", "CR", amount));
			if (accountDao.updateBalance(accountNo, balance)) {
				return true;
			} else
				return false;
		} else
			throw new AccountNotFoundException(accountNo, "Bank account not found");
	}

	@Override
	public boolean withdraw(String accountNo, double amount)
			throws AccountNotFoundException, InsufficientBalanceException, SQLException {
		Double balance = accountDao.getBalance(accountNo);
		if (balance != null) {
			if (balance < amount)
				throw new InsufficientBalanceException(accountNo, balance, "Unable to complete transactions");
			balance = balance - amount;
			//accountDao.addTransaction(new Transactions(accountNo, "Withdraw", "DR", amount));
			if (accountDao.updateBalance(accountNo, balance)) {
				return true;
			} else
				return false;
		} else
			throw new AccountNotFoundException(accountNo, "Bank account not found");

	}

	@Override
	public String showBalance(String accountNo) throws AccountNotFoundException, SQLException {
		Double balance = accountDao.getBalance(accountNo);
		if (balance != null)
			return Double.toString(balance);
		else
			throw new AccountNotFoundException(accountNo, "Unable to proceed");

	}

	@Override
	public boolean fundTransfer(String fromAccountNo, String toAccountNo, double amount)
			throws AccountNotFoundException, InsufficientBalanceException, SQLException {
		Double frombalance = accountDao.getBalance(fromAccountNo);
		if (frombalance != null) {
			if (frombalance < amount)
				throw new InsufficientBalanceException(fromAccountNo, frombalance, "Unable to complete transactions");
			Double tobalance = accountDao.getBalance(toAccountNo);
			if (tobalance == null)
				throw new AccountNotFoundException(toAccountNo, "Bank account not found");

			frombalance = frombalance - amount;
			tobalance = tobalance + amount;
			//accountDao.addTransaction(new Transactions(fromAccountNo, "Fund Transfer To " + toAccountNo, "DR", amount));
			//accountDao
			//		.addTransaction(new Transactions(toAccountNo, "Fund Transfer From " + fromAccountNo, "CR", amount));
			if ((accountDao.updateBalance(fromAccountNo, frombalance))
					&& accountDao.updateBalance(toAccountNo, tobalance)) {
				return true;
			} else
				return false;
		} else
			throw new AccountNotFoundException(fromAccountNo, "Bank account not found");

	}

	@Override
	public List<Transactions> showTransactions(String accountNo) throws AccountNotFoundException, SQLException {
		if (accountDao.getBalance(accountNo) != null) {
			List<Transactions> trans = accountDao.getTransactions(accountNo);
			Collections.sort(trans);
			return trans;
		}
		throw new AccountNotFoundException(accountNo, "Account not found");

	}

}
