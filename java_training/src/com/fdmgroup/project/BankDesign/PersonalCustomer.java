package com.fdmgroup.project.BankDesign;

import java.math.BigDecimal;

/**
 * Create personal customer class, override interface method to set all the accounts' balance to 0.
 * @author gang.zhao
 *
 */

public class PersonalCustomer extends Customer{
	
	protected PersonalCustomer(String name, String address, String taxID) {
		super(name, address, taxID);
	}

	@Override
	public void resetAcounts(Bank bank, BigDecimal amount) {
		for (int accountID : this.getAccountIDs() ){
			bank.getAccounts().get(accountID).setBalance( BigDecimal.ZERO);		
		}
	}
	
}