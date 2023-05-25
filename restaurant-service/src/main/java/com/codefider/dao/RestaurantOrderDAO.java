package com.codefider.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codefider.entity.Order;

@Repository
public interface RestaurantOrderDAO extends JpaRepository<Order, Long> {

	Order findByOrderId(String orderId);

}
