package com.fdmgroup.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DatabaseStorageExample {
	
	private String url="jdbc:oracle:thin:@oracle.fdmgroup.com:1521:xe";
	private String username="gangzhao";
	private String password="Oracle101";

	
	private Connection conn;
	

	public boolean printAllRecordsInTable() throws SQLException, InterruptedException{
		
			
			
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		
			conn=DriverManager.getConnection(url,username,password);
			
			Statement stmt1=conn.createStatement();
			
		
			String query="SELECT place.* "
					+ "FROM PLACE";
			
			ResultSet rs = stmt1.executeQuery(query);
//			
//			PreparedStatement stmt = conn.prepareStatement("SELECT place_id,"
//					+ " CITY FROM PLACE WHERE CITY = ?" + " AND PLACE_ID=?");
//			
//			stmt.setString(1,"Moscow");
//			stmt.setInt(2,6);
//			
//			ResultSet rs= stmt.executeQuery();
	

			while(rs.next()){
		          int testid = rs.getInt("Place_id");
		          String name = rs.getString("City");
		          System.out.println( testid + " " + name);
		         
		}
			
			return true;

			
			
	}
	
	public boolean InsertIntoTable() throws SQLException{
		
		
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

		conn = DriverManager.getConnection(url, username, password);
		

		Statement stmt = conn.createStatement();

		String query = "Insert INTO PLACE VALUES(14,'LA', 'USA')";
		stmt.executeUpdate(query);
		
		
//		conn.commit();
		
		return true;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}}
