package com.fdmgroup.assignment.inheritance;

public class SellListing extends Listing {

	private double price;
	private int builtyear;
	
	public SellListing(String listingID, String address, String brokerID, 
			double price, int builtyear) {
		super(listingID, address, brokerID);
		this.price = price;
		this.builtyear = builtyear;
		// TODO Auto-generated constructor stub
	}

	public double getPrice() {
		return price;
	}

	public int getBuiltyear() {
		return builtyear;
	}

	public String getProfile(){
		return this.getListingID() + " " + this.getAddress() + " " + 
				this.getBrokerID() + " " + this.getPrice() + " " + this.getBuiltyear();
	}

}
