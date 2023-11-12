package com.tcs.orderservice.entity;

import lombok.Data;

@Data
public class ProductDto {
	private Long id;
	private String name;
	private double price;
}