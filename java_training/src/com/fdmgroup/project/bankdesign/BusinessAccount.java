package com.fdmgroup.project.bankdesign;

import java.math.BigDecimal;

public interface BusinessAccount extends BasicAccount {
	
	void withdrawMoney(BigDecimal balance);
	void depositMoney(BigDecimal balance);
	
}
