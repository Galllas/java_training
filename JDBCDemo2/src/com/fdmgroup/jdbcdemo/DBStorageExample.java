package com.fdmgroup.jdbcdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBStorageExample {
	private Connection connection = null;
	private Properties properties = null;
	private PreparedStatement stmt = null;

	public boolean printRecords() throws SQLException {

		String query;
		int id;
		String city, country;
		

		try {
			connection = DBConnector.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
			
		}
		properties = SQLProperties
				.getProperties("dml.properties");
		query = properties.getProperty("RetrievePlace");

		stmt = connection.prepareStatement(query);
		stmt.setInt(1, 5);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			id = (rs.getInt(1));
			
			city = rs.getString(2);
			
			country = (rs.getString(3));
			
				System.out.println(id + " " + city + " " + country);
		}
		return true;
	}

	public boolean addRecords() throws SQLException {
		String query;
		try {
			connection = DBConnector.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;

		}
		properties = SQLProperties
				.getProperties("dml.properties");
		
		
		query = properties.getProperty("CreatePlace");

		stmt = connection.prepareStatement(query);

		stmt.setInt(1, 99);
		stmt.setString(2, "Herndon");
		stmt.setString(3, "VA");
		stmt.executeUpdate();		
		
		return true;

	}
	
	
	public boolean deleteRecords() throws SQLException {
		String query;
		try {
			connection = DBConnector.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;

		}
		properties = SQLProperties
				.getProperties("dml.properties");
				
		query = properties.getProperty("DeletePlace");
		stmt = connection.prepareStatement(query);
		stmt.setInt(1, 99);
		stmt.executeUpdate();
	
		return true;

	}
	
	
}