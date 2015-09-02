package com.fdmgroup.assignment.ObserverPattern;

public class ObserverPatternExample {

	public static void main(String[] args) {
		
		RedDress rd = new RedDress();
		User u1 = new User(rd);
		User u2 = new User(rd);
		User u3 = new User(rd);
		rd.setInStock(true);

	}

}
