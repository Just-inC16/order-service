package com.tcs.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}