package com.fdmgroup.tradingplatform.bin;

import com.fdmgroup.tradingplatform.interfaces.AddUser;
import com.fdmgroup.tradingplatform.interfaces.MakeRequest;
import com.fdmgroup.tradingplatform.interfaces.ViewPortfolio;

public class Role {

	private int roleId;
	private String roleName;
	MakeRequest makeRequest;
	ViewPortfolio viewPortfolio;
	AddUser addUser;
	RoleFactory roleFactory;
	
	public Role(RoleFactory roleFactory, String roleName){
		this.roleName = roleName;
		this.roleFactory = roleFactory;
		
		makeRequest = roleFactory.createRequest(roleName);
		viewPortfolio = roleFactory.createPortfolio(roleName);
		addUser = roleFactory.createUser(roleName);
	}
	
	public Role(int roleId, String roleName) {
		this(new RoleFactory(), roleName);
		this.roleId = roleId;
	}
	
	
	public int getRoleId() {
		return roleId;
	}
	
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public MakeRequest getMakeRequest() {
		return makeRequest;
	}

	public void setMakeRequest(MakeRequest makeRequest) {
		this.makeRequest = makeRequest;
	}
	
	public ViewPortfolio getViewPortfolio() {
		return viewPortfolio;
	}

	public void setViewPortfolio(ViewPortfolio viewPortfolio) {
		this.viewPortfolio = viewPortfolio;
	}

	public AddUser getAddUser() {
		return addUser;
	}

	public void setAddUser(AddUser addUser) {
		this.addUser = addUser;
	}

	public RoleFactory getRoleFactory() {
		return roleFactory;
	}

	public void setRoleFactory(RoleFactory roleFactory) {
		this.roleFactory = roleFactory;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	

}
