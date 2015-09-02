package com.fdmgroup.assignment.ObserverPattern;

public class User implements Observer {
	
	private Observable observable = null;
	
	public User(Observable observable){
		this.observable = observable;
		observable.addObserver(this);
	}
	
	@Override
	public void update() {
		buyDress();
	}

	public void buyDress(){
		System.out.println("New Red Dress!");
	}
	
	public void unsubscribe(){
		observable.removeobserver(this);
	}
	
}
