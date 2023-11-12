package com.tcs.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tcs.orderservice.entity.ProductDto;

@FeignClient(name = "product-service", url = "localhost:8081")
public interface ProductClient {
	@GetMapping("/products/{id}")
	ProductDto getProductById(@PathVariable Long id);
}