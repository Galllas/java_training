package com.fdmgroup.assignment.inheritance;

public abstract class Listing {
	
	private String listingId;
	private String address;
	private String brokerId;
	
	public Listing(String listingID, String address, String brokerID){
		this.listingId = listingID;
		this.address = address;
		this.brokerId = brokerID;
	}
	
	public String getListingID() {
		return listingId;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getBrokerID() {
		return brokerId;
	}
	
	public String getProfile(){
		return  this.getListingID() + " " + this.getAddress() + " " + 
				this.getBrokerID();
	}
	
	
}
