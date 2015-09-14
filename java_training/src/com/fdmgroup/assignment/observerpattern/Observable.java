package com.fdmgroup.assignment.observerpattern;

public interface Observable {

	public void addObserver(Observer o);
	public void removeobserver(Observer o);
	public void notifyObserver();
	
}
