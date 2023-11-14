package com.tcs.orderservice.exceptions;

public class InternalServerError extends Exception {
	private String msg = "Internal Server Error";

	public InternalServerError() {
	}

	public InternalServerError(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return msg.toString();
	}
}
