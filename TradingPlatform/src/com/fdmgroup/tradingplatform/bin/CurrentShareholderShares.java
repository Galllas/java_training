package com.fdmgroup.tradingplatform.bin;

public class CurrentShareholderShares {

	private int shareholderId;
	private int stockId;
	private int shares;
	
	public int getShareholderId() {
		return shareholderId;
	}
	
	public void setShareholderId(int shareholderId) {
		this.shareholderId = shareholderId;
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

	@Override
	public String toString() {
		return "CurrentShareholderShares [shareholderId=" + shareholderId + ", stockId=" + stockId + ", shares="
				+ shares + "]";
	}
	
	
	
}
