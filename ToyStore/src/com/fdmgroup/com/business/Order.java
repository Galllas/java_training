package com.fdmgroup.com.business;

import java.util.ArrayList;

public class Order {
	
	private ArrayList<OrderLine> orderLines = new ArrayList<OrderLine>();
	
	public Order(){}
	
	public Order(OrderLine orderLine){
		this.orderLines.add(orderLine);
	}	

	public ArrayList<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrder(ArrayList<OrderLine> order) {
		this.orderLines = order;
	}
	
	public void addOrderLine(OrderLine orderLine) {
		this.orderLines.add(orderLine);
	}

	@Override
	public String toString() {
		return "Order [orderLines=" + orderLines + "]";
	}
	
	
	
	
}
