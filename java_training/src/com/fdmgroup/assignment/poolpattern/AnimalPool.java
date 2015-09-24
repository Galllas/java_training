package com.fdmgroup.assignment.poolpattern;

import java.util.ArrayList;
import java.util.List;

public class AnimalPool {

	List<Animal> animals = new ArrayList<Animal>();
	int released = 0;
	int LIMIT = 2;
	
	public Animal getAnimal(){
		
		if(animals.size()>0){
			
			released = released + 1;
			System.out.println("Got animal from pool");
			return animals.get(0);
			
		} else if(released == LIMIT){
			
			System.err.println("Max no. of animals reached. Try again later");
			
		} else {
			released = released + 1;
			Animal animal = new Animal();
			System.out.println("Got animal from pool");
			return animal;			
		}		
		
		
		return null;
	}
	
	public void returnAnimal(Animal animal){
		released = released - 1;
		animals.add(animal);
		System.out.println("Return animal to pool");
	}

	
}
