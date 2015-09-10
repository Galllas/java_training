package com.fdmgroup.com.exceptions;

import com.fdmgroup.com.exceptions.OutOfStockException;

public class ProductRecallException extends OutOfStockException {

	private static final long serialVersionUID = 1L;

	public ProductRecallException(String message) {
		super(message);
	}
	
}
