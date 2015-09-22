package com.fdmgroup.tradingplatform.dao;

import java.sql.SQLException;

import com.fdmgroup.tradingplatform.bin.Person;
import com.fdmgroup.tradingplatform.jdbc.PersonJDBC;

public class LogRAMDAO {

	public void create(Person t) {
		// TODO Auto-generated method stub
		
	}

	public Person read(String userName) {
		
		PersonJDBC personJDBC = new PersonJDBC();
		try {
			return personJDBC.readRecords(userName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void update(Person t) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Person t) {
		// TODO Auto-generated method stub
		
	}

}
