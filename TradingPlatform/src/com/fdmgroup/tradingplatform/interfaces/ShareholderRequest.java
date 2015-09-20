package com.fdmgroup.tradingplatform.interfaces;

import java.math.BigDecimal;

import com.fdmgroup.tradingplatform.bin.Request;
import com.fdmgroup.tradingplatform.dao.RequestRAMDAO;

public class ShareholderRequest implements MakeRequest {

	private int DEFALUT_REQUEST_ID = -1;
	private int DEFALUT_PARENT_REQUEST_ID = -1;
	private int DEFALUT_SHARES_FILLED = -1;

	@Override
	public Request makeRequest(int requestId, int parentRequestId, int sharesFilled,
			int shareholderId, String requestDate,
			String buySell, String status, int stockExId, int stockId,
			int shares, int minimumShares, String timeInForce,
			BigDecimal limitPrice, BigDecimal stopPrice) {
		
		Request request = new Request( DEFALUT_REQUEST_ID, DEFALUT_PARENT_REQUEST_ID, DEFALUT_SHARES_FILLED,
				shareholderId, requestDate, buySell, status,
				stockExId, stockId, shares, minimumShares, timeInForce, limitPrice, stopPrice);
		
		RequestRAMDAO requestRAMDAO = new RequestRAMDAO();
		requestRAMDAO.create(request);
		return request;
	}

	public int getDEFALUT_REQUEST_ID() {
		return DEFALUT_REQUEST_ID;
	}

	public void setDEFALUT_REQUEST_ID(int dEFALUT_REQUEST_ID) {
		DEFALUT_REQUEST_ID = dEFALUT_REQUEST_ID;
	}

	public int getDEFALUT_PARENT_REQUEST_ID() {
		return DEFALUT_PARENT_REQUEST_ID;
	}

	public void setDEFALUT_PARENT_REQUEST_ID(int dEFALUT_PARENT_REQUEST_ID) {
		DEFALUT_PARENT_REQUEST_ID = dEFALUT_PARENT_REQUEST_ID;
	}

	public int getDEFALUT_SHARES_FILLED() {
		return DEFALUT_SHARES_FILLED;
	}

	public void setDEFALUT_SHARES_FILLED(int dEFALUT_SHARES_FILLED) {
		DEFALUT_SHARES_FILLED = dEFALUT_SHARES_FILLED;
	}
	
	

}
	