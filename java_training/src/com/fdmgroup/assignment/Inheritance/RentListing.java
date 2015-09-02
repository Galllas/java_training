package com.fdmgroup.assignment.Inheritance;

public class RentListing extends Listing {

	private double rentPerMonth;
	private String minDuration;
	
	public RentListing(String listingID, String address, String brokerID, 
			double rentpermonth, String minduration) {
		super(listingID, address, brokerID);
		this.rentPerMonth = rentpermonth;
		this.minDuration = minduration;
		// TODO Auto-generated constructor stub
	}

	public double getRentpermonth() {
		return rentPerMonth;
	}

	public String getMinduration() {
		return minDuration;
	}

	public String getProfile(){
		return this.getListingID() + " " + this.getAddress() + " " + 
				this.getBrokerID() + " " + this.getRentpermonth() + " " + this.getMinduration();
	}

}
