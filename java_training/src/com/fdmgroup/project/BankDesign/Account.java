package com.fdmgroup.project.BankDesign;

import java.math.BigDecimal;

/**
 * Create abstract class account, maintain account ID, customer ID and balance information, give withdraw, deposit and correct methods,
 * override constructor to create instance when given customer ID and balance.
 * @author gang.zhao
 *
 */

public abstract class Account implements BusinessAccount, PersonalAccount {

	private static int INITIAL_ID = 1000;
	private static int currentId = INITIAL_ID;
	private static int INCREMENT = 5;
	private int customerId;
	private int accountId;
	private BigDecimal balance;
	
	protected Account(int customerId, BigDecimal balance){
		this.setCustomerId(customerId);
		this.setAccountId(Account.getCurrentId());
		this.setBalance(balance);
		Account.setCurrentId();
	}

	public static void setCurrentId() {
		Account.currentId = Account.currentId + INCREMENT;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public static int getCurrentId() {
		return currentId;
	}
	
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
		
	public int getCustomerId() {
		return customerId;
	}
	
	public int getAccountId() {
		return accountId;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}
	
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
}
