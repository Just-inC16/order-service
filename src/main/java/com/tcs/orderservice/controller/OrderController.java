package com.tcs.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.orderservice.client.ProductClient;
import com.tcs.orderservice.entity.Order;
import com.tcs.orderservice.entity.ProductDto;
import com.tcs.orderservice.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductClient productClient;

	@PostMapping
	public Order createOrder(@RequestBody Order order) throws ProductNotFoundException {
		ProductDto product = productClient.getProductById(order.getProductId());
		if (product != null) {
			return orderRepository.save(order);
		} else {
			throw new ProductNotFoundException();
		}
	}
}