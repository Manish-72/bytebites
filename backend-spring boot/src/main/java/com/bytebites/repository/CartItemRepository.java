package com.bytebites.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytebites.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {


//    CartItem findByFoodIsContaining

}
