package com.bytebites.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytebites.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
