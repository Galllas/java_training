package com.fdmgroup.tradingplatform.dao;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.fdmgroup.tradingplatform.bin.Person;
import com.fdmgroup.tradingplatform.jdbc.PersonJDBC;

public class LogRAMDAO {

	private EntityManagerFactory emf;

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public Person read(String userName) {
		
		int id;
		PersonJDBC personJDBC = new PersonJDBC();
		
		try {
			id = personJDBC.readRecordId(userName);
			PersonRAMDAO personRAMDAO = new PersonRAMDAO();
			personRAMDAO.setEmf(emf);
			Person person = personRAMDAO.read(id);
			return person;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
