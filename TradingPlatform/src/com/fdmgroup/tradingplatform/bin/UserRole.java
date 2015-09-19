package com.fdmgroup.tradingplatform.bin;

public class UserRole {
	
	private int personId;
	private int roleId;
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	@Override
	public String toString() {
		return "UserRole [personId=" + personId + ", roleId=" + roleId + "]";
	}
	
}

