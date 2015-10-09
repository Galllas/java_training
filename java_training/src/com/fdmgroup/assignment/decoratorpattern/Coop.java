package com.fdmgroup.assignment.decoratorpattern;

public class Coop extends RentHouse {

	public Coop() {
		description = "Coop";
	}

	@Override
	public double rentCost() {
		// TODO Auto-generated method stub
		return 900;
	}

}
