package com.tcs.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.orderservice.entity.Order;
import com.tcs.orderservice.exceptions.ProductNotFoundException;
import com.tcs.orderservice.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@PostMapping
	public Order createOrder(@RequestBody Order order) {
		try {
			return orderService.createOrder(order);
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@PostMapping("/add")
	public Order addOrder(@RequestBody Order order) {
		return orderService.addOrder(order);
	}

	@GetMapping
	public String helloWorld() {
		return "Hello world 2";
	}
}