package com.fdmgroup.tradingplatform.dao;

import java.sql.SQLException;
import java.util.Set;

import com.fdmgroup.tradingplatform.bin.Person;
import com.fdmgroup.tradingplatform.bin.SecurityRole;
import com.fdmgroup.tradingplatform.jdbc.PersonJDBC;

public class PersonRAMDAO implements IStoreable<Person> {

	private Set<Person> personSet;	
	
	@Override
	public void create(Person t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person read(int id) {
		// TODO Auto-generated method stub
		PersonJDBC personJDBC = new PersonJDBC();
		try {
			return personJDBC.readRecords(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Person t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Person t) {
		// TODO Auto-generated method stub
		
	}

}
