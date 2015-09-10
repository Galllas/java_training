package com.fdmgroup.com.business;

public class Product {
	
	private int productId;
	private String name;
	private String description;
	private double price;
	private boolean recallStatus;
	
	public Product(String name, String description,
			double price, boolean recallStatus) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.recallStatus = recallStatus;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductid(int productid) {
		this.productId = productid;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public boolean isRecallStatus() {
		return recallStatus;
	}
	
	public void setRecallStatus(boolean recallStatus) {
		this.recallStatus = recallStatus;
	}

	@Override
	public String toString() {
		return "Product [productid=" + productId + ", name=" + name
				+ ", description=" + description + ", price=" + price
				+ ", recallStatus=" + recallStatus + "]";
	}


}
