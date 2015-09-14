package com.fdmgroup.assignment.observerpattern;

public class ObserverPatternExample {

	public static void main(String[] args) {
		
		Book HFJ = new Book();
		User u1 = new User(HFJ);
		User u2 = new User(HFJ);
		User u3 = new User(HFJ);
		HFJ.setInStock(true);

	}

}
