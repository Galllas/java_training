package com.examples.store;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="JPA_PRODUCT")
public class Product {

	@Id
	@Column(name = "ID")
	int itemID;
	
	@Column(name = "NAME")
	String itemName;
	
	@Column(name = "PRICE")
	int dollarPrice;
	
	@Column(name = "QUANTITY")
	int quantityInStock;

	@ManyToOne			
	@JoinColumn(name = "DEPT_ID")
	Department dept;
	
	public Product(int itemID, String itemName, int dollarPrice,
			int quantityInStock, Department dept) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.dollarPrice = dollarPrice;
		this.quantityInStock = quantityInStock;
		this.dept = dept;
	}

	public Product(){
		
	}
	
	public int getDollarPrice(){
		return dollarPrice;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public void setDollarPrice(int dollarPrice) {
		this.dollarPrice = dollarPrice;
	}
	
	@Override
	public String toString() {
		return itemName+"\n$"+dollarPrice+"\nin stock: "+quantityInStock+
				"\ndept: "+dept.name;
	}
	
}
