package com.fdmgroup.tradingplatform.bin;

import java.util.ArrayList;

public class Person {
	
	private int personId;
	private String password;
	private String userName;
	private String firstName;
	private String lastName;
	private ArrayList<Role> roles;
	
	public int getPerson_id() {
		return personId;
	}
	
	public void setPerson_id(int person_id) {
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
	
	public ArrayList<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(ArrayList<Role> roles) {
		this.roles = roles;
	}
	
	public void addRole(Role role){
		this.roles.add(role);
	}
	
	public void reomveRole(Role role){
		this.roles.remove(role);
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", password=" + password + ", userName=" + userName + ", firstName="
				+ firstName + ", lastName=" + lastName + ", roles=" + roles + "]";
	}	
	
}
