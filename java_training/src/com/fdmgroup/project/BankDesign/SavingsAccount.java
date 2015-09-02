package com.fdmgroup.project.BankDesign;

import java.math.BigDecimal;

/**
 * Inherit from account, add interest rate information, and override withdraw method to check the balance after withdraw,
 * make sure the balance won't below zero.
 * @author gang.zhao
 *
 */

public class SavingsAccount extends Account {

	private Number INITIAL_INTERESTRATE = 0;
	private Number interestRate = INITIAL_INTERESTRATE;
	
	protected SavingsAccount(int customerID, BigDecimal balance) {
		super(customerID, balance);
	}

	public Number getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Number interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public void withdrawMoney(BigDecimal balance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositMoney(BigDecimal balance) {
		// TODO Auto-generated method stub
		
	}


	

}