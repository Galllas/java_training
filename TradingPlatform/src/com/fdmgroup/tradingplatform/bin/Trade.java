package com.fdmgroup.tradingplatform.bin;

import java.math.BigDecimal;

public class Trade {

	private int tradeId;
	private int stockId;
	private String transactionTime;
	private int shares;
	private BigDecimal sharePrice;
	private BigDecimal priceTotal;
	private int buyerId;
	private int sellerId;
	private int buyRequestId;
	private int sellRequestId;
	
	public Trade(int tradeId, int stockId, String transactionTime, int shares, BigDecimal sharePrice,
			BigDecimal priceTotal, int buyerId, int sellerId, int buyRequestId, int sellRequestId) {
		super();
		this.tradeId = tradeId;
		this.stockId = stockId;
		this.transactionTime = transactionTime;
		this.shares = shares;
		this.sharePrice = sharePrice;
		this.priceTotal = priceTotal;
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.buyRequestId = buyRequestId;
		this.sellRequestId = sellRequestId;
	}

	public int getTradeId() {
		return tradeId;
	}
	
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	
	public int getStockId() {
		return stockId;
	}
	
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	
	public String getTransactionTime() {
		return transactionTime;
	}
	
	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}
	
	public int getShares() {
		return shares;
	}
	
	public void setShares(int shares) {
		this.shares = shares;
	}
	
	public BigDecimal getSharePrice() {
		return sharePrice;
	}
	
	public void setSharePrice(BigDecimal sharePrice) {
		this.sharePrice = sharePrice;
	}
	
	public BigDecimal getPriceTotal() {
		return priceTotal;
	}
	
	public void setPriceTotal(BigDecimal priceTotal) {
		this.priceTotal = priceTotal;
	}
	
	public int getBuyerId() {
		return buyerId;
	}
	
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	
	public int getSellerId() {
		return sellerId;
	}
	
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	
	public int getBuyRequestId() {
		return buyRequestId;
	}
	
	public void setBuyRequestId(int buyRequestId) {
		this.buyRequestId = buyRequestId;
	}
	
	public int getSellRequestId() {
		return sellRequestId;
	}
	
	public void setSellRequestId(int sellRequestId) {
		this.sellRequestId = sellRequestId;
	}

	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", stockId=" + stockId + ", transactionTime=" + transactionTime
				+ ", shares=" + shares + ", sharePrice=" + sharePrice + ", priceTotal=" + priceTotal + ", buyerId="
				+ buyerId + ", sellerId=" + sellerId + ", buyRequestId=" + buyRequestId + ", sellRequestId="
				+ sellRequestId + "]";
	}
	
	
}
