package com.fdmgroup.BankDesign;

import java.math.BigDecimal;

/**
 * Create abstract class account, maintain account ID, customer ID and balance information, give withdraw, deposit and correct methods,
 * override constructor to create instance when given customer ID and balance.
 * @author gang.zhao
 *
 */

public abstract class Account {

	private static int INITIAL_ID = 1000;
	private static int currentID = INITIAL_ID;
	private static int INCREMENT = 5;
	private int customerID;
	private int accountID;
	private BigDecimal balance;
	
	protected Account(int customerID, BigDecimal balance){
		this.setCustomerID(customerID);
		this.setAccountID(Account.getCurrentID());
		this.setBalance(balance);
		Account.setCurrentID();
	}
	
	public static void setCurrentID() {
		Account.currentID = Account.currentID + INCREMENT;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public static int getCurrentID() {
		return currentID;
	}
	
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
		
	public int getCustomerID() {
		return customerID;
	}
	
	public int getAccountID() {
		return accountID;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}
	
	public void setBalance(BigDecimal balance){
		this.balance = balance;
	}
	
	public void withdrawMoney(BigDecimal balance) {
	
	}
	
	public void depositMoney(BigDecimal balance) {
		this.balance = this.balance.add(balance);
	}
		
}
