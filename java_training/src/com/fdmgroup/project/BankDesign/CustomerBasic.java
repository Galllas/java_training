package com.fdmgroup.project.BankDesign;

import java.util.List;

public interface CustomerBasic {

	public int getCustomerId();
	
	public String getName();
	
	public String getAddress();
	
	public String getTaxId();
	
	public List<Integer> getAccountIds();
	
	public void addAccountId(int accountId);
}
