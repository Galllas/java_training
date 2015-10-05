package com.fdmgroup.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.fdmgroup.database.DatabaseExperiment;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDatabaseExperiment {

	@Test
	public void test1Create() throws SQLException, InterruptedException {
		DatabaseExperiment dbe=new DatabaseExperiment();
		assertTrue(dbe.CreateTable());
	}
	
	@Test
	public void test2Query() throws SQLException, InterruptedException {
		DatabaseExperiment dbe=new DatabaseExperiment();
		assertTrue(dbe.QueryTable());
	}
	
	@Test
	public void test3Insert() throws SQLException {
		DatabaseExperiment dbe=new DatabaseExperiment();
		assertTrue(dbe.InsertIntoTable());
	}

	@Test
	public void test4Update() throws SQLException {
		DatabaseExperiment dbe=new DatabaseExperiment();
		assertTrue(dbe.UpdateTable());
	}	
	
	@Test
	public void test5DeleteRow() throws SQLException {
		DatabaseExperiment dbe=new DatabaseExperiment();
		assertTrue(dbe.DeleteFromTable());
	}
	
	@Test
	public void test6CreateDeleteTable() throws SQLException {
		DatabaseExperiment dbe=new DatabaseExperiment();
		assertTrue(dbe.DeleteTable());
	}
}
