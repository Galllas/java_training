package com.fdmgroup.tradingplatform.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.tradingplatform.bin.CurrentShareholderShares;
import com.fdmgroup.tradingplatform.bin.Person;
import com.fdmgroup.tradingplatform.bin.Portfolio;
import com.fdmgroup.tradingplatform.bin.Request;
import com.fdmgroup.tradingplatform.bin.Role;
import com.fdmgroup.tradingplatform.bin.SecurityRole;
import com.fdmgroup.tradingplatform.bin.Trade;
import com.fdmgroup.tradingplatform.bin.TradingPlatform;
import com.fdmgroup.tradingplatform.bin.UserRole;
import com.fdmgroup.tradingplatform.dao.CurrentShareholderSharesRAMDAO;
import com.fdmgroup.tradingplatform.dao.LogRAMDAO;
import com.fdmgroup.tradingplatform.dao.PersonRAMDAO;
import com.fdmgroup.tradingplatform.dao.RequestRAMDAO;
import com.fdmgroup.tradingplatform.dao.RoleRAMDAO;
import com.fdmgroup.tradingplatform.dao.SecurityRoleRAMDAO;
import com.fdmgroup.tradingplatform.dao.TradeRAMDAO;
import com.fdmgroup.tradingplatform.dao.UserRoleRAMDAO;
import com.fdmgroup.tradingplatform.interfaces.AdministratorViewPortfolio;
import com.fdmgroup.tradingplatform.interfaces.OtherViewPortfolio;

public class TradingPlatformTest {

	TradingPlatform tp;
	Role roleSharh, roleAdmin;
	Person janeShareholder, raviAdmin;
	Request request, janeRequest, raviRequest;
	Portfolio portfolio;
	UserRole userRoleJane, userRoleRavi;
	Trade janeTrade, raviTrade;
	ArrayList<Role> janeRoles, raviRoles;
	AdministratorViewPortfolio adminPortfolio;
	OtherViewPortfolio otherPortfolio;
	LogRAMDAO logRAMDAO;
	UserRoleRAMDAO userRoleRAMDAO;
	RoleRAMDAO roleRAMDAO;
	PersonRAMDAO personRAMDAO;
	RequestRAMDAO requestRAMDAO;
	TradeRAMDAO tradeRAMDAO;
	CurrentShareholderSharesRAMDAO currentShareholderSharesRAMDAO;
	SecurityRoleRAMDAO securityRoleRAMDAO;
	CurrentShareholderShares janeCurrent, raviCurrent;
	SecurityRole raviSecurity;

