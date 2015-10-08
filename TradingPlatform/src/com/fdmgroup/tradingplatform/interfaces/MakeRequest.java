package com.fdmgroup.tradingplatform.interfaces;

import java.math.BigDecimal;

import com.fdmgroup.tradingplatform.bin.Company;
import com.fdmgroup.tradingplatform.bin.Person;
import com.fdmgroup.tradingplatform.bin.Request;

public interface MakeRequest {
	
	Request makeRequest(int requestId, Request request, int sharesFilled, Person person,
			String requestDate, String buySell, String status, Company company, int shares,
			int minimumShares, String timeInForce, BigDecimal limitPrice, BigDecimal stopPrice);
	
}
