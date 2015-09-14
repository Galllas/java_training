package com.fdmgroup.assignment.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class Book implements Observable {

	private List<Observer> users = new ArrayList<Observer>();
	private boolean inStock = true;
	
	public boolean isInStock(){
		return inStock;
	}
	
	public void setInStock(boolean inStock){
		this.inStock = inStock;
		notifyObserver();
	}

	@Override
	public void addObserver(Observer o) {
		users.add(o);
	}

	@Override
	public void removeobserver(Observer o) {
		users.remove(o);
	}

	@Override
	public void notifyObserver() {
		for (Observer user: users){
			user.update();
		}
		
	}
	
}
