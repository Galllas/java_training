package com.fdmgroup.jdbctest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.fdmgroup.jdbcdemo.DBStorageExample;
import com.fdmgroup.jdbcdemo.Person;
import com.fdmgroup.jdbcdemo.PersonJDBC;
import com.fdmgroup.jdbcdemo.Role;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonJDBCTest {

	private PersonJDBC personJDBC;
	
	@Before
	public void init(){
		personJDBC = new PersonJDBC();
	}
	
	@Test
	public void test1QueryByUsername() {
		try {
			personJDBC.readRecords("D");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2ById() {
		try {
			personJDBC.readRecords(10);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}

//	@Test
//	public void test3Create() {
//		try {
//			personJDBC.createRecord(new Person(20, "Liang", "Ned", "Gates", "secret", new ArrayList<Role>()));
//		} catch (SQLException e) {
//		
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void test4Update() {
		try {
			personJDBC.updateRecord(new Person(20, "Liiiiiang", "Need", "Gates", "secret", new ArrayList<Role>()));
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void test5Delete() {
//		try {
//			personJDBC.deleteRecord(new Person(20, "Liang", "Ned", "Gates", "secret", new ArrayList<Role>()));
//		} catch (SQLException e) {
//		
//			e.printStackTrace();
//		}
//	}
}
