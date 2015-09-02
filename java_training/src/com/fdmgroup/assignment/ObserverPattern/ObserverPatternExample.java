package com.fdmgroup.assignment.ObserverPattern;

public class ObserverPatternExample {

	public static void main(String[] args) {
		
		Book hdj = new Book();
		User u1 = new User(hdj);
		User u2 = new User(hdj);
		User u3 = new User(hdj);
		hdj.setInStock(true);

	}

}
