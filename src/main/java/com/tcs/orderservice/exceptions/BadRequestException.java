package com.tcs.orderservice.exceptions;

public class BadRequestException extends Exception {
	private String msg = "Bad Request";

	public BadRequestException() {
	}

	public BadRequestException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return msg.toString();
	}
}
