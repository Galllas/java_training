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

import com.fdmgroup.tradingplatform.bin.Company;
import com.fdmgroup.tradingplatform.bin.Portfolio;
import com.fdmgroup.tradingplatform.bin.TradingPlatform;
import com.fdmgroup.tradingplatform.dao.CompanyRAMDAO;

public class TradingPlatformTest {

	TradingPlatform tp;

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
		
		CompanyRAMDAO companyRAMDAO = new CompanyRAMDAO();
		companyRAMDAO.setEmf(tp.getEmf());
		Company company = companyRAMDAO.read(2);
		
		tp.makeRequest(tp.getPersons().get(0), 0, null, 0, "BUY", null, company, 0,
				0, null, null, null);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		
		tp.makeRequest(tp.getPersons().get(1), 0, null, 0, "SELL", null, company, 0,
				0, null, null, null);

		assertEquals(tp.getRequestRAMDAO().read(1).getBuySell(), "BUY");
		assertEquals(tp.getRequestRAMDAO().read(2).getBuySell(), "SELL");		
	}
	
	@Test
	public void testViewPortfolio() {
		
		Portfolio portfolio;
		portfolio = tp.viewPortfolio(tp.getPersons().get(0));	
		assertEquals(portfolio.getRequests().size(), 1);
		
		portfolio = tp.viewPortfolio(tp.getPersons().get(1));
		assertEquals(portfolio.getRequests().size(), 1);
	}	
	
	
}
