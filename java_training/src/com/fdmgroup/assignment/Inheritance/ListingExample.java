package com.fdmgroup.assignment.Inheritance;

public class ListingExample {

	public static void main(String[] args) {
		
		Listing rl = new RentListing("0001", "MetroTech 1, Brooklyn", "01", 1000, "3 month");
		Listing sl = new SellListing("0001", "90 5TH AVE, Manhattan", "02", 1200000, 1950);
		
		System.out.println(rl.getAddress());
		System.out.println(sl.getAddress());		
		
		System.out.println(" ");
		
		System.out.println(rl.getProfile());
		System.out.println(sl.getProfile());
		
	}
}
