package com.fdmgroup.com.frontdoor;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.fdmgroup.com.business.*;
import com.fdmgroup.com.exceptions.InventoryLowException;
import com.fdmgroup.com.exceptions.OutOfStockException;
import com.fdmgroup.com.exceptions.ProductRecallException;


public class ToyStore {

	static Logger log = 
			Logger.getLogger(ToyStore.class);	
	
	public ToyStore(){	
		PropertyConfigurator.configure("log4j.properties");
	}
	
	private ArrayList<Order> orders = new ArrayList<Order>();
	private Inventory inventory = new Inventory();
	
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public void addOrder(Order order){
		orders.add(order);
		log.info("Order Placed. " + order);
	}
	
	public void addProduct(Product product, int amount){
		getInventory().addProduct(product, amount);
		log.info("Product Arrived. " + product + " Quantity:"+ amount);
	}
	
	public void addProduct(int productId, int amount){
		getInventory().addProduct(productId, amount);
		log.info("Product Arrived. " + getInventory().getProducts().get(productId) +" Quantity:" + amount);
	}	
	
	public void completeFirstOrder(){
		if (orders.size() > 0  ){
			Order order = orders.remove(0);
			for (OrderLine orderline : order.getOrderLines()){
				try{
				inventory.removeProduct(orderline.getProductId(), orderline.getQuantity());
				log.info("Product Purchased. " +  orderline);
				}
				catch (ProductRecallException e){log.error("Product is in Recall Status. " + e.getMessage()); }
				catch (InventoryLowException e){log.error("Product is in Low Inventory. " + e.getMessage());}
				catch (OutOfStockException e) {log.error(e.getMessage());}
			}			
		}
	}

//	public static void main(String[] args) {
//		
//		ToyStore store = new ToyStore();
//		
//		Product p1 = new Product("bike", "light", 100, false);
//		Product p2 = new Product("book", "cartoon", 10, false);
//		Product p3 = new Product("juice", "apple", 5, true);
//		
//		store.addProduct(p1, 10);
//		store.addProduct(p2, 20);
//		store.addProduct(p3, 30);
//		
//		OrderLine o1 = new OrderLine(p1, 5);
//		OrderLine o2 = new OrderLine(p2, 5);
//		OrderLine o3 = new OrderLine(p3, 50);
//		
//		Order order = new Order(o1);
//		order.addOrderLine(o2);
//		order.addOrderLine(o3);
//		
//		store.addOrder(order);
//		store.completeFirstOrder();
//		
//	}

}
