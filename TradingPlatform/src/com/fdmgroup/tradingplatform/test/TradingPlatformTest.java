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
import com.fdmgroup.tradingplatform.bin.TradingPlatform;

public class TradingPlatformTest {

	TradingPlatform tp;

	@Before
	public void setUp() throws Exception {

		tp = new TradingPlatform();
	} 

	@Test
	public void testLoginUsers() {
		
		tp.loginPerson("secret", "E");
		tp.loginPerson("secret", "D");
		assertEquals(tp.getPersons().size(), 2);
	}

	@Test
	public void testMakeRequest() {
		
		tp.loginPerson("secret", "E");
		tp.loginPerson("secret", "D");
		tp.makeRequest(tp.getPersons().get(0), null, null, 0, "BUY", null, company, 0,
				0, null, null, null);
		Thread.sleep(2000);   
		tp.makeRequest(tp.getPersons().get(1), null, null, 0, "Sell", null, company, 0,
				0, null, null, null);		
		assertEquals(tp.getPersons().size(), 2);
	}
//	
//	@Test
//	public void testViewPortfolio() {
//		tp.loginPerson("123456", "jadams");
//		tp.loginPerson("123456", "rgates");
//		tp.viewPortfolio(janeShareholder);	
//		tp.viewPortfolio(raviAdmin);
//		verify(raviAdmin, times(2)).getRoles();
//		verify(janeShareholder, times(2)).getRoles();		
//	}	
//	
	
	
	
	
}
