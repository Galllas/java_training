package com.fdmgroup.tradingplatform.bin;

import java.math.BigDecimal;

public class Company {
	
	private int companyId;
	private String name;
	private int stockId;
	private BigDecimal startingPrice;
	
	public int getCompanyId() {
		return companyId;
	}
	
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getStockId() {
		return stockId;
	}
	
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	
	public BigDecimal getStartingPrice() {
		return startingPrice;
	}
	
	public void setStartingPrice(BigDecimal startingPrice) {
		this.startingPrice = startingPrice;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", name=" + name + ", stockId=" + stockId + ", startingPrice="
				+ startingPrice + "]";
	}
	
	
}
