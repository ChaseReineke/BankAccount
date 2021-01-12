package com.bankaccount;

import java.util.Random;

public class BankAccount {
	
	static int numberOfAccounts;
	static int netTotalOfAccounts;
	
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	
//	Account constructors
	
	public BankAccount() {
		this.accountNumber = accountGenerator();
		numberOfAccounts++;
		this.checkingBalance = 0;
		this.savingsBalance = 0;
	}
	
	public BankAccount(double checkingBalance, double savingsBalance) {
		this.accountNumber = accountGenerator();
		this.checkingBalance = checkingBalance;
		this.savingsBalance = savingsBalance;
		numberOfAccounts++;
		netTotalOfAccounts += checkingBalance;
		netTotalOfAccounts += savingsBalance;
	}

//	End of Account constructors
	
//	Getters section
	
	public double getCheckingBalance() {
	    System.out.println("Checking Balance");
	    System.out.println(checkingBalance);
		return checkingBalance;
	}
	public double getSavingsBalance() {
	    System.out.println("Savings Balance");
	    System.out.println(savingsBalance);
		return savingsBalance;
	}
	public double getTotalBalance() {
	    System.out.println("Total Balance");
	    System.out.println(checkingBalance + savingsBalance);
		return savingsBalance+checkingBalance;
	}
	public String getAccountNumber() {
		System.out.println("Account Number");
		System.out.println(accountNumber);
		return accountNumber;
	}
	
//	end of Getters section
	
//  private methods 
	
	private String accountGenerator() {
	    Random rnd = new Random();
	    char [] digits = new char[10];
	    for(int i=0; i<digits.length; i++) {
	        digits[i] = (char) (rnd.nextInt(10) + '0');
	    }
	    System.out.println("Account Created: New Account Number");
	    System.out.println(digits);
	    return String.valueOf(digits);
	}
	private void depositToSavings(double amount) {
		this.savingsBalance += amount;
		netTotalOfAccounts += amount;
		System.out.println("Savings deposit completed");
	}
	private void depositToChecking(double amount) {
		this.checkingBalance += amount;
		netTotalOfAccounts += amount;
		System.out.println("Checkings deposit completed");
	}
	private void withdrawFromSavings(double amount) {
		if (this.savingsBalance > amount) {
			this.savingsBalance -= amount;
			netTotalOfAccounts -= amount;
			System.out.println("Savings withdraw completed");
		} else {
			System.out.println("Insufficent Funds");
		}
	}
	private void withdrawFromChecking(double amount) {
		if (this.checkingBalance > amount) {
			this.checkingBalance -= amount;
			netTotalOfAccounts -= amount;
			System.out.println("Checkings withdraw completed");
		} else {
			System.out.println("Insufficent Funds");
		}
	}
	
//	End of private methods
	
//	Public methods 
	
	public void deposit(String account, double amount) {
		if (account == "savings") {
			depositToSavings(amount);
		} else if (account == "checking"){
			depositToChecking(amount);
		} else {
			System.out.println("Account: " + account + " Does not exist");
		}
	}
	
	public void withdraw(String account, double amount) {
		if (account == "savings") {
			withdrawFromSavings(amount);
		} else if (account == "checking"){
			withdrawFromChecking(amount);
		} else {
			System.out.println("Account: " + account + " Does not exist");
		}
	}

//	End of Public methods 
	
}
