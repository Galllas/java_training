package com.fdmgroup.tradingplatform.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.tradingplatform.bin.Portfolio;
import com.fdmgroup.tradingplatform.bin.TradingPlatform;


public class TradingPlatformTest {

	private TradingPlatform tp;
	private Portfolio portfolio;

	@Before
	public void setUp() throws Exception {

		tp = new TradingPlatform();
		tp.loginPerson("secret", "E");
		tp.loginPerson("secret", "D");
	} 

	@Test
	public void testLoginUsers() {
		
		assertEquals(tp.getPersons().size(), 2);
	}

	@Test
	
	public void testMakeRequest() {
		
		tp.makeRequest(tp.getPersons().get(0), 0, null, 0, "BUY", "ACTIVE", 2, 0,
				0, "DAY ONLY", null, null);  
		tp.makeRequest(tp.getPersons().get(1), 0, null, 0, "SELL", "ACTIVE", 1, 0,
				0, "DAY ONLY", null, null);

		assertEquals(tp.getRequestRAMDAO().read(5).getBuySell(), "BUY");
		assertEquals(tp.getRequestRAMDAO().read(6).getBuySell(), "SELL");		
	}
	
	@Test
	public void testViewPortfolio1() {
		
		portfolio = tp.viewPortfolio(tp.getPersons().get(0));	
		assertEquals(portfolio.getTrades().size(), 0);
	}	
	
	@Test
	public void testViewPortfolio2() {
		
		portfolio = tp.viewPortfolio(tp.getPersons().get(1));	
		assertEquals(portfolio.getTrades().size(), 0);
	}	
	
}
