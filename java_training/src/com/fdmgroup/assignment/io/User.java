package com.fdmgroup.assignment.io;

public class User{
	
	private String name;
	private String address;
	private String email;
	
	public User(String name, String address, String email){
		
		setName(name);
		setAddress(address);
		setEmail(email);
			
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", address=" + address + ", email="
				+ email + "]";
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
