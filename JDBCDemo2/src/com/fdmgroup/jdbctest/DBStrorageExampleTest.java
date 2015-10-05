package com.fdmgroup.jdbctest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.fdmgroup.jdbcdemo.DBStorageExample;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DBStrorageExampleTest {
	
	private DBStorageExample dbstorageexample;
	
	@Before
	public void init(){
		dbstorageexample=new DBStorageExample();
	}

	@Test
	public void test2InsertingData() {
		try {
			assertTrue(dbstorageexample.addRecords());
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	@Test
	public void test1RetrievingData() {
		try {
			assertTrue(dbstorageexample.printRecords());
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}

	
	@Test
	public void test3DeleteData() {
		try {
			assertTrue(dbstorageexample.deleteRecords());
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
}









