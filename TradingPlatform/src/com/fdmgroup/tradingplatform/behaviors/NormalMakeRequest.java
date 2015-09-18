package com.fdmgroup.tradingplatform.behaviors;

import com.fdmgroup.tradingplatform.bin.Request;

public class NormalMakeRequest implements MakeRequest {

	private int DEFALUT_REQUEST_ID = -1;
	private int DEFALUT_PARENT_REQUEST_ID = -1;
	private int DEFALUT_SHARES_FILLED = -1;

	@Override
	public Request makeRequest(int request_id, int parent_request_id, int shares_filled,
			int shareholder_id, String request_date,
			String buy_sell, String status, int stock_ex_id, int stock_id,
			int shares, int minimum_shares, String time_in_force,
			int limit_price, int stop_price) {
		
		Request request = new Request( DEFALUT_REQUEST_ID, DEFALUT_PARENT_REQUEST_ID, DEFALUT_SHARES_FILLED,
				shareholder_id, request_date, buy_sell, status,
				stock_ex_id, stock_id, shares, minimum_shares, time_in_force, limit_price, stop_price);
		
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
	