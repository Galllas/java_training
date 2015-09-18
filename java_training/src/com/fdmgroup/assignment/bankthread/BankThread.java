package com.fdmgroup.assignment.bankthread;

import java.util.ArrayList;
import java.util.List;



public class BankThread {

	
	static class IdGenerator{
		
		private static IdGenerator idGenerate = null;
		private static int INITIAL_ID = 2000000;
		private int idIncrease = 7;
		private int idAssigned = INITIAL_ID - idIncrease;

		public static IdGenerator getInstance() {
			
			if (idGenerate == null) {
				synchronized(IdGenerator.class) {
					if (idGenerate == null) {
						idGenerate = new IdGenerator();
					}
				}
			}
			return idGenerate;
		}
		
		public synchronized int getIdNumber() {
			return idAssigned += idIncrease;	
		}
		
	}
	
	
	class Bank implements Runnable {
		
		private int numberToGet;
		private int value;
		List<Integer> idNumbers = new ArrayList<Integer>();
		
		public Bank(int numberToGet){
			this.numberToGet = numberToGet;
		}
		
		public List<Integer> getIds(){
			return idNumbers;
		}
		
		@Override
		public void run() {
			IdGenerator generator = IdGenerator.getInstance();
			for (int index = 0; index < numberToGet; index++) {
				value = generator.getIdNumber();
				idNumbers.add(value);
			}
		}
		
	}
		
	
	public void showThreads(){
		
		int count = 10;
		
		Bank job1 = new Bank(count);
		Thread worker1 = new Thread(job1);
		worker1.setName("worker1");
	
		Bank job2 = new Bank(count);
		Thread worker2 = new Thread(job2);
		worker2.setName("worker2");
		
		worker1.start();
		worker2.start();	
		
		try {
			worker1.join();
			worker2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(
				 "worker1: "
				+ job1.getIds()
				+ "\n"
				+ "worker2: "
				+ job2.getIds()
				);
		
		
	}
	
	
	public static void main(String[] args) {
		
		BankThread bankThreads = new BankThread();
		bankThreads.showThreads();	

	}

}
