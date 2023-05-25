package com.codefider.service;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codefider.dao.RestaurantOrderDAO;
import com.codefider.dto.OrderResponseDTO;
import com.codefider.entity.Order;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantOrderDAO orderRepo;

	public String greeting() {
		return "Welcome to Swiggy Restaurant service";
	}

	public String orderDetailsSave(Order order) {
		order.setOrderId(generateOrderId());
		order.setOrderDate(LocalDateTime.now());

		Order orderSaved = orderRepo.save(order);
		if (orderSaved != null) {
			return "Order details saved";
		} else {
			return "Order details not able to save";
		}
	}

	public OrderResponseDTO getOrder(String orderId) {
		Order or = orderRepo.findByOrderId(orderId);
		// Create a ModelMapper instance
		OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
		BeanUtils.copyProperties(or, orderResponseDTO);

		return orderResponseDTO;

	}

	public String generateOrderId() {
		AtomicLong counter = new AtomicLong(0);
		long timestamp = System.currentTimeMillis();
		long sequenceNumber = counter.incrementAndGet();
		return "ORD-" + timestamp + "-" + sequenceNumber;
	}
}
