package com.fdmgroup.project.BankDesign;

import java.math.BigDecimal;

public interface Company extends BasicCustomer {
	
	void depositAllAcounts(Bank bank, BigDecimal amount);
	
}
