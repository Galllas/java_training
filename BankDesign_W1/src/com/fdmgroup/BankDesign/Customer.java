package com.fdmgroup.BankDesign;

import java.util.ArrayList;
import java.util.List;

/**
 * Create abstract class customer implements method from interface, override constructor to create customer 
 * directly while given name, address and taxID. 
 * @author gang.zhao
 *
 */

public abstract class Customer implements ResetAccounts {
	
	private static int INITIAL_ID = 2000000;
	private static int currentID = INITIAL_ID;	
	private static int INCREMENT = 7;
	private int customerID;
	private String name;
	private String address;
	private String taxID;

	/*
	 * Maintain a list of all the related accounts to customer
	 */
	// consider changing ref to List<Integer>
	private List<Integer> accountIDs = new ArrayList<Integer>();
	
	protected Customer(String name, String address, String taxID){
		this.setCustomerID(Customer.getCurrentID());
		this.setName(name);
		this.setAddress(address);
		this.setTaxID(taxID);
		this.setAccountIDs();
		Customer.setCurrentID();
	}
	
	public static void setCurrentID() {
		Customer.currentID = Customer.currentID + INCREMENT;
	}

	public static int getCurrentID() {
		return currentID;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getTaxID() {
		return taxID;
	}
	
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}
	
	public List<Integer> getAccountIDs() {
		return accountIDs;
	}
	
	public void setAccountIDs() {
		this.accountIDs = new ArrayList<Integer>();
	}
	
	public void addAccountID(int accountID) {
		this.accountIDs.add(accountID);
	}	
	

}
