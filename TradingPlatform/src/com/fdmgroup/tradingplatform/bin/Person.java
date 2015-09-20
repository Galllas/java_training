package com.fdmgroup.tradingplatform.bin;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	private int personId;
	private String password;
	private String userName;
	private String firstName;
	private String lastName;
	private List<Role> roles = new ArrayList<Role>();
	
	public Person(int personId, String password, String userName, String firstName, String lastName,
			ArrayList<Role> roles) {
		super();
		this.personId = personId;
		this.password = password;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roles = roles;
	}

	public int getPersonId() {
		return personId;
	}
	
	public void setPersonId(int person_id) {
		this.personId = person_id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getFirstname() {
		return firstName;
	}
	
	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public List<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(ArrayList<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", password=" + password + ", userName=" + userName + ", firstName="
				+ firstName + ", lastName=" + lastName + ", roles=" + roles + "]";
	}	
	
}
