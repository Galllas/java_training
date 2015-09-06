package com.fdmgroup.project.BankDesign;

import java.math.BigDecimal;

/**
 * Inherit from account to build checking account, add checking information, and override the withdraw method without checking the balance
 * after withdraw.
 * @author gang.zhao
 *
 */

public class CheckingAccount extends Account {
	
	private int INITIAL_CHECKINGNUMBER = 1;
	private int checkNumber = INITIAL_CHECKINGNUMBER;
	private int nextCheck = INITIAL_CHECKINGNUMBER + 1;
	
	protected CheckingAccount(int customerID, BigDecimal balance) {
		super(customerID, balance);
	}
	
	public int getCheckNumber() {
		return checkNumber;
	}
	
	public int getNextCheck() {
		return nextCheck;
	}
	
	public int requestCheck(int amount) {
		int currentNum = this.nextCheck;
		this.nextCheck += amount;
		return currentNum;
	}

	@Override
	public void withdrawMoney(BigDecimal balance) {
		this.setBalance(this.getBalance().subtract(balance));
	}

	@Override
	public void depositMoney(BigDecimal balance) {
		this.setBalance(this.getBalance().add(balance));
	}

	@Override
	public void setInterestRate(Number amount) {
		// TODO Auto-generated method stub
		
	}

	
}
