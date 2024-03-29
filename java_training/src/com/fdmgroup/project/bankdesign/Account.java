package com.fdmgroup.project.bankdesign;

import java.math.BigDecimal;

/**
 * Create abstract class account, maintain account ID, customer ID and balance information, give withdraw, deposit and correct methods,
 * override constructor to create instance when given customer ID and balance.
 * @author gang.zhao
 *
 */

public abstract class Account {

	private int customerId;
	private int accountId;
	private BigDecimal balance;
	
	protected Account(int customerId, int accountId, BigDecimal balance){
		this.setCustomerId(customerId);
		this.setAccountId(accountId);
		this.setBalance(balance);
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
