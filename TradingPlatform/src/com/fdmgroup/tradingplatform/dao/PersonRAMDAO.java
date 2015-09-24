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
		PersonJDBC personJDBC = new PersonJDBC();
		try {
			personJDBC.createRecord(t);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Person read(int id) {
		PersonJDBC personJDBC = new PersonJDBC();
		try {
			return personJDBC.readRecords(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Person t) {
		PersonJDBC personJDBC = new PersonJDBC();
		try {
			personJDBC.updateRecord(t);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Person t) {
		PersonJDBC personJDBC = new PersonJDBC();
		try {
			personJDBC.deleteRecord(t);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
