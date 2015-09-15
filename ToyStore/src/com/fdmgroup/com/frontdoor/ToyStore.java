package com.fdmgroup.com.frontdoor;
import java.util.ArrayList;
import java.util.List;

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
	
	private List<Order> orders = new ArrayList<Order>();
	private Inventory inventory = new Inventory();
	
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
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
				catch (ProductRecallException e){
					log.error("Product is in Recall Status. " + e.getMessage());
					}
				catch (InventoryLowException e){
					log.error("Product is in Low Inventory. " + e.getMessage());
					}
				catch (OutOfStockException e) {
					log.error(e.getMessage());
					}
			}			
		}
	}

}
