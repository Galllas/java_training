package com.fdmgroup.com.business;

import java.util.HashMap;
import java.util.Map;

import com.fdmgroup.com.exceptions.InventoryLowException;
import com.fdmgroup.com.exceptions.OutOfStockException;
import com.fdmgroup.com.exceptions.ProductRecallException;

public class Inventory {
	
	private static int INITINAL_ID = 1; 
	private static int productId = INITINAL_ID;
	private static int idIncrement = 1;
	
	private Map<Integer, Integer> productNums = new HashMap<Integer, Integer>();
	private Map<Integer, Product> products = new HashMap<Integer, Product>();
	
	public Map<Integer, Integer> getProductNums() {
		return productNums;
	}
	
	public void setProductNums(Map<Integer, Integer> productNums) {
		this.productNums = productNums;
	}

	public void setProducts(Map<Integer, Product> products) {
		this.products = products;
	}

	public Map<Integer, Product> getProducts() {
		return products;
	}
	
	public void addProduct(Product product, int number){
		
		if (products.containsKey(product.getProductId())){
			productNums.put(product.getProductId(), productNums.get(product.getProductId()) + number);
		}
		else {
			product.setProductid(productId);
			productId += idIncrement;
			products.put(product.getProductId(), product);
			productNums.put(product.getProductId(), number);
		}
	}
	
	public void addProduct(int productId, int number){
		if (products.containsKey(productId)){
		productNums.put(productId, productNums.get(productId) + number);
		}
	}
	
	public boolean isRecallStatus(int productId){
		if (products.containsKey(productId) && products.get(productId).isRecallStatus()){
			return true;
		}
		return false;
	}
	
	public boolean hasInventory(int productId, int number){
		if (products.containsKey(productId) && productNums.get(productId) - number >= 0){
			return true;
		}
		return false;
	}
	
	public void removeProduct(int productId, int number) throws OutOfStockException {
		
		if (products.containsKey(productId)){
				if (!isRecallStatus(productId) && hasInventory(productId, number)){
			productNums.put(productId, productNums.get(productId) - number);
		}
		else if (isRecallStatus(productId)){
			throw new ProductRecallException( products.get(productId) +" Quantity:"+ productNums.get(productId));
		}
		else if (!hasInventory(productId, number)){
			throw new InventoryLowException( products.get(productId) + " Quantity:"+ productNums.get(productId) + " Required:"+ number );
		}
		}
		else throw new OutOfStockException ("No ProductId " + productId + " in Store.");
	}
	


	
	
	
}
