package com.fdmgroup.project.BankDesign;

import java.math.BigDecimal;

/**
 * Create business customer, override method from interface to add same amount of money to all the customer's accounts.
 * @author gang.zhao
 *
 */

public class BusinessCustomer extends Customer implements Company, Person {

	protected BusinessCustomer(String name, String address, String taxId) {
		super(name, address, taxId);
	}

	@Override
	public void depositAllAcounts(Bank bank, BigDecimal amount) {
		for (int accountId : this.getAccountIds() ){
			bank.getBusinessAccounts().get(accountId).setBalance(bank.getBusinessAccounts().get(accountId).getBalance().add(amount));
		}
	}

	@Override
	public void resetAllAccounts(Bank bank) {
		// TODO Auto-generated method stub
		
	}


}

