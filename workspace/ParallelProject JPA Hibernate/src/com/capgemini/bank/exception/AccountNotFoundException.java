package com.capgemini.bank.exception;

public class AccountNotFoundException extends Exception {
	private String accountNo;

	public AccountNotFoundException(String accountNo, String message) {
		super(message);
		this.setAccountNo(accountNo);
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

}
