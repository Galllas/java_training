package com.fdmgroup.project.BankDesign;

import java.math.BigDecimal;

public interface BusinessAccount extends AccountBasic {
	
	void withdrawMoney(BigDecimal balance);
	void depositMoney(BigDecimal balance);
	
}
