package com.fdmgroup.assignment.Inheritance;

public abstract class Listing {
	
	private String listingID;
	private String address;
	private String brokerID;
	
	public Listing(String listingID, String address, String brokerID){
		this.listingID = listingID;
		this.address = address;
		this.brokerID = brokerID;
	}
	
	public String getListingID() {
		return listingID;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getBrokerID() {
		return brokerID;
	}

	public void getProfile(){

	}
	
	
}
