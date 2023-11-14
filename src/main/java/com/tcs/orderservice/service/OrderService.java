package com.tcs.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.orderservice.client.ProductClient;
import com.tcs.orderservice.entity.Order;
import com.tcs.orderservice.entity.ProductDto;
import com.tcs.orderservice.exceptions.ProductNotFoundException;
import com.tcs.orderservice.repository.OrderRepository;

@Service
public class OrderService {
	private OrderRepository orderRepository;
	private ProductClient productClient;

	@Autowired
	public OrderService(OrderRepository orderRepository, ProductClient productClient) {
		this.orderRepository = orderRepository;
		this.productClient = productClient;
	}

	public Order createOrder(Order order) throws ProductNotFoundException {
		ProductDto product = productClient.getProductById(order.getProductId());
		if (product != null) {
			return orderRepository.save(order);
		} else {
			throw new ProductNotFoundException();
		}
	}

	public Order addOrder(Order order) {
		return orderRepository.save(order);
	}
}
