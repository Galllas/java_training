package com.fdmgroup.tradingplatform.interfaces;

import java.util.HashSet;
import java.util.Set;

import com.fdmgroup.tradingplatform.bin.CurrentShareholderShares;
import com.fdmgroup.tradingplatform.bin.Person;
import com.fdmgroup.tradingplatform.bin.Portfolio;
import com.fdmgroup.tradingplatform.bin.Request;
import com.fdmgroup.tradingplatform.bin.Trade;
import com.fdmgroup.tradingplatform.dao.CurrentShareholderSharesRAMDAO;
import com.fdmgroup.tradingplatform.dao.PersonRAMDAO;
import com.fdmgroup.tradingplatform.dao.RequestRAMDAO;
import com.fdmgroup.tradingplatform.dao.TradeRAMDAO;

public class OtherViewPortfolio implements ViewPortfolio {

	Portfolio portfolio;
	Person person;
	Set<Request> requests = new HashSet<Request>();
	Set<Trade> trades = new HashSet<Trade>();
	CurrentShareholderShares currentShareholderShares;
	PersonRAMDAO personRAMDAO;
	RequestRAMDAO requestRAMDAO;
	TradeRAMDAO tradeRAMDAO;
	CurrentShareholderSharesRAMDAO currentShareholderSharesRAMDAO;

	@Override
	public Portfolio viewPortfolio(int personId) {
		
		person = personRAMDAO.read(personId);
		requests.add(requestRAMDAO.read(personId));
		trades.add(tradeRAMDAO.read(personId));
		currentShareholderShares = currentShareholderSharesRAMDAO.read(personId);
		portfolio = new Portfolio(person, currentShareholderShares, null, requests, trades);
		
		return portfolio;
	}

	public PersonRAMDAO getPersonRAMDAO() {
		return personRAMDAO;
	}

	public void setPersonRAMDAO(PersonRAMDAO personRAMDAO) {
		this.personRAMDAO = personRAMDAO;
	}

	public RequestRAMDAO getRequestRAMDAO() {
		return requestRAMDAO;
	}

	public void setRequestRAMDAO(RequestRAMDAO requsetRAMDAO) {
		this.requestRAMDAO = requsetRAMDAO;
	}

	public TradeRAMDAO getTradeRAMDAO() {
		return tradeRAMDAO;
	}

	public void setTradeRAMDAO(TradeRAMDAO tradeRAMDAO) {
		this.tradeRAMDAO = tradeRAMDAO;
	}

	public CurrentShareholderSharesRAMDAO getCurrentShareholderSharesRAMDAO() {
		return currentShareholderSharesRAMDAO;
	}

	public void setCurrentShareholderSharesRAMDAO(CurrentShareholderSharesRAMDAO currentShareholderSharesRAMDAO) {
		this.currentShareholderSharesRAMDAO = currentShareholderSharesRAMDAO;
	}

	
}