	@Before
	public void setUp() throws Exception {

		tp = new TradingPlatform();
		
		janeShareholder = mock(Person.class);
		raviAdmin = mock(Person.class);
		janeRoles = new ArrayList<Role>();
		raviRoles = new ArrayList<Role>();
		
		when(janeShareholder.getPersonId()).thenReturn(1);
		when(raviAdmin.getPersonId()).thenReturn(2);
		when(janeShareholder.getRoles()).thenReturn(janeRoles);		
		when(raviAdmin.getRoles()).thenReturn(raviRoles);
		
		userRoleJane = new UserRole(1, 1);
		userRoleRavi = new UserRole(2, 2);
		
		roleSharh = new Role(1, "Shareholder");
		roleAdmin = new Role(2, "Administrator");
		
		logRAMDAO = mock(LogRAMDAO.class);
		userRoleRAMDAO = mock(UserRoleRAMDAO.class);
		roleRAMDAO = mock(RoleRAMDAO.class);	
		
		tp.setLogRAMDAO(logRAMDAO);
		tp.setUserRoleRAMDAO(userRoleRAMDAO);
		tp.setRoleRAMDAO(roleRAMDAO);		
		
		when(logRAMDAO.read("jadams")).thenReturn(janeShareholder);
		when(logRAMDAO.read("rgates")).thenReturn(raviAdmin);
		when(userRoleRAMDAO.read(janeShareholder.getPersonId())).thenReturn(userRoleJane);
		when(userRoleRAMDAO.read(raviAdmin.getPersonId())).thenReturn(userRoleRavi);
		when(roleRAMDAO.read(userRoleJane.getRoleId())).thenReturn(roleSharh);
		when(roleRAMDAO.read(userRoleRavi.getRoleId())).thenReturn(roleAdmin);
		
		personRAMDAO = mock(PersonRAMDAO.class);
		requestRAMDAO = mock(RequestRAMDAO.class);
		tradeRAMDAO = mock(TradeRAMDAO.class);
		currentShareholderSharesRAMDAO = mock(CurrentShareholderSharesRAMDAO.class);
		securityRoleRAMDAO = mock(SecurityRoleRAMDAO.class);
		
		janeRequest = mock(Request.class);
		raviRequest = mock(Request.class);
		janeTrade = mock(Trade.class);
		raviTrade = mock(Trade.class);
		janeCurrent = mock(CurrentShareholderShares.class);
		raviSecurity = mock(SecurityRole.class);
		
		((AdministratorViewPortfolio) roleAdmin.getViewPortfolio()).setPersonRAMDAO(personRAMDAO);
		((AdministratorViewPortfolio) roleAdmin.getViewPortfolio()).setRequestRAMDAO(requestRAMDAO);
		((AdministratorViewPortfolio) roleAdmin.getViewPortfolio()).setTradeRAMDAO(tradeRAMDAO);
		((AdministratorViewPortfolio) roleAdmin.getViewPortfolio()).setCurrentShareholderSharesRAMDAO(currentShareholderSharesRAMDAO);
		((AdministratorViewPortfolio) roleAdmin.getViewPortfolio()).setSecurityRoleRAMDAO(securityRoleRAMDAO);
		
		((OtherViewPortfolio) roleSharh.getViewPortfolio()).setPersonRAMDAO(personRAMDAO);
		((OtherViewPortfolio) roleSharh.getViewPortfolio()).setRequestRAMDAO(requestRAMDAO);
		((OtherViewPortfolio) roleSharh.getViewPortfolio()).setTradeRAMDAO(tradeRAMDAO);
		((OtherViewPortfolio) roleSharh.getViewPortfolio()).setCurrentShareholderSharesRAMDAO(currentShareholderSharesRAMDAO);		
		
		when(personRAMDAO.read(janeShareholder.getPersonId())).thenReturn(janeShareholder);
		when(personRAMDAO.read(raviAdmin.getPersonId())).thenReturn(raviAdmin);
		when(requestRAMDAO.read(janeShareholder.getPersonId())).thenReturn(janeRequest);
		when(requestRAMDAO.read(raviAdmin.getPersonId())).thenReturn(raviRequest);
		when(tradeRAMDAO.read(janeShareholder.getPersonId())).thenReturn(janeTrade);
		when(tradeRAMDAO.read(raviAdmin.getPersonId())).thenReturn(raviTrade);
		when(currentShareholderSharesRAMDAO.read(raviAdmin.getPersonId())).thenReturn(raviCurrent);
		when(currentShareholderSharesRAMDAO.read(janeShareholder.getPersonId())).thenReturn(janeCurrent);
		when(securityRoleRAMDAO.read(raviAdmin.getPersonId())).thenReturn(raviSecurity);		
		
	} 

	@Test
	public void testLoginUsers() {
		tp.loginPerson("123456", "jadams");
		tp.loginPerson("123456", "rgates");
		assertEquals(tp.getPersons().size(), 2);
	}

	@Test
	public void testMakeRequest() {
		tp.loginPerson("123456", "jadams");
		tp.loginPerson("123456", "rgates");
		tp.makeRequest();
		verify(raviAdmin, times(2)).getRoles();
		verify(janeShareholder, times(2)).getRoles();		
	}
	
	@Test
	public void testViewPortfolio() {
		tp.loginPerson("123456", "jadams");
		tp.loginPerson("123456", "rgates");
		tp.viewPortfolio();		
		verify(raviAdmin, times(2)).getRoles();
		verify(janeShareholder, times(2)).getRoles();		
	}	
	
	
}
