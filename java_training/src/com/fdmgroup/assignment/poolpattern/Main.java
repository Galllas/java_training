package com.fdmgroup.assignment.poolpattern;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnimalPool pool = new AnimalPool();
		
		Animal animal = pool.getAnimal();
		animal.setId(1);
		animal.setName("Dog");
		pool.returnAnimal(animal);
		
		System.out.println(" ");
		
		animal = pool.getAnimal();
		animal.setName("Cat");
		System.out.println(animal);
		
	}

}
