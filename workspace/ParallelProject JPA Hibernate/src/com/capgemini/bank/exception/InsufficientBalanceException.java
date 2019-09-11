package com.capgemini.bank.exception;

public class InsufficientBalanceException extends Exception {

	private String AccountNo;
	private double balAmount;
	//private double ReqAmount;

	public InsufficientBalanceException(String accountNo, double balAmount,  String message) {
		super(message);
		this.setAccountNo(accountNo);
		this.setBalAmount(balAmount);
		//this.setReqAmount(reqAmount);
	}

	public String getAccountNo() {
		return AccountNo;
	}

	public void setAccountNo(String accountNo) {
		AccountNo = accountNo;
	}

	public double getBalAmount() {
		return balAmount;
	}

	public void setBalAmount(double balAmount) {
		this.balAmount = balAmount;
	}

	/*public double getReqAmount() {
		return ReqAmount;
	}

	public void setReqAmount(double reqAmount) {
		ReqAmount = reqAmount;
	}*/

}
