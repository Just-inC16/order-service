package com.tcs.orderservice.exceptions;

public class ProductNotFoundException extends Exception {
	private String msg = "Product Not Found";

	public ProductNotFoundException() {
	}

	public ProductNotFoundException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return msg.toString();
	}
}
