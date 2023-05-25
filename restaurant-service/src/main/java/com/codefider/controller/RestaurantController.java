package com.codefider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codefider.dto.OrderResponseDTO;
import com.codefider.entity.Order;
import com.codefider.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantService service;

	@GetMapping
	public String greetingMessage() {
		return service.greeting();
	}

	@GetMapping("/orders/status/{orderId}")
	public OrderResponseDTO getOrder(@PathVariable String orderId) {
		return service.getOrder(orderId);
	}

	@PostMapping("/order")
	public ResponseEntity<Object> orderFromCustomer(@RequestBody Order order) {
		return new ResponseEntity<Object>(service.orderDetailsSave(order), HttpStatus.OK);

	}

}
