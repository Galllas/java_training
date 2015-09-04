package com.fdmgroup.project.BankDesign;

import java.math.BigDecimal;

public interface AccountBasic {
	
	public int getCustomerId();
	
	public int getAccountId();
	
	public BigDecimal getBalance();
	
	public void setBalance(BigDecimal balance);
	
}
