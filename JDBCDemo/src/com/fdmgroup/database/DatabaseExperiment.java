package com.fdmgroup.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseExperiment {

	private String url="jdbc:oracle:thin:@oracle.fdmgroup.com:1521:xe";
	private String username="gangzhao";
	private String password="Oracle101";
	private Connection conn;
	
	public boolean CreateTable() throws SQLException{
		
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		conn=DriverManager.getConnection(url,username,password);
		
		Statement stmt=conn.createStatement();
		String query="CREATE TABLE employee (id NUMBER(8) NOT NULL, name VARCHAR(125), location VARCHAR(125))";
		stmt.executeUpdate(query);
		
		String query2="INSERT INTO employee VALUES (1, 'Jane', 'NYC')";
		stmt.executeUpdate(query2);

		String query3="INSERT INTO employee VALUES (2, 'Alex', 'Paris')";
		stmt.executeUpdate(query3);
		
		return true;
	}
	
	public boolean QueryTable() throws SQLException{
		
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		conn=DriverManager.getConnection(url,username,password);
		
		Statement stmt=conn.createStatement();
		String query="SELECT employee.* " + "FROM employee";
		ResultSet rs = stmt.executeQuery(query);

		while(rs.next()){
	          int testid = rs.getInt("id");
	          String name = rs.getString("name");
	          String country = rs.getString("location");
	          System.out.println( testid + " " + name + " lives in " + country);
	}
		
		return true;
	}
	
	public boolean InsertIntoTable() throws SQLException{
		
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		conn=DriverManager.getConnection(url,username,password);
		
		Statement stmt=conn.createStatement();
		String query="INSERT INTO employee VALUES(3, 'Bill', 'London')";
		
		stmt.executeUpdate(query);
		
		query="SELECT employee.* " + "FROM employee";
		ResultSet rs = stmt.executeQuery(query);
		
		System.out.println(" ");
		while(rs.next()){
	          int testid = rs.getInt("id");
	          String name = rs.getString("name");
	          String country = rs.getString("location");
	          System.out.println( testid + " " + name + " lives in " + country);
	}
		
		
		return true;
	}
	
	public boolean UpdateTable() throws SQLException{
		
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		conn=DriverManager.getConnection(url,username,password);
		
		Statement stmt=conn.createStatement();
		String query="UPDATE employee SET id = 4 WHERE name = 'Bill'";
		
		stmt.executeUpdate(query);
		
		query="SELECT employee.* " + "FROM employee";
		ResultSet rs = stmt.executeQuery(query);
		
		System.out.println(" ");
		while(rs.next()){
	          int testid = rs.getInt("id");
	          String name = rs.getString("name");
	          String country = rs.getString("location");
	          System.out.println( testid + " " + name + " lives in " + country);
	}
		
		return true;
	}
	
	public boolean DeleteFromTable() throws SQLException{
		
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		conn=DriverManager.getConnection(url,username,password);
		
		Statement stmt=conn.createStatement();
		String query="DELETE FROM employee WHERE name = 'Bill'";
		
		stmt.executeUpdate(query);
		query="SELECT employee.* " + "FROM employee";
		
		ResultSet rs = stmt.executeQuery(query);
		
		System.out.println(" ");
		while(rs.next()){
	          int testid = rs.getInt("id");
	          String name = rs.getString("name");
	          String country = rs.getString("location");
	          System.out.println( testid + " " + name + " lives in " + country);
	}
		
		return true;
	}
	
	public boolean DeleteTable() throws SQLException{
		
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		conn=DriverManager.getConnection(url,username,password);
		
		Statement stmt=conn.createStatement();
		String query="DROP TABLE employee";
		
		stmt.executeUpdate(query);
		
		return true;
	}
}
