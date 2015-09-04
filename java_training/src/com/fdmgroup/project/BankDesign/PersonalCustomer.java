package com.fdmgroup.project.BankDesign;

import java.math.BigDecimal;

/**
 * Create personal customer class, override interface method to set all the accounts' balance to 0.
 * @author gang.zhao
 *
 */

public class PersonalCustomer extends Customer implements Company, Person {
	
	protected PersonalCustomer(String name, String address, String taxID) {
		super(name, address, taxID);
	}

	@Override
	public void resetAllAccounts(Bank bank) {
		for (int accountID : this.getAccountIds() ){
			bank.getPersonalAccounts().get(accountID).setBalance(BigDecimal.ZERO);		
		}
	}

	@Override
	public void depositAllAcounts(Bank bank, BigDecimal amount) {
		// TODO Auto-generated method stub
		
	}


	
}