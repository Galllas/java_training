package com.fdmgroup.com.business;

public class OrderLine {

	private int productId;
	private int quantity;
	
	public OrderLine(int productId, int quantity){
		this.productId = productId;
		this.quantity = quantity;
	}
	
	public OrderLine(Product product, int quantity){
		this.productId = product.getProductId();
		this.quantity = quantity;
	}	
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	@Override
	public String toString() {
		return "OrderLine [productId=" + productId + ", quantity=" + quantity
				+ "]";
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}





