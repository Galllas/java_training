package com.fdmgroup.project.BankDesign;

import java.math.BigDecimal;

public interface Company extends CustomerBasic {
	
	void depositAllAcounts(Bank bank, BigDecimal amount);
	
}
