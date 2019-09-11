package com.capgemini.bank.pl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.capgemini.bank.bean.BankAccount;

import com.capgemini.bank.bean.Transactions;
import com.capgemini.bank.exception.AccountNotFoundException;
import com.capgemini.bank.exception.InsufficientBalanceException;
import com.capgemini.bank.service.ServiceImpl;

public class Bank_Main {

	static Scanner scan = new Scanner(System.in);

	public static String getInput(String message) {
		System.out.println(message);
		String input = scan.next();
		return input;
	}

	public static BankAccount getBanAccount() {
		BankAccount account = new BankAccount();
		account.setAccountName(getInput("Enter account Holder Name"));
		account.setType(getInput("Account type :"));
		try {
			account.setBalance(Double.parseDouble(getInput("Opening account balance:")));
		} catch (NumberFormatException e) {
			System.out.println("Opening balance should be number");
			return null;
		}
		return account;
	}

	public static void main(String[] args) {

		ServiceImpl serviceImpl = new ServiceImpl();
		int choice = 0;
		do {

			System.out.println("\nWelcome to Banking Application");
			System.out.println("1. Create a new account");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Show Balance");
			System.out.println("5. Funds Transfer");
			System.out.println("6. Show Transactions");
			System.out.println("7. Save and Exit");
			System.out.println("Enter your choice");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				BankAccount account = getBanAccount();
				try {
					if (account != null && serviceImpl.CreateAccount(account)) {
						System.out.println("Account created Successfully");
						System.out.println("Account No:" + account.getAccountNo() + "\nType :" + account.getType()
								+ "\nOpening Balance :" + account.getBalance());
					} else {
						System.out.println("!!Failed to create account!!!");
					}
				} catch (SQLException e1) {
					System.out.println("Unable to connect to database|Failed to retrieve data");
				}
				break;
			case 2:
				String accountNo = getInput("Please enter your account number : ");
				String amount = getInput("Please enter amount to deposit : ");
				try {
					if (serviceImpl.deposit(accountNo, Double.parseDouble(amount))) {
						System.out.println("Deposited Succesfully... :)");
					}
				} catch (NumberFormatException e) {
					System.out.println("!!amount need to number!!");
				} catch (AccountNotFoundException e) {
					System.out.println("!!" + e.getAccountNo() + "not found!!");
				} catch (SQLException e) {
					System.out.println("Unable to connect to database | Failed to retrieve data");
				}
				break;
			case 3:
				String withAccountNo = getInput("Please enter your account number : ");
				String withAmount = getInput("Please enter amount to withdraw : ");
				try {
					if (serviceImpl.withdraw(withAccountNo, Double.parseDouble(withAmount))) {
						System.out.println("WithDraw Successfull :)");
					} else
						System.out.println("!!!WithDraw failed!!");
				} catch (NumberFormatException e) {
					System.out.println("!!!Amount need to number!!");
				} catch (AccountNotFoundException e) {
					System.out.println("!!!" + e.getAccountNo() + "not found!!!");

				} catch (InsufficientBalanceException e) {
					System.out.println("!!! Insufficient balance : \nAccount Number :" + e.getAccountNo()
							+ "\nBalance : " + e.getBalAmount() + "!!!");
				} catch (SQLException e) {
					System.out.println("Unable to connect to database | Failed to retrieve data");
				}
				break;
			case 4:
				String BalAccountNo = getInput("Please enter your account number : ");
				try {
					String bal = serviceImpl.showBalance(BalAccountNo);
					System.out.println("Balance :" + bal);
				} catch (AccountNotFoundException e) {
					System.out.println("!!! " + e.getAccountNo() + "not found !!");
				} catch (SQLException e) {
					System.out.println("Unable to connect to database");
				}
				break;
			case 5:
				String fromAccountNo = getInput("From Account Number : ");
				String toAccountNo = getInput("To Account Number : ");
				Double tranAmount = Double.parseDouble(getInput("Amount : "));
				try {
					serviceImpl.fundTransfer(fromAccountNo, toAccountNo, tranAmount);
				} catch (AccountNotFoundException e) {
					System.out.println(e.getMessage() + "\nAccount Number :" + e.getAccountNo());
				} catch (InsufficientBalanceException e) {
					System.out.println("!!! Insufficient balance : \nAccount Number :" + e.getAccountNo()
							+ "\nBalance : " + e.getBalAmount() + " !!!");
				} catch (SQLException e) {
					System.out.println("Unable to connect to database | Failed to retrieve data");
				}
				break;
			case 6:

				String sTranAccountNo = getInput("Please enter your account number : ");
				try {
					List<Transactions> transactions = serviceImpl.showTransactions(sTranAccountNo);
					System.out.println("\nTrans Id\t\tDate\t\tType\tAmount\tDescription");
					for (Transactions trans : transactions) {
						System.out.println(trans.getTransId() + "\t\t" + trans.getDateTime() + "\t" + trans.getType()
								+ "\t" + trans.getAmount() + "\t" + trans.getDescription());
					}
				} catch (AccountNotFoundException e) {
					System.out.println("!! " + e.getAccountNo() + "not found !!");
				} catch (SQLException e) {
					System.out.println("Unable to connect to database | Failed to retrieve data");
				}

				break;
			case 7:
				System.out.println("GoodBye See You Soon :)");
			default:
				break;
			}

		} while (choice != 7);
		scan.close();
	}

}
