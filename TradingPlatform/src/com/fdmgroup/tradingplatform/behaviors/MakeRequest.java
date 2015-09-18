package com.fdmgroup.tradingplatform.behaviors;

import com.fdmgroup.tradingplatform.bin.Request;

public interface MakeRequest {
	
	Request makeRequest(int request_id, int parent_request_id, int shares_filled, int shareholder_id, String request_date,
			String buy_sell, String status, int stock_ex_id, int stock_id,
			int shares, int minimum_shares, String time_in_force,
			int limit_price, int stop_price);
	
}
