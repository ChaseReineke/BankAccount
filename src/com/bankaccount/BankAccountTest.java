package com.bankaccount;

public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount acc1 = new BankAccount(100.0, 200.0);
		acc1.getAccountNumber();
		acc1.getCheckingBalance();
		acc1.getSavingsBalance();
		acc1.getTotalBalance();
		acc1.deposit("savings", 500);
		acc1.deposit("checking", 500);

		acc1.getCheckingBalance();
		acc1.getSavingsBalance();
		
		acc1.withdraw("savings", 10000);
		acc1.withdraw("checking", 20000);
		
		acc1.getCheckingBalance();
		acc1.getSavingsBalance();
	}

}