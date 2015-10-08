package com.fdmgroup.tradingplatform.bin;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.fdmgroup.tradingplatform.dao.LogRAMDAO;
import com.fdmgroup.tradingplatform.dao.RequestRAMDAO;
import com.fdmgroup.tradingplatform.dao.RoleRAMDAO;

public class TradingPlatform {

	List<Person> persons = new ArrayList<Person>();
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("storejpa");;
	LogRAMDAO logRAMDAO = new LogRAMDAO();
	RequestRAMDAO requestRAMDAO = new RequestRAMDAO();
	Request request;
	Portfolio portfolio;
	Person person;
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	static Logger log = 
			Logger.getLogger(TradingPlatform.class);	
	
	public TradingPlatform(){	
		PropertyConfigurator.configure("log4j.properties");
		logRAMDAO.setEmf(emf);
		requestRAMDAO.setEmf(emf);
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public void loginPerson(String password, String userName){ 
		
		person = logRAMDAO.read(userName);
		if (person == null || !person.getPassword().equals(password)){
			log.error("Wrong Username or Password.");
		}
		else 
		{
		this.persons.add(person);
		log.info("User Logged. " + person);
		}
	}	
	
	public void makeRequest(Person person, int requestId, Request request, int sharesFilled,
			String buySell, String status, Company company, int shares, int minimumShares,
			String timeInForce, BigDecimal limitPrice, BigDecimal stopPrice){
		Set<Role> roles =  person.getRoles();
		for (Role role : roles){
			String time = df.format(new Date());
			request = role.getMakeRequest().makeRequest(requestId, request, sharesFilled, person, time,
					buySell, status, company, shares, minimumShares, timeInForce, limitPrice, stopPrice);
			requestRAMDAO.create(request);
			log.info("Request Made. " + person + " " + request);
		}	
	}
	
	public void viewPortfolio(Person person){
		Set<Role> roles =  person.getRoles();
		for (Role role : roles){
			portfolio = role.getViewPortfolio().viewPortfolio(person.getPersonId());
			log.info("Portfolio Viewed. " + person + " " + portfolio);
		}	
	}
	
	
}
