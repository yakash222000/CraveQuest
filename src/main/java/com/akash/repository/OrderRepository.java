package com.akash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akash.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    public List<Order> findByCustomer_Id(Long userId);

    public List<Order> findByRestaurant_Id(Long restaurantId);
}
