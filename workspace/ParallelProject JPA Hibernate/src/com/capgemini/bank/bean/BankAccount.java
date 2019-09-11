package com.capgemini.bank.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class BankAccount {

	// private static long accCounter = 501002000;
	@Id
	@SequenceGenerator(name = "acc_seq", sequenceName = "ACC_NUM", allocationSize = 1)
	@GeneratedValue(generator = "acc_seq", strategy = GenerationType.SEQUENCE)
	private Long accountNo;
	private String accountHolderName;
	private double balance;
	private String type;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Transactions> transactions = new ArrayList<>();

	public List<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}

	public BankAccount() {
		super();
		// this.setAccountNo();
		this.setBalance(0);
		// this.setTransactions();

	}

	public BankAccount(String accountName, double balance, String type) {
		super();
		this.setAccountName(accountName);
		this.setBalance(balance);
		this.setType(type);
	}

	public String getAccountName() {
		return accountHolderName;
	}

	public void setAccountName(String accountName) {
		this.accountHolderName = accountName;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountNo() {
		return accountNo.toString();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", accountName=" + accountHolderName + ", balance=" + balance
				+ ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountHolderName == null) ? 0 : accountHolderName.hashCode());
		result = prime * result + ((accountNo == null) ? 0 : accountNo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		if (accountHolderName == null) {
			if (other.accountHolderName != null)
				return false;
		} else if (!accountHolderName.equals(other.accountHolderName))
			return false;
		if (accountNo == null) {
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
