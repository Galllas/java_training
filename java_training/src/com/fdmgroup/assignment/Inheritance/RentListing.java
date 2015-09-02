package com.fdmgroup.assignment.Inheritance;

public class RentListing extends Listing {

	private double rentpermonth;
	private String minduration;
	
	public RentListing(String listingID, String address, String brokerID, 
			double rentpermonth, String minduration) {
		super(listingID, address, brokerID);
		this.rentpermonth = rentpermonth;
		this.minduration = minduration;
		// TODO Auto-generated constructor stub
	}

	public double getRentpermonth() {
		return rentpermonth;
	}

	public String getMinduration() {
		return minduration;
	}

	public void getProfile(){
		System.out.println(this.getListingID() + " " + this.getAddress() + " " + 
				this.getBrokerID() + " " + this.getRentpermonth() + " " + this.getMinduration());
	}

}
