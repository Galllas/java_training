package com.fdmgroup.com.exceptions;

import com.fdmgroup.com.exceptions.OutOfStockException;

public class InventoryLowException extends OutOfStockException {

	private static final long serialVersionUID = 1L;

	public InventoryLowException(String message) {
		super(message);
		
	}

}
