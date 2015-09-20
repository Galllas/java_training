package com.fdmgroup.tradingplatform.bin;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.fdmgroup.tradingplatform.dao.LogRAMDAO;
import com.fdmgroup.tradingplatform.dao.RoleRAMDAO;
import com.fdmgroup.tradingplatform.dao.UserRoleRAMDAO;

public class TradingPlatform {

	List<Person> persons = new ArrayList<Person>();
	LogRAMDAO logRAMDAO;
	UserRoleRAMDAO userRoleRAMDAO;
	RoleRAMDAO roleRAMDAO;
	Request request;
	Portfolio portfolio;
	Person person;
	UserRole userRole;
	Role role;
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	static Logger log = 
			Logger.getLogger(TradingPlatform.class);	
	
	public TradingPlatform(){	
		PropertyConfigurator.configure("log4j.properties");
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	public LogRAMDAO getLogRAMDAO() {
		return logRAMDAO;
	}

	public void setLogRAMDAO(LogRAMDAO logRAMDAO) {
		this.logRAMDAO = logRAMDAO;
	}

	public UserRoleRAMDAO getUserRoleRAMDAO() {
		return userRoleRAMDAO;
	}

	public void setUserRoleRAMDAO(UserRoleRAMDAO userRoleRAMDAO) {
		this.userRoleRAMDAO = userRoleRAMDAO;
	}

	public RoleRAMDAO getRoleRAMDAO() {
		return roleRAMDAO;
	}

	public void setRoleRAMDAO(RoleRAMDAO roleRAMDAO) {
		this.roleRAMDAO = roleRAMDAO;
	}

	public void loginPerson(String password, String userName){ 
		
		person = logRAMDAO.read(userName);
		userRole = userRoleRAMDAO.read(person.getPersonId());
		role = roleRAMDAO.read(userRole.getRoleId());
		person.getRoles().add(role);
		this.persons.add(person);
		log.info("User Logged. " + person);
	}	
	
	public void makeRequest(){
	for(int i = 0; i< persons.size(); i++){
		List<Role> roles =  persons.get(i).getRoles();
		for (int j =0; j< roles.size() ; j++){
			String time = df.format(new Date());
			request = roles.get(j).getMakeRequest().makeRequest(0, 0, 0, persons.get(i).getPersonId(), time, "BUY", null, 0, 0, 0, 0, null, null, null);
			log.info("Request Made. " + persons.get(i) + " " + request);
			request = roles.get(j).getMakeRequest().makeRequest(0, 0, 0, persons.get(i).getPersonId(), time, "SELL", null, 0, 0, 0, 0, null, null, null);
			log.info("Request Made. " + persons.get(i) + " " + request);
		}	
		}
	}
	
	public void viewPortfolio(){
	for(int i = 0; i< persons.size(); i++){
		List<Role> roles =  persons.get(i).getRoles();
		for (int j =0; j< roles.size() ; j++){
			portfolio = roles.get(j).getViewPortfolio().viewPortfolio(persons.get(i).getPersonId());
			log.info("Portfolio Viewed. " + persons.get(i) + " " + portfolio);
		}	
		}
	}
	
	
}
