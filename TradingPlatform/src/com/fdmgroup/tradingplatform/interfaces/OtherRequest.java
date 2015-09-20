package com.fdmgroup.tradingplatform.interfaces;

import java.math.BigDecimal;

import com.fdmgroup.tradingplatform.bin.Request;
import com.fdmgroup.tradingplatform.dao.RequestRAMDAO;

public class OtherRequest implements MakeRequest {

	@Override
	public Request makeRequest(int requestId, int parentRequestId, int sharesFilled, int shareholderId,
			String requestDate, String buySell, String status, int stockExId, int stockId, int shares,
			int minimumShares, String timeInForce, BigDecimal limitPrice, BigDecimal stopPrice) {
		
		Request request = new Request( requestId, parentRequestId, sharesFilled,
				shareholderId, requestDate, buySell, status,
				stockExId, stockId, shares, minimumShares, timeInForce, limitPrice, stopPrice);
		
		RequestRAMDAO requestRAMDAO = new RequestRAMDAO();
		requestRAMDAO.create(request);
		return request;
		
	}

}
