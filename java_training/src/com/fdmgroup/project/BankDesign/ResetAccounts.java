package com.fdmgroup.project.BankDesign;

import java.math.BigDecimal;

/**
 * provide an interface for collective accounts manipulation of one customer.
 * @author gang.zhao
 *
 */

public interface ResetAccounts {
	void resetAcounts(Bank bank, BigDecimal amount);
}
