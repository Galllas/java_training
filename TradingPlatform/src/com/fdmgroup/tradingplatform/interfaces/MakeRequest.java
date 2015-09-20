package com.fdmgroup.tradingplatform.interfaces;

import java.math.BigDecimal;

import com.fdmgroup.tradingplatform.bin.Request;

public interface MakeRequest {
	
	Request makeRequest(int requestId, int parentRequestId, int sharesFilled, int shareholderId, String requestDate,
			String buySell, String status, int stockExId, int stockId,
			int shares, int minimumShares, String timeInForce,
			BigDecimal limitPrice, BigDecimal stopPrice);
	
}
