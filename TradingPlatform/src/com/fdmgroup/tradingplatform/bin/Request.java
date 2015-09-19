package com.fdmgroup.tradingplatform.bin;

import java.math.BigDecimal;

public class Request {

	private int requestId;
	private int parentRequestId;
	private int sharesFilled;
	private int shareholderId;
	private String requestDate;
	private String buySell;
	private String status;
	private int stockExId;
	private int stockId; 
	private int shares;
	private int minimumShares;
	private String timeInForce;
	private BigDecimal limitPrice;
	private BigDecimal stopPrice;
	
	public Request(int requestId, int parentRequestId, int sharesFilled, int shareholderId, String requestDate,
			String buySell, String status, int stockExId, int stockId, int shares, int minimumShares,
			String timeInForce, BigDecimal limitPrice, BigDecimal stopPrice) {
		super();
		this.requestId = requestId;
		this.parentRequestId = parentRequestId;
		this.sharesFilled = sharesFilled;
		this.shareholderId = shareholderId;
		this.requestDate = requestDate;
		this.buySell = buySell;
		this.status = status;
		this.stockExId = stockExId;
		this.stockId = stockId;
		this.shares = shares;
		this.minimumShares = minimumShares;
		this.timeInForce = timeInForce;
		this.limitPrice = limitPrice;
		this.stopPrice = stopPrice;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getParentRequestId() {
		return parentRequestId;
	}

	public void setParentRequestId(int parentRequestId) {
		this.parentRequestId = parentRequestId;
	}

	public int getSharesFilled() {
		return sharesFilled;
	}

	public void setSharesFilled(int sharesFilled) {
		this.sharesFilled = sharesFilled;
	}

	public int getShareholderId() {
		return shareholderId;
	}

	public void setShareholderId(int shareholderId) {
		this.shareholderId = shareholderId;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public String getBuySell() {
		return buySell;
	}

	public void setBuySell(String buySell) {
		this.buySell = buySell;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getStockExId() {
		return stockExId;
	}

	public void setStockExId(int stockExId) {
		this.stockExId = stockExId;
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public int getMinimumShares() {
		return minimumShares;
	}

	public void setMinimumShares(int minimumShares) {
		this.minimumShares = minimumShares;
	}

	public String getTimeInForce() {
		return timeInForce;
	}

	public void setTimeInForce(String timeInForce) {
		this.timeInForce = timeInForce;
	}

	public BigDecimal getLimitPrice() {
		return limitPrice;
	}

	public void setLimitPrice(BigDecimal limitPrice) {
		this.limitPrice = limitPrice;
	}

	public BigDecimal getStopPrice() {
		return stopPrice;
	}

	public void setStopPrice(BigDecimal stopPrice) {
		this.stopPrice = stopPrice;
	}

	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", parentRequestId=" + parentRequestId + ", sharesFilled="
				+ sharesFilled + ", shareholderId=" + shareholderId + ", requestDate=" + requestDate + ", buySell="
				+ buySell + ", status=" + status + ", stockExId=" + stockExId + ", stockId=" + stockId + ", shares="
				+ shares + ", minimumShares=" + minimumShares + ", timeInForce=" + timeInForce + ", limitPrice="
				+ limitPrice + ", stopPrice=" + stopPrice + "]";
	}

	

}
