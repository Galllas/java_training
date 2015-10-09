package com.fdmgroup.assignment.decoratorpattern;

public abstract class RentHouse {

	String description = "Unkown";
	
	public String getDescription(){
		return description;
	}
	
	public abstract double rentCost();
	
}
