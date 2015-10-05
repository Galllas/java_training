package com.fdmgroup.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.fdmgroup.database.DatabaseStorageExample;

public class TestDatabaseStorageExample {

	@Test
	public void testEvaluatePrintAllRecords() throws SQLException, InterruptedException {
		DatabaseStorageExample dbse=new DatabaseStorageExample();
		assertTrue(dbse.printAllRecordsInTable());
	}
	
	@Test
	public void testEvaluateInsert() throws SQLException {
		DatabaseStorageExample dbse=new DatabaseStorageExample();
		assertTrue(dbse.InsertIntoTable());
	}

}
