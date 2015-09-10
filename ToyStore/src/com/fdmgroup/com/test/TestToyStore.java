package com.fdmgroup.com.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.com.business.*;
import com.fdmgroup.com.exceptions.InventoryLowException;
import com.fdmgroup.com.exceptions.OutOfStockException;
import com.fdmgroup.com.exceptions.ProductRecallException;
import com.fdmgroup.com.frontdoor.ToyStore;

public class TestToyStore {

	private ToyStore toyStore;
	private Inventory inv;
	private OrderLine ol1, ol2, ol3;
	private ArrayList<OrderLine> ols;
	private Map<Integer, Integer> productNums;
	private Map<Integer, Product> products;
	private Product p1, p2, p3;
	private Order o1;
	
	@Before
	public void setUp()
	{	
		p1 = mock(Product.class);
		p2 = mock(Product.class);
		p3 = mock(Product.class);
		when(p1.getProductId()).thenReturn(1);
		when(p1.isRecallStatus()).thenReturn(true);
		when(p2.getProductId()).thenReturn(2);
		when(p2.isRecallStatus()).thenReturn(false);
		when(p3.getProductId()).thenReturn(3);
		when(p3.isRecallStatus()).thenReturn(false);
		
		ol1 = mock(OrderLine.class);
		ol2 = mock(OrderLine.class);
		ol3 = mock(OrderLine.class);
		when(ol1.getProductId()).thenReturn(1);
		when(ol1.getQuantity()).thenReturn(50);
		when(ol2.getProductId()).thenReturn(2);
		when(ol2.getQuantity()).thenReturn(100);
		when(ol3.getProductId()).thenReturn(3);
		when(ol3.getQuantity()).thenReturn(200);
		
		ArrayList<OrderLine> ols = new ArrayList<OrderLine>();
		ols.add(ol1);
		ols.add(ol2);
		ols.add(ol3);
		
		o1 = mock(Order.class);
		when(o1.getOrderLines()).thenReturn(ols);
		
		inv = new Inventory();
		
		productNums = new HashMap<Integer, Integer>();
		productNums.put(p1.getProductId(), 100);
		productNums.put(p2.getProductId(), 100);
		productNums.put(p3.getProductId(), 100);
		
		products = new HashMap<Integer, Product>();
		products.put(p1.getProductId(), p1);
		products.put(p2.getProductId(), p2);
		products.put(p3.getProductId(), p3);
		
		inv.setProductNums(productNums);
		inv.setProducts(products);	
		
		toyStore = new ToyStore();
		ArrayList<Order> os = new ArrayList<Order>();
		os.add(o1);
		toyStore.setInventory(inv);
		toyStore.setOrders(os);
	}
	
	@Test
	public void testOrderLineProductIdReturn() 
	{	
		int result = ol1.getProductId();
		assertEquals(result, 1);
	}
	
	@Test
	public void testOrderLineQuantityReturn() 
	{	
		int result = ol1.getQuantity();
		assertEquals(result, 50);
	}	
	
	@Test
	public void testProductGetProductIdReturn() 
	{	
		int result = p1.getProductId();
		assertEquals(result, 1);
	}	
	
	@Test
	public void testProductRecallStatusReturn() 
	{	
		boolean result = p1.isRecallStatus();
		assertEquals(result, true);
	}	
	
	@Test
	public void testInventoryRecallStatusReturn() 
	{	
		boolean result = inv.isRecallStatus(3);
		assertEquals(result, false);
	}	
	
	@Test
	public void testInventoryHasInventoryReturn() 
	{	
		boolean result = inv.hasInventory(3, 150);
		assertEquals(result, false);
	}	
	
	@Test(expected=ProductRecallException.class)
	public void testInventoryRemoveProductRecallExceptionReturn() throws OutOfStockException
	{	
		inv.removeProduct(1, 100);
	}		
	
	@Test(expected=InventoryLowException.class)
	public void testInventoryRemoveProductLowExceptionReturn() throws OutOfStockException
	{	
		inv.removeProduct(3, 150);
	}	
	
	@Test(expected= OutOfStockException.class)
	public void testInventoryRemoveProductOutOfStockExceptionReturn() throws OutOfStockException
	{	
		inv.removeProduct(4, 100);
	}		
	
	@Test
	public void testToyStoreCompleteOrderLoopOrderLinesReturn() throws OutOfStockException
	{	
		toyStore.completeFirstOrder();
		verify(o1).getOrderLines();
		verify(ol1).getProductId();
		verify(ol1).getQuantity();
		verify(ol2).getProductId();
		verify(ol2).getQuantity();
		verify(ol3).getProductId();
		verify(ol3).getQuantity();
	}	
	
	
}
