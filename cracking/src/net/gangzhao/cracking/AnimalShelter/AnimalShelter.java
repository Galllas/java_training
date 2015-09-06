package net.gangzhao.cracking.AnimalShelter;

import java.util.LinkedList;

public class AnimalShelter {
	
	private LinkedList<Dog> dogs = new LinkedList<Dog>();
	private LinkedList<Cat> cats = new LinkedList<Cat>();
	
	private int order = 0;
	
	public void enqueue(Animal animal){
		if (animal instanceof Dog) dogs.add((Dog) animal);
		if (animal instanceof Cat) cats.add((Cat) animal);		
		animal.setNumber(order);
		order++;
	}
	
	public Animal dequeueAny(){
		if (dogs.size() == 0) return dequeueCat();
		if (cats.size() == 0) return dequeueDog();
		
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		
		if (dog.isOlderThan(cat)) {
			return dequeueDog();
		}
		else{
			return dequeueCat();
		}
		
	}
	
	
	public Dog dequeueDog(){
		return dogs.poll();
	}
	
	public Cat dequeueCat(){
		return cats.poll();
	}
		
	public static void main(String[] args) {
		

	}

}
