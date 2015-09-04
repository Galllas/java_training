package com.fdmgroup.assignment.ObserverPattern;

public class User implements Observer {
	
	private Observable observable = null;
	
	public User(Observable observable){
		this.observable = observable;
		observable.addObserver(this);
	}
	
	@Override
	public void update() {
		System.out.println("New Book!");
	}

	public void buyBook(){
		
	}
	
	public void unsubscribe(){
		observable.removeobserver(this);
	}
	
}
