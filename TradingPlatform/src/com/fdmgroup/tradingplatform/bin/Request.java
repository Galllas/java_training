package com.fdmgroup.tradingplatform.bin;

public class Request {

	private int request_id;
	private int parent_request_id;
	private int shares_filled;
	private int shareholder_id;
	private String request_date;
	private String buy_sell;
	private String status;
	private int stock_ex_id;
	private int stock_id; 
	private int shares;
	private int minimum_shares;
	private String time_in_force;
	private int limit_price;
	private int stop_price;
	
	public Request(int request_id, int parent_request_id, int shares_filled,
			int shareholder_id, String request_date, String buy_sell,
			String status, int stock_ex_id, int stock_id, int shares,
			int minimum_shares, String time_in_force, int limit_price,
			int stop_price) {
		super();
		this.request_id = request_id;
		this.parent_request_id = parent_request_id;
		this.shares_filled = shares_filled;
		this.shareholder_id = shareholder_id;
		this.request_date = request_date;
		this.buy_sell = buy_sell;
		this.status = status;
		this.stock_ex_id = stock_ex_id;
		this.stock_id = stock_id;
		this.shares = shares;
		this.minimum_shares = minimum_shares;
		this.time_in_force = time_in_force;
		this.limit_price = limit_price;
		this.stop_price = stop_price;
	}
	
	public int getRequest_id() {
		return request_id;
	}

	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}

	public int getParent_request_id() {
		return parent_request_id;
	}

	public void setParent_request_id(int parent_request_id) {
		this.parent_request_id = parent_request_id;
	}

	public int getShares_filled() {
		return shares_filled;
	}

	public void setShares_filled(int shares_filled) {
		this.shares_filled = shares_filled;
	}

	public int getShareholder_id() {
		return shareholder_id;
	}

	public void setShareholder_id(int shareholder_id) {
		this.shareholder_id = shareholder_id;
	}

	public String getRequest_date() {
		return request_date;
	}

	public void setRequest_date(String request_date) {
		this.request_date = request_date;
	}

	public String getBuy_sell() {
		return buy_sell;
	}

	public void setBuy_sell(String buy_sell) {
		this.buy_sell = buy_sell;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getStock_ex_id() {
		return stock_ex_id;
	}

	public void setStock_ex_id(int stock_ex_id) {
		this.stock_ex_id = stock_ex_id;
	}

	public int getStock_id() {
		return stock_id;
	}

	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public int getMinimum_shares() {
		return minimum_shares;
	}

	public void setMinimum_shares(int minimum_shares) {
		this.minimum_shares = minimum_shares;
	}

	public String getTime_in_force() {
		return time_in_force;
	}

	public void setTime_in_force(String time_in_force) {
		this.time_in_force = time_in_force;
	}

	public int getLimit_price() {
		return limit_price;
	}

	public void setLimit_price(int limit_price) {
		this.limit_price = limit_price;
	}

	public int getStop_price() {
		return stop_price;
	}

	public void setStop_price(int stop_price) {
		this.stop_price = stop_price;
	}

	@Override
	public String toString() {
		return "Request [request_id=" + request_id + ", parent_request_id="
				+ parent_request_id + ", shares_filled=" + shares_filled
				+ ", shareholder_id=" + shareholder_id + ", request_date="
				+ request_date + ", buy_sell=" + buy_sell + ", status="
				+ status + ", stock_ex_id=" + stock_ex_id + ", stock_id="
				+ stock_id + ", shares=" + shares + ", minimum_shares="
				+ minimum_shares + ", time_in_force=" + time_in_force
				+ ", limit_price=" + limit_price + ", stop_price=" + stop_price
				+ "]";
	}

}
