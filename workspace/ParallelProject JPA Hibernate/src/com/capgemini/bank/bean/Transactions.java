package com.capgemini.bank.bean;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Transactions implements Comparable<Transactions> {

	@Id
	@SequenceGenerator(name = "trans_seq", sequenceName = "trans_seq")
	@GeneratedValue(generator = "trans_seq")
	private int transId;
	private String accountNo;
	private Timestamp dateTime;
	private String description;
	private String type;
	private double amount;

	public Transactions() {
		super();
		// Transactions.transCount++;
	}

	public Transactions(int transId, Timestamp dateTime, String description, String type, double amount) {
		super();
		this.transId = transId;
		this.dateTime = dateTime;
		this.description = description;
		this.type = type;
		this.amount = amount;
	}

	public Transactions(String accountNo, String description, String type, double amount) {
		super();
		// this.setTransId();
		// this.setTimeinmilliseconds();
		this.setAccountNo(accountNo);
		this.setDescription(description);
		this.setType(type);
		this.setAmount(amount);
		this.setDateTime();
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime() {
		java.util.Date date = new Date();
		this.dateTime = new java.sql.Timestamp(date.getTime());
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public int getTransId() {
		return transId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transactions [transId=" + transId + ", dateTime=" + dateTime + ", description=" + description
				+ ", type=" + type + ", amount=" + amount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + transId;
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
		Transactions other = (Transactions) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (transId != other.transId)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public int compareTo(Transactions o) {
		if (this.transId > o.transId)
			return -1;
		else if (this.transId < o.transId)
			return 1;
		return 0;
	}

}
