package com.fdmgroup.assignment.decoratorpattern;

public class Condo extends RentHouse {

	public Condo() {
		description = "Condo";
	}

	@Override
	public double rentCost() {
		// TODO Auto-generated method stub
		return 1200;
	}

}
