package com.fdmgroup.BankDesign;

import java.math.BigDecimal;

/**
 * Create business customer, override method from interface to add same amount of money to all the customer's accounts.
 * @author gang.zhao
 *
 */

public class BusinessCustomer extends Customer  {

	protected BusinessCustomer(String name, String address, String taxID) {
		super(name, address, taxID);
	}

	@Override
	public void resetAcounts(Bank bank, BigDecimal amount) {
		for (int accountID : this.getAccountIDs() ){
			bank.getAccounts().get(accountID).setBalance( bank.getAccounts().get(accountID).getBalance().add(amount));
		}
	}
}

