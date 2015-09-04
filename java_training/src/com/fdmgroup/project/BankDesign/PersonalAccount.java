package com.fdmgroup.project.BankDesign;

import java.math.BigDecimal;

public interface PersonalAccount extends AccountBasic {
	
	void withdrawMoney(BigDecimal balance);
	void depositMoney(BigDecimal balance);
	
}
