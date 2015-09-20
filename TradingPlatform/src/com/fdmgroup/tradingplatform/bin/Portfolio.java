package com.fdmgroup.tradingplatform.bin;

import java.util.Set;

public class Portfolio {

	Person person;
	CurrentShareholderShares currentShareholderShares;
	SecurityRole securityRole;
	Set<Request> requests;
	Set<Trade> trades;
	
	public Portfolio(Person person, CurrentShareholderShares currentShareholderShares, SecurityRole securityRole,
			Set<Request> requests, Set<Trade> trades) {
		super();
		this.person = person;
		this.currentShareholderShares = currentShareholderShares;
		this.securityRole = securityRole;
		this.requests = requests;
		this.trades = trades;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public CurrentShareholderShares getCurrentShareholderShares() {
		return currentShareholderShares;
	}

	public void setCurrentShareholderShares(CurrentShareholderShares currentShareholderShares) {
		this.currentShareholderShares = currentShareholderShares;
	}

	public SecurityRole getSecurityRole() {
		return securityRole;
	}

	public void setSecurityRole(SecurityRole securityRole) {
		this.securityRole = securityRole;
	}

	public Set<Request> getRequests() {
		return requests;
	}

	public void setRequests(Set<Request> requests) {
		this.requests = requests;
	}

	public Set<Trade> getTrades() {
		return trades;
	}

	public void setTrades(Set<Trade> trades) {
		this.trades = trades;
	}

	@Override
	public String toString() {
		return "Portfolio [person=" + person + ", currentShareholderShares=" + currentShareholderShares
				+ ", securityRole=" + securityRole + ", requests=" + requests + ", trades=" + trades + "]";
	}
	
	
}
