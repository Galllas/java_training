package net.gangzhao.cracking.AnimalShelter;

public abstract class Animal {
	
	private String name;
	private int number;
	
	public Animal(String name){
	
		this.name = name;
	
	}
	
	public int getNumber(){
		return number;
	}
	
	public void setNumber(int number){
		this.number = number;
		
	}
	
	public boolean isOlderThan(Animal animal){
		return this.number < animal.getNumber();
		
	}
	
}
