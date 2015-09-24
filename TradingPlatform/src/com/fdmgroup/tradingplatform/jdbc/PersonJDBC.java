package com.fdmgroup.tradingplatform.jdbc;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.fdmgroup.tradingplatform.bin.Person;
import com.fdmgroup.tradingplatform.bin.Role;

public class PersonJDBC {
	
	private Connection connection = null;
	private Properties properties = null;
	private PreparedStatement stmt = null;

	public Person readRecords(int id) throws SQLException {

		String query;
		Person person;
		
		try {
			connection = DBConnector.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
			
		}
		properties = SQLProperties
				.getProperties("dml.properties");
		query = properties.getProperty("RetrievePersonById");

		stmt = connection.prepareStatement(query);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			
			person = new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), new ArrayList<Role>());
			//System.out.println(person);
			return person;
		}
		return null;
	}
	
	public Person readRecords(String userName) throws SQLException {

		String query;
		Person person;
		
		try {
			connection = DBConnector.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
			
		}
		properties = SQLProperties
				.getProperties("dml.properties");
		query = properties.getProperty("RetrievePersonByUsername");

		stmt = connection.prepareStatement(query);
		stmt.setString(1, userName);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			
			person = new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), new ArrayList<Role>());
			//System.out.println(person);
			return person;
		}
		return null;
	}
	
	public void createRecord(Person person) throws SQLException {

		String query;
		
		try {
			connection = DBConnector.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
			
		}
		properties = SQLProperties
				.getProperties("dml.properties");
		query = properties.getProperty("CreatePerson");

		stmt = connection.prepareStatement(query);
		stmt.setInt(1, person.getPersonId());
		stmt.setString(2, person.getUserName());
		stmt.setString(3, person.getFirstname());
		stmt.setString(4, person.getLastName());
		stmt.setString(5, person.getPassword());

		ResultSet rs = stmt.executeQuery();

	}
	
	public void deleteRecord(Person person) throws SQLException {

		String query;
		
		try {
			connection = DBConnector.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
			
		}
		properties = SQLProperties
				.getProperties("dml.properties");
		query = properties.getProperty("DeletePerson");

		stmt = connection.prepareStatement(query);
		stmt.setInt(1, person.getPersonId());

		ResultSet rs = stmt.executeQuery();

	}
	
	public void updateRecord(Person person) throws SQLException {

		String query;
		
		try {
			connection = DBConnector.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
			
		}
		properties = SQLProperties
				.getProperties("dml.properties");
		query = properties.getProperty("DeletePerson");
		
		stmt = connection.prepareStatement(query);
		stmt.setInt(1, person.getPersonId());
		ResultSet rs = stmt.executeQuery();
		
		query = properties.getProperty("CreatePerson");		
		stmt = connection.prepareStatement(query);
		stmt.setInt(1, person.getPersonId());
		stmt.setString(2, person.getUserName());
		stmt.setString(3, person.getFirstname());
		stmt.setString(4, person.getLastName());
		stmt.setString(5, person.getPassword());

		rs = stmt.executeQuery();

	}
	
}

